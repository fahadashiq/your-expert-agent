import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { ICrimeReport, CrimeReport } from '../crime-report.model';
import { CrimeReportService } from '../service/crime-report.service';

@Injectable({ providedIn: 'root' })
export class CrimeReportRoutingResolveService implements Resolve<ICrimeReport> {
  constructor(protected service: CrimeReportService, protected router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ICrimeReport> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        mergeMap((crimeReport: HttpResponse<CrimeReport>) => {
          if (crimeReport.body) {
            return of(crimeReport.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new CrimeReport());
  }
}
