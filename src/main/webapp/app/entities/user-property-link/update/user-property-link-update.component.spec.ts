jest.mock('@angular/router');

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject } from 'rxjs';

import { UserPropertyLinkService } from '../service/user-property-link.service';
import { IUserPropertyLink, UserPropertyLink } from '../user-property-link.model';

import { IUser } from 'app/entities/user/user.model';
import { UserService } from 'app/entities/user/user.service';
import { IResProperties } from 'app/entities/res-properties/res-properties.model';
import { ResPropertiesService } from 'app/entities/res-properties/service/res-properties.service';

import { UserPropertyLinkUpdateComponent } from './user-property-link-update.component';

describe('Component Tests', () => {
  describe('UserPropertyLink Management Update Component', () => {
    let comp: UserPropertyLinkUpdateComponent;
    let fixture: ComponentFixture<UserPropertyLinkUpdateComponent>;
    let activatedRoute: ActivatedRoute;
    let userPropertyLinkService: UserPropertyLinkService;
    let userService: UserService;
    let resPropertiesService: ResPropertiesService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        declarations: [UserPropertyLinkUpdateComponent],
        providers: [FormBuilder, ActivatedRoute],
      })
        .overrideTemplate(UserPropertyLinkUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(UserPropertyLinkUpdateComponent);
      activatedRoute = TestBed.inject(ActivatedRoute);
      userPropertyLinkService = TestBed.inject(UserPropertyLinkService);
      userService = TestBed.inject(UserService);
      resPropertiesService = TestBed.inject(ResPropertiesService);

      comp = fixture.componentInstance;
    });

    describe('ngOnInit', () => {
      it('Should call User query and add missing value', () => {
        const userPropertyLink: IUserPropertyLink = { id: 456 };
        const user: IUser = { id: 49817 };
        userPropertyLink.user = user;

        const userCollection: IUser[] = [{ id: 10392 }];
        jest.spyOn(userService, 'query').mockReturnValue(of(new HttpResponse({ body: userCollection })));
        const additionalUsers = [user];
        const expectedCollection: IUser[] = [...additionalUsers, ...userCollection];
        jest.spyOn(userService, 'addUserToCollectionIfMissing').mockReturnValue(expectedCollection);

        activatedRoute.data = of({ userPropertyLink });
        comp.ngOnInit();

        expect(userService.query).toHaveBeenCalled();
        expect(userService.addUserToCollectionIfMissing).toHaveBeenCalledWith(userCollection, ...additionalUsers);
        expect(comp.usersSharedCollection).toEqual(expectedCollection);
      });

      it('Should call ResProperties query and add missing value', () => {
        const userPropertyLink: IUserPropertyLink = { id: 456 };
        const resProperties: IResProperties = { id: 17402 };
        userPropertyLink.resProperties = resProperties;

        const resPropertiesCollection: IResProperties[] = [{ id: 29606 }];
        jest.spyOn(resPropertiesService, 'query').mockReturnValue(of(new HttpResponse({ body: resPropertiesCollection })));
        const additionalResProperties = [resProperties];
        const expectedCollection: IResProperties[] = [...additionalResProperties, ...resPropertiesCollection];
        jest.spyOn(resPropertiesService, 'addResPropertiesToCollectionIfMissing').mockReturnValue(expectedCollection);

        activatedRoute.data = of({ userPropertyLink });
        comp.ngOnInit();

        expect(resPropertiesService.query).toHaveBeenCalled();
        expect(resPropertiesService.addResPropertiesToCollectionIfMissing).toHaveBeenCalledWith(
          resPropertiesCollection,
          ...additionalResProperties
        );
        expect(comp.resPropertiesSharedCollection).toEqual(expectedCollection);
      });

      it('Should update editForm', () => {
        const userPropertyLink: IUserPropertyLink = { id: 456 };
        const user: IUser = { id: 27589 };
        userPropertyLink.user = user;
        const resProperties: IResProperties = { id: 28375 };
        userPropertyLink.resProperties = resProperties;

        activatedRoute.data = of({ userPropertyLink });
        comp.ngOnInit();

        expect(comp.editForm.value).toEqual(expect.objectContaining(userPropertyLink));
        expect(comp.usersSharedCollection).toContain(user);
        expect(comp.resPropertiesSharedCollection).toContain(resProperties);
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<UserPropertyLink>>();
        const userPropertyLink = { id: 123 };
        jest.spyOn(userPropertyLinkService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ userPropertyLink });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: userPropertyLink }));
        saveSubject.complete();

        // THEN
        expect(comp.previousState).toHaveBeenCalled();
        expect(userPropertyLinkService.update).toHaveBeenCalledWith(userPropertyLink);
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<UserPropertyLink>>();
        const userPropertyLink = new UserPropertyLink();
        jest.spyOn(userPropertyLinkService, 'create').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ userPropertyLink });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: userPropertyLink }));
        saveSubject.complete();

        // THEN
        expect(userPropertyLinkService.create).toHaveBeenCalledWith(userPropertyLink);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).toHaveBeenCalled();
      });

      it('Should set isSaving to false on error', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<UserPropertyLink>>();
        const userPropertyLink = { id: 123 };
        jest.spyOn(userPropertyLinkService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ userPropertyLink });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.error('This is an error!');

        // THEN
        expect(userPropertyLinkService.update).toHaveBeenCalledWith(userPropertyLink);
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

      describe('trackResPropertiesById', () => {
        it('Should return tracked ResProperties primary key', () => {
          const entity = { id: 123 };
          const trackResult = comp.trackResPropertiesById(0, entity);
          expect(trackResult).toEqual(entity.id);
        });
      });
    });
  });
});
