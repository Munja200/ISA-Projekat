export class Question {
    id: number = 0;
    question: String ='';
    exactValue: string='';
   

    public constructor(id: any, question: any, exactValue: any ) {
        this.id = id;
        this.question = question;   
        this.exactValue = exactValue;
    }
}