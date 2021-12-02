import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { ICrimeReport, CrimeReport } from '../crime-report.model';

import { CrimeReportService } from './crime-report.service';

describe('CrimeReport Service', () => {
  let service: CrimeReportService;
  let httpMock: HttpTestingController;
  let elemDefault: ICrimeReport;
  let expectedResult: ICrimeReport | ICrimeReport[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(CrimeReportService);
    httpMock = TestBed.inject(HttpTestingController);

    elemDefault = {
      id: 0,
      city: 'AAAAAAA',
      population: 0,
      murder: 0,
      rape: 0,
      robbery: 0,
      aggravatedAssault: 0,
      propertyCrime: 0,
      burglary: 0,
      larceny: 0,
      vehicleTheft: 0,
      arson: 0,
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

    it('should create a CrimeReport', () => {
      const returnedFromService = Object.assign(
        {
          id: 0,
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.create(new CrimeReport()).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a CrimeReport', () => {
      const returnedFromService = Object.assign(
        {
          id: 1,
          city: 'BBBBBB',
          population: 1,
          murder: 1,
          rape: 1,
          robbery: 1,
          aggravatedAssault: 1,
          propertyCrime: 1,
          burglary: 1,
          larceny: 1,
          vehicleTheft: 1,
          arson: 1,
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.update(expected).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a CrimeReport', () => {
      const patchObject = Object.assign(
        {
          city: 'BBBBBB',
          murder: 1,
          rape: 1,
          robbery: 1,
          larceny: 1,
          vehicleTheft: 1,
        },
        new CrimeReport()
      );

      const returnedFromService = Object.assign(patchObject, elemDefault);

      const expected = Object.assign({}, returnedFromService);

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of CrimeReport', () => {
      const returnedFromService = Object.assign(
        {
          id: 1,
          city: 'BBBBBB',
          population: 1,
          murder: 1,
          rape: 1,
          robbery: 1,
          aggravatedAssault: 1,
          propertyCrime: 1,
          burglary: 1,
          larceny: 1,
          vehicleTheft: 1,
          arson: 1,
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

    it('should delete a CrimeReport', () => {
      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult);
    });

    describe('addCrimeReportToCollectionIfMissing', () => {
      it('should add a CrimeReport to an empty array', () => {
        const crimeReport: ICrimeReport = { id: 123 };
        expectedResult = service.addCrimeReportToCollectionIfMissing([], crimeReport);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(crimeReport);
      });

      it('should not add a CrimeReport to an array that contains it', () => {
        const crimeReport: ICrimeReport = { id: 123 };
        const crimeReportCollection: ICrimeReport[] = [
          {
            ...crimeReport,
          },
          { id: 456 },
        ];
        expectedResult = service.addCrimeReportToCollectionIfMissing(crimeReportCollection, crimeReport);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a CrimeReport to an array that doesn't contain it", () => {
        const crimeReport: ICrimeReport = { id: 123 };
        const crimeReportCollection: ICrimeReport[] = [{ id: 456 }];
        expectedResult = service.addCrimeReportToCollectionIfMissing(crimeReportCollection, crimeReport);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(crimeReport);
      });

      it('should add only unique CrimeReport to an array', () => {
        const crimeReportArray: ICrimeReport[] = [{ id: 123 }, { id: 456 }, { id: 28840 }];
        const crimeReportCollection: ICrimeReport[] = [{ id: 123 }];
        expectedResult = service.addCrimeReportToCollectionIfMissing(crimeReportCollection, ...crimeReportArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const crimeReport: ICrimeReport = { id: 123 };
        const crimeReport2: ICrimeReport = { id: 456 };
        expectedResult = service.addCrimeReportToCollectionIfMissing([], crimeReport, crimeReport2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(crimeReport);
        expect(expectedResult).toContain(crimeReport2);
      });

      it('should accept null and undefined values', () => {
        const crimeReport: ICrimeReport = { id: 123 };
        expectedResult = service.addCrimeReportToCollectionIfMissing([], null, crimeReport, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(crimeReport);
      });

      it('should return initial array if no CrimeReport is added', () => {
        const crimeReportCollection: ICrimeReport[] = [{ id: 123 }];
        expectedResult = service.addCrimeReportToCollectionIfMissing(crimeReportCollection, undefined, null);
        expect(expectedResult).toEqual(crimeReportCollection);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
