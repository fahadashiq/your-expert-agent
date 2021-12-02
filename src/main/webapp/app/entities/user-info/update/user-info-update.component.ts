import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import * as dayjs from 'dayjs';
import { DATE_TIME_FORMAT } from 'app/config/input.constants';

import { IUserInfo, UserInfo } from '../user-info.model';
import { UserInfoService } from '../service/user-info.service';
import { IUser } from 'app/entities/user/user.model';
import { UserService } from 'app/entities/user/user.service';
import { Profession } from 'app/entities/enumerations/profession.model';

@Component({
  selector: 'jhi-user-info-update',
  templateUrl: './user-info-update.component.html',
})
export class UserInfoUpdateComponent implements OnInit {
  isSaving = false;
  professionValues = Object.keys(Profession);

  usersSharedCollection: IUser[] = [];

  editForm = this.fb.group({
    id: [],
    dateOfBirth: [null, [Validators.required]],
    profession: [],
    familyMembers: [null, [Validators.required]],
    user: [],
  });

  constructor(
    protected userInfoService: UserInfoService,
    protected userService: UserService,
    protected activatedRoute: ActivatedRoute,
    protected fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ userInfo }) => {
      if (userInfo.id === undefined) {
        const today = dayjs().startOf('day');
        userInfo.dateOfBirth = today;
      }

      this.updateForm(userInfo);

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const userInfo = this.createFromForm();
    if (userInfo.id !== undefined) {
      this.subscribeToSaveResponse(this.userInfoService.update(userInfo));
    } else {
      this.subscribeToSaveResponse(this.userInfoService.create(userInfo));
    }
  }

  trackUserById(index: number, item: IUser): number {
    return item.id!;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IUserInfo>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(userInfo: IUserInfo): void {
    this.editForm.patchValue({
      id: userInfo.id,
      dateOfBirth: userInfo.dateOfBirth ? userInfo.dateOfBirth.format(DATE_TIME_FORMAT) : null,
      profession: userInfo.profession,
      familyMembers: userInfo.familyMembers,
      user: userInfo.user,
    });

    this.usersSharedCollection = this.userService.addUserToCollectionIfMissing(this.usersSharedCollection, userInfo.user);
  }

  protected loadRelationshipsOptions(): void {
    this.userService
      .query()
      .pipe(map((res: HttpResponse<IUser[]>) => res.body ?? []))
      .pipe(map((users: IUser[]) => this.userService.addUserToCollectionIfMissing(users, this.editForm.get('user')!.value)))
      .subscribe((users: IUser[]) => (this.usersSharedCollection = users));
  }

  protected createFromForm(): IUserInfo {
    return {
      ...new UserInfo(),
      id: this.editForm.get(['id'])!.value,
      dateOfBirth: this.editForm.get(['dateOfBirth'])!.value
        ? dayjs(this.editForm.get(['dateOfBirth'])!.value, DATE_TIME_FORMAT)
        : undefined,
      profession: this.editForm.get(['profession'])!.value,
      familyMembers: this.editForm.get(['familyMembers'])!.value,
      user: this.editForm.get(['user'])!.value,
    };
  }
}
