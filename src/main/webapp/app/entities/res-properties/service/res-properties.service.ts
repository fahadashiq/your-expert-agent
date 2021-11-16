import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as dayjs from 'dayjs';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IResProperties, getResPropertiesIdentifier } from '../res-properties.model';

export type EntityResponseType = HttpResponse<IResProperties>;
export type EntityArrayResponseType = HttpResponse<IResProperties[]>;

@Injectable({ providedIn: 'root' })
export class ResPropertiesService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/res-properties');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  create(resProperties: IResProperties): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(resProperties);
    return this.http
      .post<IResProperties>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(resProperties: IResProperties): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(resProperties);
    return this.http
      .put<IResProperties>(`${this.resourceUrl}/${getResPropertiesIdentifier(resProperties) as number}`, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  partialUpdate(resProperties: IResProperties): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(resProperties);
    return this.http
      .patch<IResProperties>(`${this.resourceUrl}/${getResPropertiesIdentifier(resProperties) as number}`, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IResProperties>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IResProperties[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  addResPropertiesToCollectionIfMissing(
    resPropertiesCollection: IResProperties[],
    ...resPropertiesToCheck: (IResProperties | null | undefined)[]
  ): IResProperties[] {
    const resProperties: IResProperties[] = resPropertiesToCheck.filter(isPresent);
    if (resProperties.length > 0) {
      const resPropertiesCollectionIdentifiers = resPropertiesCollection.map(
        resPropertiesItem => getResPropertiesIdentifier(resPropertiesItem)!
      );
      const resPropertiesToAdd = resProperties.filter(resPropertiesItem => {
        const resPropertiesIdentifier = getResPropertiesIdentifier(resPropertiesItem);
        if (resPropertiesIdentifier == null || resPropertiesCollectionIdentifiers.includes(resPropertiesIdentifier)) {
          return false;
        }
        resPropertiesCollectionIdentifiers.push(resPropertiesIdentifier);
        return true;
      });
      return [...resPropertiesToAdd, ...resPropertiesCollection];
    }
    return resPropertiesCollection;
  }

  protected convertDateFromClient(resProperties: IResProperties): IResProperties {
    return Object.assign({}, resProperties, {
      modified: resProperties.modified?.isValid() ? resProperties.modified.toJSON() : undefined,
      openhousedate: resProperties.openhousedate?.isValid() ? resProperties.openhousedate.toJSON() : undefined,
      created: resProperties.created?.isValid() ? resProperties.created.toJSON() : undefined,
      updated: resProperties.updated?.isValid() ? resProperties.updated.toJSON() : undefined,
      modifiedDate: resProperties.modifiedDate?.isValid() ? resProperties.modifiedDate.toJSON() : undefined,
    });
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.modified = res.body.modified ? dayjs(res.body.modified) : undefined;
      res.body.openhousedate = res.body.openhousedate ? dayjs(res.body.openhousedate) : undefined;
      res.body.created = res.body.created ? dayjs(res.body.created) : undefined;
      res.body.updated = res.body.updated ? dayjs(res.body.updated) : undefined;
      res.body.modifiedDate = res.body.modifiedDate ? dayjs(res.body.modifiedDate) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((resProperties: IResProperties) => {
        resProperties.modified = resProperties.modified ? dayjs(resProperties.modified) : undefined;
        resProperties.openhousedate = resProperties.openhousedate ? dayjs(resProperties.openhousedate) : undefined;
        resProperties.created = resProperties.created ? dayjs(resProperties.created) : undefined;
        resProperties.updated = resProperties.updated ? dayjs(resProperties.updated) : undefined;
        resProperties.modifiedDate = resProperties.modifiedDate ? dayjs(resProperties.modifiedDate) : undefined;
      });
    }
    return res;
  }
}
