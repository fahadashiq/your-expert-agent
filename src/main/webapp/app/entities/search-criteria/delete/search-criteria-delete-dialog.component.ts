import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { ISearchCriteria } from '../search-criteria.model';
import { SearchCriteriaService } from '../service/search-criteria.service';

@Component({
  templateUrl: './search-criteria-delete-dialog.component.html',
})
export class SearchCriteriaDeleteDialogComponent {
  searchCriteria?: ISearchCriteria;

  constructor(protected searchCriteriaService: SearchCriteriaService, protected activeModal: NgbActiveModal) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.searchCriteriaService.delete(id).subscribe(() => {
      this.activeModal.close('deleted');
    });
  }
}
