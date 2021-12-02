import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { UserPropertyLinkComponent } from '../list/user-property-link.component';
import { UserPropertyLinkDetailComponent } from '../detail/user-property-link-detail.component';
import { UserPropertyLinkUpdateComponent } from '../update/user-property-link-update.component';
import { UserPropertyLinkRoutingResolveService } from './user-property-link-routing-resolve.service';

const userPropertyLinkRoute: Routes = [
  {
    path: '',
    component: UserPropertyLinkComponent,
    data: {
      defaultSort: 'id,asc',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: UserPropertyLinkDetailComponent,
    resolve: {
      userPropertyLink: UserPropertyLinkRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: UserPropertyLinkUpdateComponent,
    resolve: {
      userPropertyLink: UserPropertyLinkRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: UserPropertyLinkUpdateComponent,
    resolve: {
      userPropertyLink: UserPropertyLinkRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(userPropertyLinkRoute)],
  exports: [RouterModule],
})
export class UserPropertyLinkRoutingModule {}
