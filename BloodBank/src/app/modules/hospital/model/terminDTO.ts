import { Center } from "./center";
import { CenterDTO } from "./centerDTO";
import { Report } from "./report";

export class TerminDTO {
    id: number = 0;
    pocetakTermina : Date = new Date();
    krajTermina : Date = new Date();
    trajanje : number = 0;
    center: number = 0;
    korisnikId : number = 0
    report : Report = new Report();

    constructor(obj?: any) {
        if (obj) {
          this.id = obj.id;
          this.pocetakTermina = obj.pocetakTermina;
          this.krajTermina = obj.krajTermina;
          this.trajanje = obj.trajanje;
          this.center = obj.center;
          this.korisnikId = obj.korisnikId;
          this.report = obj.report;
        }
      }
}