jest.mock('@angular/router');

import { TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { of } from 'rxjs';

import { IResProperties, ResProperties } from '../res-properties.model';
import { ResPropertiesService } from '../service/res-properties.service';

import { ResPropertiesRoutingResolveService } from './res-properties-routing-resolve.service';

describe('ResProperties routing resolve service', () => {
  let mockRouter: Router;
  let mockActivatedRouteSnapshot: ActivatedRouteSnapshot;
  let routingResolveService: ResPropertiesRoutingResolveService;
  let service: ResPropertiesService;
  let resultResProperties: IResProperties | undefined;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [Router, ActivatedRouteSnapshot],
    });
    mockRouter = TestBed.inject(Router);
    mockActivatedRouteSnapshot = TestBed.inject(ActivatedRouteSnapshot);
    routingResolveService = TestBed.inject(ResPropertiesRoutingResolveService);
    service = TestBed.inject(ResPropertiesService);
    resultResProperties = undefined;
  });

  describe('resolve', () => {
    it('should return IResProperties returned by find', () => {
      // GIVEN
      service.find = jest.fn(id => of(new HttpResponse({ body: { id } })));
      mockActivatedRouteSnapshot.params = { id: 123 };

      // WHEN
      routingResolveService.resolve(mockActivatedRouteSnapshot).subscribe(result => {
        resultResProperties = result;
      });

      // THEN
      expect(service.find).toBeCalledWith(123);
      expect(resultResProperties).toEqual({ id: 123 });
    });

    it('should return new IResProperties if id is not provided', () => {
      // GIVEN
      service.find = jest.fn();
      mockActivatedRouteSnapshot.params = {};

      // WHEN
      routingResolveService.resolve(mockActivatedRouteSnapshot).subscribe(result => {
        resultResProperties = result;
      });

      // THEN
      expect(service.find).not.toBeCalled();
      expect(resultResProperties).toEqual(new ResProperties());
    });

    it('should route to 404 page if data not found in server', () => {
      // GIVEN
      jest.spyOn(service, 'find').mockReturnValue(of(new HttpResponse({ body: null as unknown as ResProperties })));
      mockActivatedRouteSnapshot.params = { id: 123 };

      // WHEN
      routingResolveService.resolve(mockActivatedRouteSnapshot).subscribe(result => {
        resultResProperties = result;
      });

      // THEN
      expect(service.find).toBeCalledWith(123);
      expect(resultResProperties).toEqual(undefined);
      expect(mockRouter.navigate).toHaveBeenCalledWith(['404']);
    });
  });
});
