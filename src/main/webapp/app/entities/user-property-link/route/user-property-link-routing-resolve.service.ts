import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IUserPropertyLink, UserPropertyLink } from '../user-property-link.model';
import { UserPropertyLinkService } from '../service/user-property-link.service';

@Injectable({ providedIn: 'root' })
export class UserPropertyLinkRoutingResolveService implements Resolve<IUserPropertyLink> {
  constructor(protected service: UserPropertyLinkService, protected router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IUserPropertyLink> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        mergeMap((userPropertyLink: HttpResponse<UserPropertyLink>) => {
          if (userPropertyLink.body) {
            return of(userPropertyLink.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new UserPropertyLink());
  }
}
