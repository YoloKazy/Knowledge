import { Component, OnInit } from '@angular/core';
import { TareasService } from '../../services/tareas.service';
import { Tarea } from '../../modelos/tarea';
import { Route } from '../../../../node_modules/@angular/compiler/src/core';
import { ActivatedRoute } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-detalle-tarea',
  templateUrl: './detalle-tarea.component.html',
  styleUrls: ['./detalle-tarea.component.css']
})
export class DetalleTareaComponent implements OnInit {

  latarea:Tarea;
  idTarea:number;
  constructor(private _tareasService:TareasService,private _route:ActivatedRoute) { }

  ngOnInit() {    
    this._route.params.subscribe(pathparams=>{
      this.idTarea=pathparams['tid'];
      this.latarea=this._tareasService.getTareaById(this.idTarea);
    })      
  }

}
