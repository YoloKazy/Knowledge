import { Injectable } from '@angular/core';
import { Proyecto } from '../modelos/proyecto';
import { HttpClient } from '../../../node_modules/@angular/common/http';

@Injectable()
export class ProyectosService {
  private _proyectosStore: Proyecto[];
  private _apiProyectos: string = 'https://localhost:8080/PedidosREST/api/proyecto';

  constructor(private _httpclient: HttpClient) {
    // this._proyectosStore = [
    //   new Proyecto(1, "App Móvil"),
    //   new Proyecto(2, "MyApp")
    // ];
  }

  getProyectos(): Proyecto[] {
    return this._proyectosStore;
  }
  getProyectoById(pid: number): Proyecto {
    return this._proyectosStore.find((aT: Proyecto) => (aT.pid == pid));
  }
  getProyectosFromApi(): Proyecto[] {
    console.log( this._httpclient.get<Proyecto>(this._apiProyectos))
    return this._proyectosStore;
  }
}
