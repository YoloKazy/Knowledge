export class Proyecto{

    constructor(private _pid:number, private _titulo:string){
    }

    get pid(){return this._pid;}
    get titulo(){return this._titulo;}
}