import { Injectable } from '@angular/core';
import { Item } from '../../models/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  private _itemsStore:Item[];
  
  constructor() {
    this._itemsStore=[
      new Item(1,'libro',18),
      new Item(2,'camara',59),
      new Item(3,'agenda',20),
      new Item(4,'ropa',34),
      new Item(5,'ordenador',200)
    ];
  }

  getItems():Item[]{
    return this._itemsStore;
  }

  deleteItem(aitem:Item):void{
    const index = this._itemsStore.indexOf(aitem);
    this._itemsStore.splice(index,1);
  }

}
