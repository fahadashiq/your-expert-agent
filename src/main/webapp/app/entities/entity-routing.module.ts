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
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
