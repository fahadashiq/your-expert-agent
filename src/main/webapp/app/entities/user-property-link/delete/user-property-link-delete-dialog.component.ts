import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { IUserPropertyLink } from '../user-property-link.model';
import { UserPropertyLinkService } from '../service/user-property-link.service';

@Component({
  templateUrl: './user-property-link-delete-dialog.component.html',
})
export class UserPropertyLinkDeleteDialogComponent {
  userPropertyLink?: IUserPropertyLink;

  constructor(protected userPropertyLinkService: UserPropertyLinkService, protected activeModal: NgbActiveModal) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.userPropertyLinkService.delete(id).subscribe(() => {
      this.activeModal.close('deleted');
    });
  }
}
