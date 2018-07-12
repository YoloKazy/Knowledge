import { Component, OnInit } from '@angular/core';
import { CarritoService } from '../../services/carrito.service';
import { Item } from '../../../models/item';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {

  items:Item[];
  constructor(private _carritoService:CarritoService) { }

  ngOnInit() {
    this.items=this._carritoService.getItems();
  }

  getNumItems(){
    return this.items.length;
  }

}
