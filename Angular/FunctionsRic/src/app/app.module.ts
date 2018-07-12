import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms'

import { AppComponent } from './app.component';
import { ProyectosComponent } from './proyectos/proyectos.component';
import { TareasComponent } from './tareas/tareas.component';
import { HeaderComponent } from './header/header.component';
import { SectionComponent } from './section/section.component';
import { LogoComponente } from './header/logo/logo.componente';
import { MenuComponent } from './header/menu/menu.component';

import {LogoService} from './services/logo.service'
import { TareasService } from './services/tareas.service';
import { ProyectosService } from './services/proyectos.service';
import { FiltradorPipe } from './pipes/filtrador.pipe';
import { PageNotFoundComponentComponent } from './commons/page-not-found-component/page-not-found-component.component';

import {routingProv} from './routing'

@NgModule({
  declarations: [
    AppComponent,
    ProyectosComponent,
    TareasComponent,
    HeaderComponent,
    SectionComponent,
    LogoComponente,
    MenuComponent,
    FiltradorPipe,
    PageNotFoundComponentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    routingProv
  ],
  providers: [
    LogoService,
    TareasService,
    ProyectosService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
