import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { ICrimeReport } from '../crime-report.model';
import { CrimeReportService } from '../service/crime-report.service';

@Component({
  templateUrl: './crime-report-delete-dialog.component.html',
})
export class CrimeReportDeleteDialogComponent {
  crimeReport?: ICrimeReport;

  constructor(protected crimeReportService: CrimeReportService, protected activeModal: NgbActiveModal) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.crimeReportService.delete(id).subscribe(() => {
      this.activeModal.close('deleted');
    });
  }
}
