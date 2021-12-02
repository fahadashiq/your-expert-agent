jest.mock('@angular/router');

import { TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { of } from 'rxjs';

import { IUserPropertyLink, UserPropertyLink } from '../user-property-link.model';
import { UserPropertyLinkService } from '../service/user-property-link.service';

import { UserPropertyLinkRoutingResolveService } from './user-property-link-routing-resolve.service';

describe('UserPropertyLink routing resolve service', () => {
  let mockRouter: Router;
  let mockActivatedRouteSnapshot: ActivatedRouteSnapshot;
  let routingResolveService: UserPropertyLinkRoutingResolveService;
  let service: UserPropertyLinkService;
  let resultUserPropertyLink: IUserPropertyLink | undefined;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [Router, ActivatedRouteSnapshot],
    });
    mockRouter = TestBed.inject(Router);
    mockActivatedRouteSnapshot = TestBed.inject(ActivatedRouteSnapshot);
    routingResolveService = TestBed.inject(UserPropertyLinkRoutingResolveService);
    service = TestBed.inject(UserPropertyLinkService);
    resultUserPropertyLink = undefined;
  });

  describe('resolve', () => {
    it('should return IUserPropertyLink returned by find', () => {
      // GIVEN
      service.find = jest.fn(id => of(new HttpResponse({ body: { id } })));
      mockActivatedRouteSnapshot.params = { id: 123 };

      // WHEN
      routingResolveService.resolve(mockActivatedRouteSnapshot).subscribe(result => {
        resultUserPropertyLink = result;
      });

      // THEN
      expect(service.find).toBeCalledWith(123);
      expect(resultUserPropertyLink).toEqual({ id: 123 });
    });

    it('should return new IUserPropertyLink if id is not provided', () => {
      // GIVEN
      service.find = jest.fn();
      mockActivatedRouteSnapshot.params = {};

      // WHEN
      routingResolveService.resolve(mockActivatedRouteSnapshot).subscribe(result => {
        resultUserPropertyLink = result;
      });

      // THEN
      expect(service.find).not.toBeCalled();
      expect(resultUserPropertyLink).toEqual(new UserPropertyLink());
    });

    it('should route to 404 page if data not found in server', () => {
      // GIVEN
      jest.spyOn(service, 'find').mockReturnValue(of(new HttpResponse({ body: null as unknown as UserPropertyLink })));
      mockActivatedRouteSnapshot.params = { id: 123 };

      // WHEN
      routingResolveService.resolve(mockActivatedRouteSnapshot).subscribe(result => {
        resultUserPropertyLink = result;
      });

      // THEN
      expect(service.find).toBeCalledWith(123);
      expect(resultUserPropertyLink).toEqual(undefined);
      expect(mockRouter.navigate).toHaveBeenCalledWith(['404']);
    });
  });
});
