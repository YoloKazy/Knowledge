import { Component, OnInit } from '@angular/core';
import {Tarea} from '../modelos/tarea';
import { TareasService } from '../services/tareas.service';
import { ProyectosService } from '../services/proyectos.service';
import { Proyecto } from '../modelos/proyecto';

@Component({
  selector: 'app-tareas',
  templateUrl: './tareas.component.html',
  styleUrls: ['./tareas.component.css']
})
export class TareasComponent implements OnInit {

  backClass:string="";
  tareas:Tarea[];
  proyectos:Proyecto[];
  unaPropiedad:number=190;

  constructor(private _tareasService:TareasService, private _proyectosService:ProyectosService) { }

  ngOnInit() {
    this.tareas=this._tareasService.getTareas();
    this.proyectos=this._proyectosService.getProyectos();
  }

  evaluarPar(id:number){
    return id%2==0;
  }

  getProjectName(pid:number){
    let elProyecto= this.proyectos.find((unProj:Proyecto)=>(unProj.pid==pid));

    return elProyecto?elProyecto.titulo:'';
  }
  
  changeBack(){
    //this.backClass="blue";
  }

}
