import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { UserPropertyLinkDetailComponent } from './user-property-link-detail.component';

describe('Component Tests', () => {
  describe('UserPropertyLink Management Detail Component', () => {
    let comp: UserPropertyLinkDetailComponent;
    let fixture: ComponentFixture<UserPropertyLinkDetailComponent>;

    beforeEach(() => {
      TestBed.configureTestingModule({
        declarations: [UserPropertyLinkDetailComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: { data: of({ userPropertyLink: { id: 123 } }) },
          },
        ],
      })
        .overrideTemplate(UserPropertyLinkDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(UserPropertyLinkDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load userPropertyLink on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.userPropertyLink).toEqual(expect.objectContaining({ id: 123 }));
      });
    });
  });
});
