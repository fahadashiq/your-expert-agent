import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { CrimeReportComponent } from '../list/crime-report.component';
import { CrimeReportDetailComponent } from '../detail/crime-report-detail.component';
import { CrimeReportUpdateComponent } from '../update/crime-report-update.component';
import { CrimeReportRoutingResolveService } from './crime-report-routing-resolve.service';

const crimeReportRoute: Routes = [
  {
    path: '',
    component: CrimeReportComponent,
    data: {
      defaultSort: 'id,asc',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: CrimeReportDetailComponent,
    resolve: {
      crimeReport: CrimeReportRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: CrimeReportUpdateComponent,
    resolve: {
      crimeReport: CrimeReportRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: CrimeReportUpdateComponent,
    resolve: {
      crimeReport: CrimeReportRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(crimeReportRoute)],
  exports: [RouterModule],
})
export class CrimeReportRoutingModule {}
