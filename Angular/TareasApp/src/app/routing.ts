import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TareasComponent } from './tareas/tareas.component';

import { PageNotFoundComponentComponent } from './commons/page-not-found-component/page-not-found-component.component';
import { ProyectosComponent } from './proyectos/proyectos.component';
import { DetalleTareaComponent } from './tareas/detalle-tarea/detalle-tarea.component';
import { DetalleProyectosComponent } from './proyectos/detalle-proyectos/detalle-proyectos.component';

const appRoutes: Routes = [
  { path: 'tareas', component: TareasComponent, pathMatch: 'full' },
  { path: 'tareas/:tid', component: DetalleTareaComponent, pathMatch: 'full' },
  { path: 'proyectos', component: ProyectosComponent, pathMatch: 'full' },
  { path: 'proyectos/:tid', component: DetalleProyectosComponent, pathMatch: 'full' },
  { path: '',redirectTo: '/tareas',pathMatch: 'full'},
  { path: '**', component: PageNotFoundComponentComponent }
];

export const routingProv: ModuleWithProviders = RouterModule.forRoot(appRoutes);