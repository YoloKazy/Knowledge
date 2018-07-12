import { Component, OnInit } from '@angular/core';
import { ItemService } from '../../services/item.service';
import { Item } from '../../../models/item';
import { CarritoService } from '../../services/carrito.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  items:Item[];
  valorVar:string="Esto es un valor";

  constructor(private _itemsService:ItemService, private _carritoService:CarritoService) { }

  ngOnInit() {
    this.items=this._itemsService.getItems();
  }

  addItem(aitem:Item){
    this._carritoService.addItem(Object.assign({}, aitem));
    this._itemsService.deleteItem(aitem);
  }

}
