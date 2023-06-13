import { Center } from "./center";
import { CenterDTO } from "./centerDTO";

export class Report {
    id: number = 0;
    bloodType : string = '';
    description : string = '';
    quantity : number = 0;
    

    constructor(obj?: any) {
        if (obj) {
          this.id = obj.id;
          this.bloodType = obj.bloodType;
          this.description = obj.description;
          this.quantity = obj.quantity;
        }
      }
}