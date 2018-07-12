import { Injectable } from '@angular/core';
import { Item } from '../../models/item';

@Injectable()
export class CarritoService {

  private _itemsCarrito:Item[];

  constructor() {
    this._itemsCarrito=new Array();
   }

  getItems():Item[]{
    return this._itemsCarrito;
  }

  addItem(aItem:Item){
    this._itemsCarrito.push(aItem);
    console.log(this._itemsCarrito);
  }

}
