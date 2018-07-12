import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  listaMenu:string[];
  showTitle:boolean=true;
  unClase:string="rojo";

  constructor() {    
   }

  ngOnInit() {
    this.listaMenu=["Tareas","Proyectos","Quienes somos","Blog"];
  }

}
