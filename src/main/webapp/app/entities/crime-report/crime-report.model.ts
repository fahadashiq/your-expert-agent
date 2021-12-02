export interface ICrimeReport {
  id?: number;
  city?: string | null;
  population?: number | null;
  murder?: number | null;
  rape?: number | null;
  robbery?: number | null;
  aggravatedAssault?: number | null;
  propertyCrime?: number | null;
  burglary?: number | null;
  larceny?: number | null;
  vehicleTheft?: number | null;
  arson?: number | null;
}

export class CrimeReport implements ICrimeReport {
  constructor(
    public id?: number,
    public city?: string | null,
    public population?: number | null,
    public murder?: number | null,
    public rape?: number | null,
    public robbery?: number | null,
    public aggravatedAssault?: number | null,
    public propertyCrime?: number | null,
    public burglary?: number | null,
    public larceny?: number | null,
    public vehicleTheft?: number | null,
    public arson?: number | null
  ) {}
}

export function getCrimeReportIdentifier(crimeReport: ICrimeReport): number | undefined {
  return crimeReport.id;
}
