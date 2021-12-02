import { IUser } from 'app/entities/user/user.model';
import { IResProperties } from 'app/entities/res-properties/res-properties.model';

export interface IUserPropertyLink {
  id?: number;
  isFavourite?: boolean | null;
  user?: IUser | null;
  resProperties?: IResProperties | null;
}

export class UserPropertyLink implements IUserPropertyLink {
  constructor(
    public id?: number,
    public isFavourite?: boolean | null,
    public user?: IUser | null,
    public resProperties?: IResProperties | null
  ) {
    this.isFavourite = this.isFavourite ?? false;
  }
}

export function getUserPropertyLinkIdentifier(userPropertyLink: IUserPropertyLink): number | undefined {
  return userPropertyLink.id;
}
