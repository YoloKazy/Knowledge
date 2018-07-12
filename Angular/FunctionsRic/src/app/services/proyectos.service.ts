import { Injectable } from '@angular/core';
import { Proyecto } from '../modelos/proyecto';

@Injectable()
export class ProyectosService {
  private _proyectosStore:Proyecto[];

  constructor() { 
    this._proyectosStore=[
      new Proyecto(1,"App Móvil"),
      new Proyecto(2,"MyApp")      
    ];
  }

  getProyectos():Proyecto[]{
    return this._proyectosStore;
  }

}
