import { AnimationDriver } from "@angular/animations/browser";
import { AnswerQuestion } from "./ansqer-questtion";
import { Person } from "./person";

export class QuestionForm {
    id: number = 0;
    deleted: boolean = false;
    person: Person;
    date: Date ;
    answers: AnswerQuestion[];
    

    public constructor(id: any,
        person: any,
        date: any,
        answers: any ) {
        this.id = id;
        this.person = person;
        this.date = date;
        this.answers = answers;
    }
}