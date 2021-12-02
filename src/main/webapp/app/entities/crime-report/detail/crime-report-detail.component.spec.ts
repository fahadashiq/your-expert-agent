import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { CrimeReportDetailComponent } from './crime-report-detail.component';

describe('Component Tests', () => {
  describe('CrimeReport Management Detail Component', () => {
    let comp: CrimeReportDetailComponent;
    let fixture: ComponentFixture<CrimeReportDetailComponent>;

    beforeEach(() => {
      TestBed.configureTestingModule({
        declarations: [CrimeReportDetailComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: { data: of({ crimeReport: { id: 123 } }) },
          },
        ],
      })
        .overrideTemplate(CrimeReportDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CrimeReportDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load crimeReport on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.crimeReport).toEqual(expect.objectContaining({ id: 123 }));
      });
    });
  });
});
