import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import { IUserPropertyLink, UserPropertyLink } from '../user-property-link.model';
import { UserPropertyLinkService } from '../service/user-property-link.service';
import { IUser } from 'app/entities/user/user.model';
import { UserService } from 'app/entities/user/user.service';
import { IResProperties } from 'app/entities/res-properties/res-properties.model';
import { ResPropertiesService } from 'app/entities/res-properties/service/res-properties.service';

@Component({
  selector: 'jhi-user-property-link-update',
  templateUrl: './user-property-link-update.component.html',
})
export class UserPropertyLinkUpdateComponent implements OnInit {
  isSaving = false;

  usersSharedCollection: IUser[] = [];
  resPropertiesSharedCollection: IResProperties[] = [];

  editForm = this.fb.group({
    id: [],
    isFavourite: [],
    user: [],
    resProperties: [],
  });

  constructor(
    protected userPropertyLinkService: UserPropertyLinkService,
    protected userService: UserService,
    protected resPropertiesService: ResPropertiesService,
    protected activatedRoute: ActivatedRoute,
    protected fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ userPropertyLink }) => {
      this.updateForm(userPropertyLink);

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const userPropertyLink = this.createFromForm();
    if (userPropertyLink.id !== undefined) {
      this.subscribeToSaveResponse(this.userPropertyLinkService.update(userPropertyLink));
    } else {
      this.subscribeToSaveResponse(this.userPropertyLinkService.create(userPropertyLink));
    }
  }

  trackUserById(index: number, item: IUser): number {
    return item.id!;
  }

  trackResPropertiesById(index: number, item: IResProperties): number {
    return item.id!;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IUserPropertyLink>>): void {
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

  protected updateForm(userPropertyLink: IUserPropertyLink): void {
    this.editForm.patchValue({
      id: userPropertyLink.id,
      isFavourite: userPropertyLink.isFavourite,
      user: userPropertyLink.user,
      resProperties: userPropertyLink.resProperties,
    });

    this.usersSharedCollection = this.userService.addUserToCollectionIfMissing(this.usersSharedCollection, userPropertyLink.user);
    this.resPropertiesSharedCollection = this.resPropertiesService.addResPropertiesToCollectionIfMissing(
      this.resPropertiesSharedCollection,
      userPropertyLink.resProperties
    );
  }

  protected loadRelationshipsOptions(): void {
    this.userService
      .query()
      .pipe(map((res: HttpResponse<IUser[]>) => res.body ?? []))
      .pipe(map((users: IUser[]) => this.userService.addUserToCollectionIfMissing(users, this.editForm.get('user')!.value)))
      .subscribe((users: IUser[]) => (this.usersSharedCollection = users));

    this.resPropertiesService
      .query()
      .pipe(map((res: HttpResponse<IResProperties[]>) => res.body ?? []))
      .pipe(
        map((resProperties: IResProperties[]) =>
          this.resPropertiesService.addResPropertiesToCollectionIfMissing(resProperties, this.editForm.get('resProperties')!.value)
        )
      )
      .subscribe((resProperties: IResProperties[]) => (this.resPropertiesSharedCollection = resProperties));
  }

  protected createFromForm(): IUserPropertyLink {
    return {
      ...new UserPropertyLink(),
      id: this.editForm.get(['id'])!.value,
      isFavourite: this.editForm.get(['isFavourite'])!.value,
      user: this.editForm.get(['user'])!.value,
      resProperties: this.editForm.get(['resProperties'])!.value,
    };
  }
}
