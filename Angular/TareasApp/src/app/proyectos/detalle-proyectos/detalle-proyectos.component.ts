import { Component, OnInit } from '@angular/core';
import { Proyecto } from '../../modelos/proyecto';
import { ProyectosService } from '../../services/proyectos.service';
import { ActivatedRoute } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-detalle-proyectos',
  templateUrl: './detalle-proyectos.component.html',
  styleUrls: ['./detalle-proyectos.component.css']
})
export class DetalleProyectosComponent implements OnInit {
  elProyecto:Proyecto;
  idProyecto:number;

  constructor(private _proyectosService:ProyectosService, private _route: ActivatedRoute) { }

  ngOnInit() {
    this._route.params.subscribe(pathparams=>{
      this.idProyecto=pathparams['tid'];
      this.elProyecto=this._proyectosService.getProyectoById(this.idProyecto);
    })
  }

}
