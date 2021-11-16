import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IResProperties } from '../res-properties.model';
import { ResPropertiesService } from '../service/res-properties.service';
import { ResPropertiesDeleteDialogComponent } from '../delete/res-properties-delete-dialog.component';

@Component({
  selector: 'jhi-res-properties',
  templateUrl: './res-properties.component.html',
})
export class ResPropertiesComponent implements OnInit {
  resProperties?: IResProperties[];
  isLoading = false;

  constructor(protected resPropertiesService: ResPropertiesService, protected modalService: NgbModal) {}

  loadAll(): void {
    this.isLoading = true;

    this.resPropertiesService.query().subscribe(
      (res: HttpResponse<IResProperties[]>) => {
        this.isLoading = false;
        this.resProperties = res.body ?? [];
      },
      () => {
        this.isLoading = false;
      }
    );
  }

  ngOnInit(): void {
    this.loadAll();
  }

  trackId(index: number, item: IResProperties): number {
    return item.id!;
  }

  delete(resProperties: IResProperties): void {
    const modalRef = this.modalService.open(ResPropertiesDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.resProperties = resProperties;
    // unsubscribe not needed because closed completes on modal close
    modalRef.closed.subscribe(reason => {
      if (reason === 'deleted') {
        this.loadAll();
      }
    });
  }
}
