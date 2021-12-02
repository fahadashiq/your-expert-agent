jest.mock('@angular/router');

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject } from 'rxjs';

import { SearchCriteriaService } from '../service/search-criteria.service';
import { ISearchCriteria, SearchCriteria } from '../search-criteria.model';

import { IUser } from 'app/entities/user/user.model';
import { UserService } from 'app/entities/user/user.service';

import { SearchCriteriaUpdateComponent } from './search-criteria-update.component';

describe('Component Tests', () => {
  describe('SearchCriteria Management Update Component', () => {
    let comp: SearchCriteriaUpdateComponent;
    let fixture: ComponentFixture<SearchCriteriaUpdateComponent>;
    let activatedRoute: ActivatedRoute;
    let searchCriteriaService: SearchCriteriaService;
    let userService: UserService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        declarations: [SearchCriteriaUpdateComponent],
        providers: [FormBuilder, ActivatedRoute],
      })
        .overrideTemplate(SearchCriteriaUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(SearchCriteriaUpdateComponent);
      activatedRoute = TestBed.inject(ActivatedRoute);
      searchCriteriaService = TestBed.inject(SearchCriteriaService);
      userService = TestBed.inject(UserService);

      comp = fixture.componentInstance;
    });

    describe('ngOnInit', () => {
      it('Should call User query and add missing value', () => {
        const searchCriteria: ISearchCriteria = { id: 456 };
        const user: IUser = { id: 69245 };
        searchCriteria.user = user;

        const userCollection: IUser[] = [{ id: 97506 }];
        jest.spyOn(userService, 'query').mockReturnValue(of(new HttpResponse({ body: userCollection })));
        const additionalUsers = [user];
        const expectedCollection: IUser[] = [...additionalUsers, ...userCollection];
        jest.spyOn(userService, 'addUserToCollectionIfMissing').mockReturnValue(expectedCollection);

        activatedRoute.data = of({ searchCriteria });
        comp.ngOnInit();

        expect(userService.query).toHaveBeenCalled();
        expect(userService.addUserToCollectionIfMissing).toHaveBeenCalledWith(userCollection, ...additionalUsers);
        expect(comp.usersSharedCollection).toEqual(expectedCollection);
      });

      it('Should update editForm', () => {
        const searchCriteria: ISearchCriteria = { id: 456 };
        const user: IUser = { id: 52938 };
        searchCriteria.user = user;

        activatedRoute.data = of({ searchCriteria });
        comp.ngOnInit();

        expect(comp.editForm.value).toEqual(expect.objectContaining(searchCriteria));
        expect(comp.usersSharedCollection).toContain(user);
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<SearchCriteria>>();
        const searchCriteria = { id: 123 };
        jest.spyOn(searchCriteriaService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ searchCriteria });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: searchCriteria }));
        saveSubject.complete();

        // THEN
        expect(comp.previousState).toHaveBeenCalled();
        expect(searchCriteriaService.update).toHaveBeenCalledWith(searchCriteria);
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<SearchCriteria>>();
        const searchCriteria = new SearchCriteria();
        jest.spyOn(searchCriteriaService, 'create').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ searchCriteria });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: searchCriteria }));
        saveSubject.complete();

        // THEN
        expect(searchCriteriaService.create).toHaveBeenCalledWith(searchCriteria);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).toHaveBeenCalled();
      });

      it('Should set isSaving to false on error', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<SearchCriteria>>();
        const searchCriteria = { id: 123 };
        jest.spyOn(searchCriteriaService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ searchCriteria });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.error('This is an error!');

        // THEN
        expect(searchCriteriaService.update).toHaveBeenCalledWith(searchCriteria);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).not.toHaveBeenCalled();
      });
    });

    describe('Tracking relationships identifiers', () => {
      describe('trackUserById', () => {
        it('Should return tracked User primary key', () => {
          const entity = { id: 123 };
          const trackResult = comp.trackUserById(0, entity);
          expect(trackResult).toEqual(entity.id);
        });
      });
    });
  });
});
