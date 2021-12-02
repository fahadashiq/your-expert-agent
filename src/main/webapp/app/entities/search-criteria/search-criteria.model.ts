import { IUser } from 'app/entities/user/user.model';

export interface ISearchCriteria {
  id?: number;
  critera?: string | null;
  user?: IUser | null;
}

export class SearchCriteria implements ISearchCriteria {
  constructor(public id?: number, public critera?: string | null, public user?: IUser | null) {}
}

export function getSearchCriteriaIdentifier(searchCriteria: ISearchCriteria): number | undefined {
  return searchCriteria.id;
}
