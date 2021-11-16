import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { IResProperties } from '../res-properties.model';
import { ResPropertiesService } from '../service/res-properties.service';

@Component({
  templateUrl: './res-properties-delete-dialog.component.html',
})
export class ResPropertiesDeleteDialogComponent {
  resProperties?: IResProperties;

  constructor(protected resPropertiesService: ResPropertiesService, protected activeModal: NgbActiveModal) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.resPropertiesService.delete(id).subscribe(() => {
      this.activeModal.close('deleted');
    });
  }
}
