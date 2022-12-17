import { PersonDTO } from "./personDTO";

export class ComplaintDTO {
    id: number;
    person: PersonDTO;
    complaint: string;
    answer: string;

    public constructor(
        id: number = 0, 
        person: PersonDTO = new PersonDTO(),
        complaint: string = "",
        answer: string = "",
    ) {
        this.id = id;
        this.person = person;
        this.complaint = complaint;
        this.answer = answer;
    }
}