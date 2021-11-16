import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { ResPropertiesComponent } from '../list/res-properties.component';
import { ResPropertiesDetailComponent } from '../detail/res-properties-detail.component';
import { ResPropertiesUpdateComponent } from '../update/res-properties-update.component';
import { ResPropertiesRoutingResolveService } from './res-properties-routing-resolve.service';

const resPropertiesRoute: Routes = [
  {
    path: '',
    component: ResPropertiesComponent,
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: ResPropertiesDetailComponent,
    resolve: {
      resProperties: ResPropertiesRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: ResPropertiesUpdateComponent,
    resolve: {
      resProperties: ResPropertiesRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: ResPropertiesUpdateComponent,
    resolve: {
      resProperties: ResPropertiesRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(resPropertiesRoute)],
  exports: [RouterModule],
})
export class ResPropertiesRoutingModule {}
