import { Address } from "./address";
import { AdministratorCenter } from "./administratorCenter";
import { CenterDTO } from "./centerDTO";
import { RadnoVreme } from "./radnoVreme";
import { Termin } from "./termin";
import { TerminDTO } from "./terminDTO";

export class CenterWithTerminDTO {
    id: number = 0;
    centerDTO : CenterDTO = new CenterDTO();
    terminDTO : TerminDTO = new TerminDTO();

    constructor(obj?: any) {
        if (obj) {
          this.id = obj.id;
          this.centerDTO = obj.centerDTO;
          this.terminDTO = obj.terminDTO;
        }
      }
}