import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { isPresent } from 'app/core/util/operators';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { createRequestOption } from 'app/core/request/request-util';
import { ICrimeReport, getCrimeReportIdentifier } from '../crime-report.model';

export type EntityResponseType = HttpResponse<ICrimeReport>;
export type EntityArrayResponseType = HttpResponse<ICrimeReport[]>;

@Injectable({ providedIn: 'root' })
export class CrimeReportService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/crime-reports');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  create(crimeReport: ICrimeReport): Observable<EntityResponseType> {
    return this.http.post<ICrimeReport>(this.resourceUrl, crimeReport, { observe: 'response' });
  }

  update(crimeReport: ICrimeReport): Observable<EntityResponseType> {
    return this.http.put<ICrimeReport>(`${this.resourceUrl}/${getCrimeReportIdentifier(crimeReport) as number}`, crimeReport, {
      observe: 'response',
    });
  }

  partialUpdate(crimeReport: ICrimeReport): Observable<EntityResponseType> {
    return this.http.patch<ICrimeReport>(`${this.resourceUrl}/${getCrimeReportIdentifier(crimeReport) as number}`, crimeReport, {
      observe: 'response',
    });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICrimeReport>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICrimeReport[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  addCrimeReportToCollectionIfMissing(
    crimeReportCollection: ICrimeReport[],
    ...crimeReportsToCheck: (ICrimeReport | null | undefined)[]
  ): ICrimeReport[] {
    const crimeReports: ICrimeReport[] = crimeReportsToCheck.filter(isPresent);
    if (crimeReports.length > 0) {
      const crimeReportCollectionIdentifiers = crimeReportCollection.map(crimeReportItem => getCrimeReportIdentifier(crimeReportItem)!);
      const crimeReportsToAdd = crimeReports.filter(crimeReportItem => {
        const crimeReportIdentifier = getCrimeReportIdentifier(crimeReportItem);
        if (crimeReportIdentifier == null || crimeReportCollectionIdentifiers.includes(crimeReportIdentifier)) {
          return false;
        }
        crimeReportCollectionIdentifiers.push(crimeReportIdentifier);
        return true;
      });
      return [...crimeReportsToAdd, ...crimeReportCollection];
    }
    return crimeReportCollection;
  }
}
