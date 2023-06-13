import { Component, OnInit } from '@angular/core';
import { CenterService } from '../service/center.service';
import { Router } from '@angular/router';
import { AuthService } from '../../hospital/services/auth.service';
import { CenterDTO } from '../../hospital/model/centerDTO';
import { CenterWithTerminDTO } from '../../hospital/model/centerWithTerminDTO';
import { CenterWithTerminServiceComponent } from '../center-with-termin-service/center-with-termin-service.component';

@Component({
  selector: 'app-scheduling-appointment',
  templateUrl: './scheduling-appointment.component.html',
  styleUrls: ['./scheduling-appointment.component.css']
})
export class SchedulingAppointmentComponent implements OnInit {

  public averageSort: boolean = false;
  public page: number = 0;
  public ime: string = 'none';
  public mesto: string = 'none';
  public centers: CenterDTO[] = [];
  public sort : boolean = false;
  public datum : Date = new Date();
  public showForm: boolean = false;
  public minDate: string = '';

  public centriSaTerminima: CenterWithTerminDTO[] = [];

  constructor(private centerWithTerminService: CenterWithTerminServiceComponent, private centerService: CenterService, private router: Router, private authService: AuthService) 
  {
    const today = new Date();
    this.minDate = today.toISOString().substring(0, 16);
   }

  ngOnInit(): void {
    this.averageSort = false;
  }

  logout(){
    this.authService.logout()
  }

  public sortByAverageRating() {
    this.averageSort = true;

    if(this.sort == false){
      this.centerService.getCentersSortedbyAverageRating(this.page).subscribe(res => {
        this.centriSaTerminima = res;
      })

      this.sort = true;
    }else{
      this.centerService.getCentersSortedbyAverageRatingDes(this.page).subscribe(res => {
        this.centriSaTerminima = res;
      })

      this.sort = false;
    }
  }


  public reset(){
    this.averageSort = false;
    this.datum = new Date();
    this.showForm = false;

    this.centriSaTerminima = []

  }

  public search(){
    this.showForm = true;
    console.log(this.datum);

    this.centerService.getCentersbyDateWithFreeAppointments(this.datum).subscribe(res => {
      this.centriSaTerminima = res;
      console.log(this.centriSaTerminima);
    })
  }

schedulingAppointment(centerWithTermin: any): void {
  this.centerWithTerminService.setCenterWithTermin(centerWithTermin);
  this.router.navigate(['/scheduleCenterAppointment']);
}

}
