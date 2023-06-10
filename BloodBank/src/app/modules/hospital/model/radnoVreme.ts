import { Center } from "./center";

export class RadnoVreme {
    id: number = 0;
    vremeOtvaranja : Date = new Date();
    vremeZatvaranja : Date = new Date();
    trajanje : number = 0;
    center: Center = new Center();

    constructor(obj?: any) {
        if (obj) {
          this.id = obj.id;
          this.vremeOtvaranja = obj.vremeOtvaranja;
          this.vremeZatvaranja = obj.vremeZatvaranja;
          this.trajanje = obj.trajanje;
          this.center = obj.center;
        }
      }
}