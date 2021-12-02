import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { ISearchCriteria, getSearchCriteriaIdentifier } from '../search-criteria.model';

export type EntityResponseType = HttpResponse<ISearchCriteria>;
export type EntityArrayResponseType = HttpResponse<ISearchCriteria[]>;

@Injectable({ providedIn: 'root' })
export class SearchCriteriaService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/search-criteria');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  create(searchCriteria: ISearchCriteria): Observable<EntityResponseType> {
    return this.http.post<ISearchCriteria>(this.resourceUrl, searchCriteria, { observe: 'response' });
  }

  update(searchCriteria: ISearchCriteria): Observable<EntityResponseType> {
    return this.http.put<ISearchCriteria>(`${this.resourceUrl}/${getSearchCriteriaIdentifier(searchCriteria) as number}`, searchCriteria, {
      observe: 'response',
    });
  }

  partialUpdate(searchCriteria: ISearchCriteria): Observable<EntityResponseType> {
    return this.http.patch<ISearchCriteria>(
      `${this.resourceUrl}/${getSearchCriteriaIdentifier(searchCriteria) as number}`,
      searchCriteria,
      { observe: 'response' }
    );
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ISearchCriteria>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ISearchCriteria[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  addSearchCriteriaToCollectionIfMissing(
    searchCriteriaCollection: ISearchCriteria[],
    ...searchCriteriaToCheck: (ISearchCriteria | null | undefined)[]
  ): ISearchCriteria[] {
    const searchCriteria: ISearchCriteria[] = searchCriteriaToCheck.filter(isPresent);
    if (searchCriteria.length > 0) {
      const searchCriteriaCollectionIdentifiers = searchCriteriaCollection.map(
        searchCriteriaItem => getSearchCriteriaIdentifier(searchCriteriaItem)!
      );
      const searchCriteriaToAdd = searchCriteria.filter(searchCriteriaItem => {
        const searchCriteriaIdentifier = getSearchCriteriaIdentifier(searchCriteriaItem);
        if (searchCriteriaIdentifier == null || searchCriteriaCollectionIdentifiers.includes(searchCriteriaIdentifier)) {
          return false;
        }
        searchCriteriaCollectionIdentifiers.push(searchCriteriaIdentifier);
        return true;
      });
      return [...searchCriteriaToAdd, ...searchCriteriaCollection];
    }
    return searchCriteriaCollection;
  }
}
