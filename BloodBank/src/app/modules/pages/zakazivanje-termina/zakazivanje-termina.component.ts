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

@Component({
  selector: 'app-zakazivanje-termina',
  templateUrl: './zakazivanje-termina.component.html',
  styleUrls: ['./zakazivanje-termina.component.css']
})
export class ZakazivanjeTerminaComponent implements OnInit {

  public center: Center = new Center();

  public centarSaTerminom: CenterWithTerminDTO = new CenterWithTerminDTO();

  public centerWithTermin: any;

  public questions : Question[] = [];
  public odgovor : boolean = false;
  
  constructor(private datePipe: DatePipe, private centerWithTerminService: CenterWithTerminServiceComponent, private centerService: CenterService, private questionService: QuestionService, private route: ActivatedRoute,  private router: Router, private authService: AuthService)
  {
    this.centerWithTermin = this.centerWithTerminService.getCenterWithTermin();

  }

  ngOnInit(): void {

    console.log(this.centerWithTermin)

    this.questionService.getAll().subscribe(res => {
      this.questions = res;
      console.log(this.questions);
    })

  }

  logout(){
    this.authService.logout()
  }

  formatDate(date: any): string {
    return this.datePipe.transform(date, 'dd.MM.yyyy') || '';
  }

}
