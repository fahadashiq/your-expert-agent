jest.mock('@angular/router');

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject } from 'rxjs';

import { CrimeReportService } from '../service/crime-report.service';
import { ICrimeReport, CrimeReport } from '../crime-report.model';

import { CrimeReportUpdateComponent } from './crime-report-update.component';

describe('Component Tests', () => {
  describe('CrimeReport Management Update Component', () => {
    let comp: CrimeReportUpdateComponent;
    let fixture: ComponentFixture<CrimeReportUpdateComponent>;
    let activatedRoute: ActivatedRoute;
    let crimeReportService: CrimeReportService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        declarations: [CrimeReportUpdateComponent],
        providers: [FormBuilder, ActivatedRoute],
      })
        .overrideTemplate(CrimeReportUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CrimeReportUpdateComponent);
      activatedRoute = TestBed.inject(ActivatedRoute);
      crimeReportService = TestBed.inject(CrimeReportService);

      comp = fixture.componentInstance;
    });

    describe('ngOnInit', () => {
      it('Should update editForm', () => {
        const crimeReport: ICrimeReport = { id: 456 };

        activatedRoute.data = of({ crimeReport });
        comp.ngOnInit();

        expect(comp.editForm.value).toEqual(expect.objectContaining(crimeReport));
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<CrimeReport>>();
        const crimeReport = { id: 123 };
        jest.spyOn(crimeReportService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ crimeReport });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: crimeReport }));
        saveSubject.complete();

        // THEN
        expect(comp.previousState).toHaveBeenCalled();
        expect(crimeReportService.update).toHaveBeenCalledWith(crimeReport);
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<CrimeReport>>();
        const crimeReport = new CrimeReport();
        jest.spyOn(crimeReportService, 'create').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ crimeReport });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: crimeReport }));
        saveSubject.complete();

        // THEN
        expect(crimeReportService.create).toHaveBeenCalledWith(crimeReport);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).toHaveBeenCalled();
      });

      it('Should set isSaving to false on error', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<CrimeReport>>();
        const crimeReport = { id: 123 };
        jest.spyOn(crimeReportService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ crimeReport });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.error('This is an error!');

        // THEN
        expect(crimeReportService.update).toHaveBeenCalledWith(crimeReport);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).not.toHaveBeenCalled();
      });
    });
  });
});
