import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IResProperties, ResProperties } from '../res-properties.model';
import { ResPropertiesService } from '../service/res-properties.service';

@Injectable({ providedIn: 'root' })
export class ResPropertiesRoutingResolveService implements Resolve<IResProperties> {
  constructor(protected service: ResPropertiesService, protected router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IResProperties> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        mergeMap((resProperties: HttpResponse<ResProperties>) => {
          if (resProperties.body) {
            return of(resProperties.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new ResProperties());
  }
}
