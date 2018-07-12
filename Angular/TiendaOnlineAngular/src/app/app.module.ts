import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CarritoComponent } from './header/carrito/carrito.component';
import { ItemListComponent } from './main/item-list/item-list.component';
import { CarritoService } from './services/carrito.service';
import { ItemsPipe } from './pipes/items.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CarritoComponent,
    ItemListComponent,
    ItemsPipe
  ],
  imports: [
    BrowserModule,FormsModule
  ],
  providers: [CarritoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
