import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import { ISearchCriteria, SearchCriteria } from '../search-criteria.model';
import { SearchCriteriaService } from '../service/search-criteria.service';
import { IUser } from 'app/entities/user/user.model';
import { UserService } from 'app/entities/user/user.service';

@Component({
  selector: 'jhi-search-criteria-update',
  templateUrl: './search-criteria-update.component.html',
})
export class SearchCriteriaUpdateComponent implements OnInit {
  isSaving = false;

  usersSharedCollection: IUser[] = [];

  editForm = this.fb.group({
    id: [],
    critera: [null, [Validators.maxLength(2048)]],
    user: [],
  });

  constructor(
    protected searchCriteriaService: SearchCriteriaService,
    protected userService: UserService,
    protected activatedRoute: ActivatedRoute,
    protected fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ searchCriteria }) => {
      this.updateForm(searchCriteria);

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const searchCriteria = this.createFromForm();
    if (searchCriteria.id !== undefined) {
      this.subscribeToSaveResponse(this.searchCriteriaService.update(searchCriteria));
    } else {
      this.subscribeToSaveResponse(this.searchCriteriaService.create(searchCriteria));
    }
  }

  trackUserById(index: number, item: IUser): number {
    return item.id!;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ISearchCriteria>>): void {
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

  protected updateForm(searchCriteria: ISearchCriteria): void {
    this.editForm.patchValue({
      id: searchCriteria.id,
      critera: searchCriteria.critera,
      user: searchCriteria.user,
    });

    this.usersSharedCollection = this.userService.addUserToCollectionIfMissing(this.usersSharedCollection, searchCriteria.user);
  }

  protected loadRelationshipsOptions(): void {
    this.userService
      .query()
      .pipe(map((res: HttpResponse<IUser[]>) => res.body ?? []))
      .pipe(map((users: IUser[]) => this.userService.addUserToCollectionIfMissing(users, this.editForm.get('user')!.value)))
      .subscribe((users: IUser[]) => (this.usersSharedCollection = users));
  }

  protected createFromForm(): ISearchCriteria {
    return {
      ...new SearchCriteria(),
      id: this.editForm.get(['id'])!.value,
      critera: this.editForm.get(['critera'])!.value,
      user: this.editForm.get(['user'])!.value,
    };
  }
}
