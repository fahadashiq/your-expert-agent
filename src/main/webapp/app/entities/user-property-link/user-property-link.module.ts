import { NgModule } from '@angular/core';
import { SharedModule } from 'app/shared/shared.module';
import { UserPropertyLinkComponent } from './list/user-property-link.component';
import { UserPropertyLinkDetailComponent } from './detail/user-property-link-detail.component';
import { UserPropertyLinkUpdateComponent } from './update/user-property-link-update.component';
import { UserPropertyLinkDeleteDialogComponent } from './delete/user-property-link-delete-dialog.component';
import { UserPropertyLinkRoutingModule } from './route/user-property-link-routing.module';

@NgModule({
  imports: [SharedModule, UserPropertyLinkRoutingModule],
  declarations: [
    UserPropertyLinkComponent,
    UserPropertyLinkDetailComponent,
    UserPropertyLinkUpdateComponent,
    UserPropertyLinkDeleteDialogComponent,
  ],
  entryComponents: [UserPropertyLinkDeleteDialogComponent],
})
export class UserPropertyLinkModule {}
