import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IResProperties } from '../res-properties.model';

@Component({
  selector: 'jhi-res-properties-detail',
  templateUrl: './res-properties-detail.component.html',
})
export class ResPropertiesDetailComponent implements OnInit {
  resProperties: IResProperties | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ resProperties }) => {
      this.resProperties = resProperties;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
