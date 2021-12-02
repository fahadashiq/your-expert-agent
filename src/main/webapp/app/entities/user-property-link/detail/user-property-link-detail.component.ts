import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IUserPropertyLink } from '../user-property-link.model';

@Component({
  selector: 'jhi-user-property-link-detail',
  templateUrl: './user-property-link-detail.component.html',
})
export class UserPropertyLinkDetailComponent implements OnInit {
  userPropertyLink: IUserPropertyLink | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ userPropertyLink }) => {
      this.userPropertyLink = userPropertyLink;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
