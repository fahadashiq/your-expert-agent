import * as dayjs from 'dayjs';
import { IUser } from 'app/entities/user/user.model';
import { Profession } from 'app/entities/enumerations/profession.model';

export interface IUserInfo {
  id?: number;
  dateOfBirth?: dayjs.Dayjs;
  profession?: Profession | null;
  familyMembers?: number;
  user?: IUser | null;
}

export class UserInfo implements IUserInfo {
  constructor(
    public id?: number,
    public dateOfBirth?: dayjs.Dayjs,
    public profession?: Profession | null,
    public familyMembers?: number,
    public user?: IUser | null
  ) {}
}

export function getUserInfoIdentifier(userInfo: IUserInfo): number | undefined {
  return userInfo.id;
}
