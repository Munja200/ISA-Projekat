import { AnimationDriver } from "@angular/animations/browser";
import { AnswerQuestion } from "./ansqer-questtion";
import { Person } from "./person";

export class QuestionForm {
    id: number = 0;
    deleted: boolean = false;
    registeredUser: Person;
    date: Date ;
    questions: AnswerQuestion[];
    

    public constructor(id: any,
        registeredUser: any,
        date: any,
        questions: any ) {
        this.id = id;
        this.registeredUser = registeredUser;
        this.date = date;
        this.questions = questions;
    }
}