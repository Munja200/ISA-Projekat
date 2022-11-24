import { Person } from "./person";

export class RegisteredPerson {
    id: number = 0;
    deleted: boolean;
    person: Person;

    public constructor(id: any, deleted: any, person: any) {
        this.id = id;
        this.deleted = deleted;
        this.person = person;
    }
}