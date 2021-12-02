import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICrimeReport } from '../crime-report.model';

@Component({
  selector: 'jhi-crime-report-detail',
  templateUrl: './crime-report-detail.component.html',
})
export class CrimeReportDetailComponent implements OnInit {
  crimeReport: ICrimeReport | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ crimeReport }) => {
      this.crimeReport = crimeReport;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
