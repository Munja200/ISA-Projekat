import { Address } from "./address";
import { AdministratorCenter } from "./administratorCenter";
import { CenterDTO } from "./centerDTO";
import { RadnoVreme } from "./radnoVreme";
import { Termin } from "./termin";

export class Center {
    id: number = 0;
    name : string = '';
    address : Address = new Address();
    description : string = '';
    averageRating : number = 0;
    administratorCenters : AdministratorCenter[]=[];
    deleted : boolean = false;
    radnoVreme : RadnoVreme[] = [];
    termini : Termin[] = [];

    constructor(obj?: any) {
        if (obj) {
          this.id = obj.id;
          this.name = obj.name;
          this.address = obj.address;
          this.description = obj.description;
          this.averageRating = obj.averageRating;
          this.administratorCenters = obj.administratorCenters;
          this.deleted = obj.deleted;
          this.radnoVreme = obj.radnoVreme;
          this.termini = obj.termini;
        }
      }
}