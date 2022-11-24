import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { CenterDTO } from '../model/centerDTO';
import { Question } from '../model/question';
import { QuestionService } from '../services/question.service';
import {MatRadioModule} from '@angular/material/radio';
import { AnswerQuestion } from '../model/ansqer-questtion';
import { RegisterPersonService } from '../services/register-person.service';
import { Person } from '../model/person';
import { Address } from '../model/address';
import { QuestionForm } from '../model/question-fotm';

@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.css']
})
export class QuestionFormComponent implements OnInit {

  public displayedColumns = ['question','questionAnswer'];
  public rooms: Question[] = [];
  public answers: AnswerQuestion[]=[];
  public address: Address = new Address();
  public dataSource = new MatTableDataSource<Question>();
  private date: Date = new Date();
  public qf : QuestionForm = new QuestionForm(0, '',this.date, this.answers);
  constructor(private questionService: QuestionService,private personService:RegisterPersonService,private router: Router) { }

  ngOnInit(): void {

    this.personService.getPerson(1).subscribe(res => {
      console.log(res)
      this.qf.person = res
    })

    this.questionService.getAll().subscribe(res => {
      this.rooms = res;
      res.forEach((element: any) => {
        var app = new AnswerQuestion(0, element, false);    
        this.answers.push(app);
        
      });

      console.log(this.answers);
      console.log(this.rooms);
      this.dataSource.data = this.rooms;
    })
  }

  public radioButtonChange(obj: any,bool : any): void{
   let pom = this.answers[obj.id-1];
   if(bool == 'True'){
    pom.answer =true;
   }else{
    pom.answer = false;
   } 
  }
  public registePerson() {
      this.qf.questions = this.answers;
      console.log(this.qf)
      this.questionService.registerPerson(this.qf).subscribe(res => {
        this.router.navigate(['/home']);
      });
      console.log(this.answers);
  }

}
