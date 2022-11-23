import { Person } from "./person";

export class CenterAdministratorDTO {
    id: number;
    deleted: boolean;
    person: Person;
	centerId: number;

    public constructor(
        id: number = 0,
        deleted: boolean = false,
        person: Person = new Person(),
	    centerId: number = 0,
    ) {
        this.id = id;
        this.deleted = deleted;
        this.person = person;
        this.centerId = centerId;
    }
}