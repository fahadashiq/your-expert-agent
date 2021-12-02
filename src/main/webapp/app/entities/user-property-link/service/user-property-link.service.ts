import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { IUserPropertyLink, getUserPropertyLinkIdentifier } from '../user-property-link.model';

export type EntityResponseType = HttpResponse<IUserPropertyLink>;
export type EntityArrayResponseType = HttpResponse<IUserPropertyLink[]>;

@Injectable({ providedIn: 'root' })
export class UserPropertyLinkService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/user-property-links');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  create(userPropertyLink: IUserPropertyLink): Observable<EntityResponseType> {
    return this.http.post<IUserPropertyLink>(this.resourceUrl, userPropertyLink, { observe: 'response' });
  }

  update(userPropertyLink: IUserPropertyLink): Observable<EntityResponseType> {
    return this.http.put<IUserPropertyLink>(
      `${this.resourceUrl}/${getUserPropertyLinkIdentifier(userPropertyLink) as number}`,
      userPropertyLink,
      { observe: 'response' }
    );
  }

  partialUpdate(userPropertyLink: IUserPropertyLink): Observable<EntityResponseType> {
    return this.http.patch<IUserPropertyLink>(
      `${this.resourceUrl}/${getUserPropertyLinkIdentifier(userPropertyLink) as number}`,
      userPropertyLink,
      { observe: 'response' }
    );
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IUserPropertyLink>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IUserPropertyLink[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  addUserPropertyLinkToCollectionIfMissing(
    userPropertyLinkCollection: IUserPropertyLink[],
    ...userPropertyLinksToCheck: (IUserPropertyLink | null | undefined)[]
  ): IUserPropertyLink[] {
    const userPropertyLinks: IUserPropertyLink[] = userPropertyLinksToCheck.filter(isPresent);
    if (userPropertyLinks.length > 0) {
      const userPropertyLinkCollectionIdentifiers = userPropertyLinkCollection.map(
        userPropertyLinkItem => getUserPropertyLinkIdentifier(userPropertyLinkItem)!
      );
      const userPropertyLinksToAdd = userPropertyLinks.filter(userPropertyLinkItem => {
        const userPropertyLinkIdentifier = getUserPropertyLinkIdentifier(userPropertyLinkItem);
        if (userPropertyLinkIdentifier == null || userPropertyLinkCollectionIdentifiers.includes(userPropertyLinkIdentifier)) {
          return false;
        }
        userPropertyLinkCollectionIdentifiers.push(userPropertyLinkIdentifier);
        return true;
      });
      return [...userPropertyLinksToAdd, ...userPropertyLinkCollection];
    }
    return userPropertyLinkCollection;
  }
}
