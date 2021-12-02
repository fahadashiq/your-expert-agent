import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'res-properties',
        data: { pageTitle: 'yourExpertAgentApp.resProperties.home.title' },
        loadChildren: () => import('./res-properties/res-properties.module').then(m => m.ResPropertiesModule),
      },
      {
        path: 'user-property-link',
        data: { pageTitle: 'yourExpertAgentApp.userPropertyLink.home.title' },
        loadChildren: () => import('./user-property-link/user-property-link.module').then(m => m.UserPropertyLinkModule),
      },
      {
        path: 'user-info',
        data: { pageTitle: 'yourExpertAgentApp.userInfo.home.title' },
        loadChildren: () => import('./user-info/user-info.module').then(m => m.UserInfoModule),
      },
      {
        path: 'search-criteria',
        data: { pageTitle: 'yourExpertAgentApp.searchCriteria.home.title' },
        loadChildren: () => import('./search-criteria/search-criteria.module').then(m => m.SearchCriteriaModule),
      },
      {
        path: 'crime-report',
        data: { pageTitle: 'yourExpertAgentApp.crimeReport.home.title' },
        loadChildren: () => import('./crime-report/crime-report.module').then(m => m.CrimeReportModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
