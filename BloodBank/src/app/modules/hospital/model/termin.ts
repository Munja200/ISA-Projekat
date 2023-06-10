import { Center } from "./center";
import { CenterDTO } from "./centerDTO";

export class Termin {
    id: number = 0;
    pocetakTermina : Date = new Date();
    krajTermina : Date = new Date();
    trajanje : number = 0;
    center: Center = new Center();

    constructor(obj?: any) {
        if (obj) {
          this.id = obj.id;
          this.pocetakTermina = obj.pocetakTermina;
          this.krajTermina = obj.krajTermina;
          this.trajanje = obj.trajanje;
          this.center = obj.center;
        }
      }
}