import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import { ICrimeReport, CrimeReport } from '../crime-report.model';
import { CrimeReportService } from '../service/crime-report.service';

@Component({
  selector: 'jhi-crime-report-update',
  templateUrl: './crime-report-update.component.html',
})
export class CrimeReportUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    city: [],
    population: [],
    murder: [],
    rape: [],
    robbery: [],
    aggravatedAssault: [],
    propertyCrime: [],
    burglary: [],
    larceny: [],
    vehicleTheft: [],
    arson: [],
  });

  constructor(protected crimeReportService: CrimeReportService, protected activatedRoute: ActivatedRoute, protected fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ crimeReport }) => {
      this.updateForm(crimeReport);
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const crimeReport = this.createFromForm();
    if (crimeReport.id !== undefined) {
      this.subscribeToSaveResponse(this.crimeReportService.update(crimeReport));
    } else {
      this.subscribeToSaveResponse(this.crimeReportService.create(crimeReport));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICrimeReport>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(crimeReport: ICrimeReport): void {
    this.editForm.patchValue({
      id: crimeReport.id,
      city: crimeReport.city,
      population: crimeReport.population,
      murder: crimeReport.murder,
      rape: crimeReport.rape,
      robbery: crimeReport.robbery,
      aggravatedAssault: crimeReport.aggravatedAssault,
      propertyCrime: crimeReport.propertyCrime,
      burglary: crimeReport.burglary,
      larceny: crimeReport.larceny,
      vehicleTheft: crimeReport.vehicleTheft,
      arson: crimeReport.arson,
    });
  }

  protected createFromForm(): ICrimeReport {
    return {
      ...new CrimeReport(),
      id: this.editForm.get(['id'])!.value,
      city: this.editForm.get(['city'])!.value,
      population: this.editForm.get(['population'])!.value,
      murder: this.editForm.get(['murder'])!.value,
      rape: this.editForm.get(['rape'])!.value,
      robbery: this.editForm.get(['robbery'])!.value,
      aggravatedAssault: this.editForm.get(['aggravatedAssault'])!.value,
      propertyCrime: this.editForm.get(['propertyCrime'])!.value,
      burglary: this.editForm.get(['burglary'])!.value,
      larceny: this.editForm.get(['larceny'])!.value,
      vehicleTheft: this.editForm.get(['vehicleTheft'])!.value,
      arson: this.editForm.get(['arson'])!.value,
    };
  }
}
