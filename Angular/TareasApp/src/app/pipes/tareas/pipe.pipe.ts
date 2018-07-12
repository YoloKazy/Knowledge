import { Pipe, PipeTransform } from '@angular/core';
import { Tarea } from '../../modelos/tarea';

@Pipe({
  name: 'valorFiltro'
})
export class PipePipe implements PipeTransform {

  transform(listaItems: any[], valorFiltro: string): any {
    return valorFiltro ? listaItems.filter((unItem: any) =>
      (unItem.descripcion.toLocaleLowerCase().indexOf(valorFiltro.toLocaleLowerCase()) >= 0)) : listaItems;
  }


}
