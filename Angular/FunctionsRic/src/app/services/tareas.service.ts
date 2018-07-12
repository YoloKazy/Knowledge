import { Injectable } from '@angular/core';
import { Tarea } from '../modelos/tarea';

@Injectable()
export class TareasService {

  private _tareasStore:Tarea[];

  constructor() { 
    this._tareasStore=[
      new Tarea(1,"Planificar",1.2,1),
      new Tarea(2,"Analiza",6,2),
      new Tarea(3,"Testar",2,1)
    ];
  }

  getTareas():Tarea[]{
    return this._tareasStore;
  }
  
}
