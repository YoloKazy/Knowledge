export class Item{
    constructor(
        private _pid:number,
        private _nombre:string,
        private _precio:number
     ){}

     get pid(){return this._pid;}
     set pid(pid:number){this._pid=pid;}

     get nombre(){return this._nombre;}
     set nombre(nombre:string){this._nombre=nombre;}
     
     get precio(){return this._precio;}
     set precio(precio:number){this._precio=precio;}
}