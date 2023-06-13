import { Center } from "./center";
import { CenterDTO } from "./centerDTO";

export class TerminWithCenterNameDTO {
    id: number = 0;
    pocetakTermina : Date = new Date();
    krajTermina : Date = new Date();
    trajanje : number = 0;
    center: number = 0;
    centerName: string = '';
    korisnikId : number = 0

    constructor(obj?: any) {
        if (obj) {
          this.id = obj.id;
          this.pocetakTermina = obj.pocetakTermina;
          this.krajTermina = obj.krajTermina;
          this.trajanje = obj.trajanje;
          this.center = obj.center;
          this.centerName = obj.centerName;
          this.korisnikId = obj.korisnikId;
        }
      }
}