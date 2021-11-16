import { NgModule } from '@angular/core';
import { SharedModule } from 'app/shared/shared.module';
import { ResPropertiesComponent } from './list/res-properties.component';
import { ResPropertiesDetailComponent } from './detail/res-properties-detail.component';
import { ResPropertiesUpdateComponent } from './update/res-properties-update.component';
import { ResPropertiesDeleteDialogComponent } from './delete/res-properties-delete-dialog.component';
import { ResPropertiesRoutingModule } from './route/res-properties-routing.module';

@NgModule({
  imports: [SharedModule, ResPropertiesRoutingModule],
  declarations: [ResPropertiesComponent, ResPropertiesDetailComponent, ResPropertiesUpdateComponent, ResPropertiesDeleteDialogComponent],
  entryComponents: [ResPropertiesDeleteDialogComponent],
})
export class ResPropertiesModule {}
