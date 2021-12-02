import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { ISearchCriteria, SearchCriteria } from '../search-criteria.model';
import { SearchCriteriaService } from '../service/search-criteria.service';

@Injectable({ providedIn: 'root' })
export class SearchCriteriaRoutingResolveService implements Resolve<ISearchCriteria> {
  constructor(protected service: SearchCriteriaService, protected router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ISearchCriteria> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        mergeMap((searchCriteria: HttpResponse<SearchCriteria>) => {
          if (searchCriteria.body) {
            return of(searchCriteria.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new SearchCriteria());
  }
}
