jest.mock('@angular/router');

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject } from 'rxjs';

import { ResPropertiesService } from '../service/res-properties.service';
import { IResProperties, ResProperties } from '../res-properties.model';

import { ResPropertiesUpdateComponent } from './res-properties-update.component';

describe('Component Tests', () => {
  describe('ResProperties Management Update Component', () => {
    let comp: ResPropertiesUpdateComponent;
    let fixture: ComponentFixture<ResPropertiesUpdateComponent>;
    let activatedRoute: ActivatedRoute;
    let resPropertiesService: ResPropertiesService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        declarations: [ResPropertiesUpdateComponent],
        providers: [FormBuilder, ActivatedRoute],
      })
        .overrideTemplate(ResPropertiesUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ResPropertiesUpdateComponent);
      activatedRoute = TestBed.inject(ActivatedRoute);
      resPropertiesService = TestBed.inject(ResPropertiesService);

      comp = fixture.componentInstance;
    });

    describe('ngOnInit', () => {
      it('Should update editForm', () => {
        const resProperties: IResProperties = { id: 456 };

        activatedRoute.data = of({ resProperties });
        comp.ngOnInit();

        expect(comp.editForm.value).toEqual(expect.objectContaining(resProperties));
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<ResProperties>>();
        const resProperties = { id: 123 };
        jest.spyOn(resPropertiesService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ resProperties });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: resProperties }));
        saveSubject.complete();

        // THEN
        expect(comp.previousState).toHaveBeenCalled();
        expect(resPropertiesService.update).toHaveBeenCalledWith(resProperties);
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<ResProperties>>();
        const resProperties = new ResProperties();
        jest.spyOn(resPropertiesService, 'create').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ resProperties });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: resProperties }));
        saveSubject.complete();

        // THEN
        expect(resPropertiesService.create).toHaveBeenCalledWith(resProperties);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).toHaveBeenCalled();
      });

      it('Should set isSaving to false on error', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<ResProperties>>();
        const resProperties = { id: 123 };
        jest.spyOn(resPropertiesService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ resProperties });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.error('This is an error!');

        // THEN
        expect(resPropertiesService.update).toHaveBeenCalledWith(resProperties);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).not.toHaveBeenCalled();
      });
    });
  });
});
