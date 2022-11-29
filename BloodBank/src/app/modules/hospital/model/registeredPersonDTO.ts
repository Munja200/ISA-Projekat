import { Person } from "./person";

export class RegisteredPersonDTO {
    id: number;
	deleted: boolean;
	person: Person;

    public constructor(
        id: number = 0,
	    deleted: boolean = false,
	    person: Person = new Person(),
    ) {
        this.id = id;
        this.deleted = deleted;   
        this.person = person;
    }
}