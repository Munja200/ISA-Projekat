import { AnimationDriver } from "@angular/animations/browser";
import { AnswerQuestion } from "./ansqer-questtion";
import { Person } from "./person";

export class QuestionForm {
    id: number = 0;
    deleted: boolean = false;
    person: Person;
    date: Date ;
    questions: AnswerQuestion[];
    

    public constructor(id: any,
        person: any,
        date: any,
        questions: any ) {
        this.id = id;
        this.person = person;
        this.date = date;
        this.questions = questions;
    }
}