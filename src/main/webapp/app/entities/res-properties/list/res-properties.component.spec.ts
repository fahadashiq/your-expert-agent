import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';

import { ResPropertiesService } from '../service/res-properties.service';

import { ResPropertiesComponent } from './res-properties.component';

describe('Component Tests', () => {
  describe('ResProperties Management Component', () => {
    let comp: ResPropertiesComponent;
    let fixture: ComponentFixture<ResPropertiesComponent>;
    let service: ResPropertiesService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        declarations: [ResPropertiesComponent],
      })
        .overrideTemplate(ResPropertiesComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ResPropertiesComponent);
      comp = fixture.componentInstance;
      service = TestBed.inject(ResPropertiesService);

      const headers = new HttpHeaders().append('link', 'link;link');
      jest.spyOn(service, 'query').mockReturnValue(
        of(
          new HttpResponse({
            body: [{ id: 123 }],
            headers,
          })
        )
      );
    });

    it('Should call load all on init', () => {
      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.resProperties?.[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
  });
});
