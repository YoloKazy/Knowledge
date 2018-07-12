import { Pipe, PipeTransform } from '@angular/core';
import { Item } from '../../models/item';

@Pipe({
  name: 'itemsfilter'
})
export class ItemsPipe implements PipeTransform {

  transform(listaItems: any[], valorFiltro: string, campo:string): any {
    console.log('itemsfilter:',listaItems,valorFiltro);
    return listaItems.filter( (aItem:Item) =>(aItem.nombre.indexOf(valorFiltro)>=0));
  }

}
