import { NgModule } from '@angular/core';
import { SharedModule } from 'app/shared/shared.module';
import { CrimeReportComponent } from './list/crime-report.component';
import { CrimeReportDetailComponent } from './detail/crime-report-detail.component';
import { CrimeReportUpdateComponent } from './update/crime-report-update.component';
import { CrimeReportDeleteDialogComponent } from './delete/crime-report-delete-dialog.component';
import { CrimeReportRoutingModule } from './route/crime-report-routing.module';

@NgModule({
  imports: [SharedModule, CrimeReportRoutingModule],
  declarations: [CrimeReportComponent, CrimeReportDetailComponent, CrimeReportUpdateComponent, CrimeReportDeleteDialogComponent],
  entryComponents: [CrimeReportDeleteDialogComponent],
})
export class CrimeReportModule {}
