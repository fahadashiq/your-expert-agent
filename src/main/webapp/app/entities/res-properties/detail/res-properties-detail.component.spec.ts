import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ResPropertiesDetailComponent } from './res-properties-detail.component';

describe('Component Tests', () => {
  describe('ResProperties Management Detail Component', () => {
    let comp: ResPropertiesDetailComponent;
    let fixture: ComponentFixture<ResPropertiesDetailComponent>;

    beforeEach(() => {
      TestBed.configureTestingModule({
        declarations: [ResPropertiesDetailComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: { data: of({ resProperties: { id: 123 } }) },
          },
        ],
      })
        .overrideTemplate(ResPropertiesDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ResPropertiesDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load resProperties on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.resProperties).toEqual(expect.objectContaining({ id: 123 }));
      });
    });
  });
});
