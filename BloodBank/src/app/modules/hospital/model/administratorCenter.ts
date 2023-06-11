import { Person } from "./person";

export class AdministratorCenter {
    id: number = 0;
    deleted : boolean = false;
    person : Person = new Person();

    constructor(obj?: any) {
        if (obj) {
          this.id = obj.id;
          this.deleted = obj.deleted;
          this.person = obj.person;
        }
      }
}