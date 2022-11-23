import { Question } from "./question";

export class AnswerQuestion{
    id: number = 0;
    deleted: boolean = false;
    answer:boolean;
    question:Question;
    

    public constructor(id: any, question: any, answer: any) {
        this.id = id;
        this.answer = answer;
        this.question =question;
     
    }
}