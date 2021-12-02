import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { ISearchCriteria, SearchCriteria } from '../search-criteria.model';

import { SearchCriteriaService } from './search-criteria.service';

describe('SearchCriteria Service', () => {
  let service: SearchCriteriaService;
  let httpMock: HttpTestingController;
  let elemDefault: ISearchCriteria;
  let expectedResult: ISearchCriteria | ISearchCriteria[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(SearchCriteriaService);
    httpMock = TestBed.inject(HttpTestingController);

    elemDefault = {
      id: 0,
      critera: 'AAAAAAA',
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

    it('should create a SearchCriteria', () => {
      const returnedFromService = Object.assign(
        {
          id: 0,
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.create(new SearchCriteria()).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a SearchCriteria', () => {
      const returnedFromService = Object.assign(
        {
          id: 1,
          critera: 'BBBBBB',
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.update(expected).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a SearchCriteria', () => {
      const patchObject = Object.assign({}, new SearchCriteria());

      const returnedFromService = Object.assign(patchObject, elemDefault);

      const expected = Object.assign({}, returnedFromService);

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of SearchCriteria', () => {
      const returnedFromService = Object.assign(
        {
          id: 1,
          critera: 'BBBBBB',
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

    it('should delete a SearchCriteria', () => {
      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult);
    });

    describe('addSearchCriteriaToCollectionIfMissing', () => {
      it('should add a SearchCriteria to an empty array', () => {
        const searchCriteria: ISearchCriteria = { id: 123 };
        expectedResult = service.addSearchCriteriaToCollectionIfMissing([], searchCriteria);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(searchCriteria);
      });

      it('should not add a SearchCriteria to an array that contains it', () => {
        const searchCriteria: ISearchCriteria = { id: 123 };
        const searchCriteriaCollection: ISearchCriteria[] = [
          {
            ...searchCriteria,
          },
          { id: 456 },
        ];
        expectedResult = service.addSearchCriteriaToCollectionIfMissing(searchCriteriaCollection, searchCriteria);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a SearchCriteria to an array that doesn't contain it", () => {
        const searchCriteria: ISearchCriteria = { id: 123 };
        const searchCriteriaCollection: ISearchCriteria[] = [{ id: 456 }];
        expectedResult = service.addSearchCriteriaToCollectionIfMissing(searchCriteriaCollection, searchCriteria);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(searchCriteria);
      });

      it('should add only unique SearchCriteria to an array', () => {
        const searchCriteriaArray: ISearchCriteria[] = [{ id: 123 }, { id: 456 }, { id: 2380 }];
        const searchCriteriaCollection: ISearchCriteria[] = [{ id: 123 }];
        expectedResult = service.addSearchCriteriaToCollectionIfMissing(searchCriteriaCollection, ...searchCriteriaArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const searchCriteria: ISearchCriteria = { id: 123 };
        const searchCriteria2: ISearchCriteria = { id: 456 };
        expectedResult = service.addSearchCriteriaToCollectionIfMissing([], searchCriteria, searchCriteria2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(searchCriteria);
        expect(expectedResult).toContain(searchCriteria2);
      });

      it('should accept null and undefined values', () => {
        const searchCriteria: ISearchCriteria = { id: 123 };
        expectedResult = service.addSearchCriteriaToCollectionIfMissing([], null, searchCriteria, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(searchCriteria);
      });

      it('should return initial array if no SearchCriteria is added', () => {
        const searchCriteriaCollection: ISearchCriteria[] = [{ id: 123 }];
        expectedResult = service.addSearchCriteriaToCollectionIfMissing(searchCriteriaCollection, undefined, null);
        expect(expectedResult).toEqual(searchCriteriaCollection);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
