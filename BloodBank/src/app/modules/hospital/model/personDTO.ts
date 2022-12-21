export class PersonDTO {
    id: number;
    name: string;
    surname: string;

    public constructor(
        id: number = 0, 
        name: string = "",
        surname: string = "",
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}