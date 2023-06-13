import { AnimationDriver } from "@angular/animations/browser";
import { AnswerQuestion } from "./ansqer-questtion";
import { Person } from "./person";

export class QuestionForm {
    id: number = 0;
    deleted: boolean = false;
    registeredUser: Person = new Person();
    date: Date = new Date() ;
    questions: AnswerQuestion[] = [];
    
/*
    public constructor(id: any,
        registeredUser: any,
        date: any,
        questions: any ) {
        this.id = id;
        this.registeredUser = registeredUser;
        this.date = date;
        this.questions = questions;
    }
*/
    constructor(obj?: any) {
        if (obj) {
          this.id = obj.id;
          this.deleted = obj.deleted;
          this.registeredUser = obj.registeredUser;
          this.date = obj.date;
          this.questions = obj.questions;
        }
      }
}