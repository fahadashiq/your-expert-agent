import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { IUserPropertyLink, UserPropertyLink } from '../user-property-link.model';

import { UserPropertyLinkService } from './user-property-link.service';

describe('UserPropertyLink Service', () => {
  let service: UserPropertyLinkService;
  let httpMock: HttpTestingController;
  let elemDefault: IUserPropertyLink;
  let expectedResult: IUserPropertyLink | IUserPropertyLink[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(UserPropertyLinkService);
    httpMock = TestBed.inject(HttpTestingController);

    elemDefault = {
      id: 0,
      isFavourite: false,
    };
  });

  describe('Service methods', () => {
    it('should find an element', () => {
      const returnedFromService = Object.assign({}, elemDefault);

      service.find(123).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(elemDefault);
    });

    it('should create a UserPropertyLink', () => {
      const returnedFromService = Object.assign(
        {
          id: 0,
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.create(new UserPropertyLink()).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a UserPropertyLink', () => {
      const returnedFromService = Object.assign(
        {
          id: 1,
          isFavourite: true,
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.update(expected).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a UserPropertyLink', () => {
      const patchObject = Object.assign({}, new UserPropertyLink());

      const returnedFromService = Object.assign(patchObject, elemDefault);

      const expected = Object.assign({}, returnedFromService);

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of UserPropertyLink', () => {
      const returnedFromService = Object.assign(
        {
          id: 1,
          isFavourite: true,
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toContainEqual(expected);
    });

    it('should delete a UserPropertyLink', () => {
      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult);
    });

    describe('addUserPropertyLinkToCollectionIfMissing', () => {
      it('should add a UserPropertyLink to an empty array', () => {
        const userPropertyLink: IUserPropertyLink = { id: 123 };
        expectedResult = service.addUserPropertyLinkToCollectionIfMissing([], userPropertyLink);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(userPropertyLink);
      });

      it('should not add a UserPropertyLink to an array that contains it', () => {
        const userPropertyLink: IUserPropertyLink = { id: 123 };
        const userPropertyLinkCollection: IUserPropertyLink[] = [
          {
            ...userPropertyLink,
          },
          { id: 456 },
        ];
        expectedResult = service.addUserPropertyLinkToCollectionIfMissing(userPropertyLinkCollection, userPropertyLink);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a UserPropertyLink to an array that doesn't contain it", () => {
        const userPropertyLink: IUserPropertyLink = { id: 123 };
        const userPropertyLinkCollection: IUserPropertyLink[] = [{ id: 456 }];
        expectedResult = service.addUserPropertyLinkToCollectionIfMissing(userPropertyLinkCollection, userPropertyLink);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(userPropertyLink);
      });

      it('should add only unique UserPropertyLink to an array', () => {
        const userPropertyLinkArray: IUserPropertyLink[] = [{ id: 123 }, { id: 456 }, { id: 31536 }];
        const userPropertyLinkCollection: IUserPropertyLink[] = [{ id: 123 }];
        expectedResult = service.addUserPropertyLinkToCollectionIfMissing(userPropertyLinkCollection, ...userPropertyLinkArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const userPropertyLink: IUserPropertyLink = { id: 123 };
        const userPropertyLink2: IUserPropertyLink = { id: 456 };
        expectedResult = service.addUserPropertyLinkToCollectionIfMissing([], userPropertyLink, userPropertyLink2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(userPropertyLink);
        expect(expectedResult).toContain(userPropertyLink2);
      });

      it('should accept null and undefined values', () => {
        const userPropertyLink: IUserPropertyLink = { id: 123 };
        expectedResult = service.addUserPropertyLinkToCollectionIfMissing([], null, userPropertyLink, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(userPropertyLink);
      });

      it('should return initial array if no UserPropertyLink is added', () => {
        const userPropertyLinkCollection: IUserPropertyLink[] = [{ id: 123 }];
        expectedResult = service.addUserPropertyLinkToCollectionIfMissing(userPropertyLinkCollection, undefined, null);
        expect(expectedResult).toEqual(userPropertyLinkCollection);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
