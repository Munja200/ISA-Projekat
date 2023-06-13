import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../hospital/services/auth.service';
import { CenterService } from '../service/center.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Center } from '../../hospital/model/center';
import { Question } from '../../hospital/model/question';
import { QuestionService } from '../../hospital/services/question.service';
import { CenterWithTerminDTO } from '../../hospital/model/centerWithTerminDTO';
import { CenterWithTerminServiceComponent } from '../center-with-termin-service/center-with-termin-service.component';
import { DatePipe } from '@angular/common';
import { AnswerQuestion } from '../../hospital/model/ansqer-questtion';
import { QuestionForm } from '../../hospital/model/question-fotm';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { TerminService } from '../service/termin.service';
import { Termin } from '../../hospital/model/termin';
import { TerminDTO } from '../../hospital/model/terminDTO';

@Component({
  selector: 'app-zakazivanje-termina',
  templateUrl: './zakazivanje-termina.component.html',
  styleUrls: ['./zakazivanje-termina.component.css']
})
export class ZakazivanjeTerminaComponent implements OnInit {

  public center: Center = new Center();
  public centerWithTermin: any;
  public questions : Question[] = [];
  public odgovor : boolean = false;
  public answers: AnswerQuestion[]=[];
  private date: Date = new Date();
  public questionForm : QuestionForm = new QuestionForm(0, '',this.date, this.answers);
  public isQuestionFormFilled: boolean = false;
  public selectedAnswer: string = ""; 

  public termin: Termin = new Termin();
  public terminDTO: TerminDTO = new TerminDTO();
  public korId: number = 0;

  public isFormFilled: boolean = false;


  constructor(private terminService: TerminService , private registerPersonService: RegisterPersonService, private datePipe: DatePipe, private centerWithTerminService: CenterWithTerminServiceComponent, private centerService: CenterService, private questionService: QuestionService, private route: ActivatedRoute,  private router: Router, private authService: AuthService)
  {
    this.centerWithTermin = this.centerWithTerminService.getCenterWithTermin();

  }

  ngOnInit(): void {

    const username = this.authService.getCurrentUserUsername();
    this.registerPersonService.getUserByUsername(username).subscribe(person => {
      this.questionForm.registeredUser = person
      this.korId = person.id
    });

    console.log(this.centerWithTermin)

    this.questionService.getAll().subscribe(res => {
      this.questions = res;
      console.log(this.questions);

      res.forEach((element: any) => {
        var app = new AnswerQuestion(0, element, false);    
        this.answers.push(app);
        
      });

      console.log(this.answers);
      console.log(this.questions);
    })

  }

  logout(){
    this.authService.logout()
  }

  editTermin(centerWithTermin: CenterWithTerminDTO){
    this.terminDTO = centerWithTermin.terminDTO
    this.terminDTO.korisnikId = this.korId
    console.log(this.korId)
    console.log(this.terminDTO)

    this.terminService.editTermin(this.terminDTO, this.korId).subscribe((res) => {
      console.log(res)
      alert("You have successfully scheduling appointment!");
      this.router.navigate(['/futureAppointments']);
    });


  }

  
  public radioButtonChange(obj: any,bool : any): void{
    let pom = this.answers[obj.id-1];
    if(bool == 'True'){
     pom.answer =true;
    }else{
     pom.answer = false;
    } 
   }

   public selectAnswer(question: any, answer: boolean): void {
    question.answer = answer;
  }
  
  public isAnswerSelected(question: any, answer: boolean): boolean {
    return question.answer === answer;
  }
  

  public createQuestionForm() {
    this.isQuestionFormFilled = true;

    this.questionForm.questions = this.answers;
    console.log(this.questionForm)
    this.questionService.createQuestion(this.questionForm).subscribe(res => {
      alert("The Question Form has been successfully filled!")
    });
    console.log(this.answers);
}


}
