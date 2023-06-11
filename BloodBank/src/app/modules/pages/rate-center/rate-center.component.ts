import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../hospital/services/auth.service';
import { AppointmentService } from '../../hospital/services/appointment.service';
import { AppointmentDTO } from '../../hospital/model/appointmentDto';
import { CenterDTO } from '../../hospital/model/centerDTO';
import { Center } from '../../hospital/model/center';
import { CenterService } from '../service/center.service';
import { Grade } from '../../hospital/model/grade';

@Component({
  selector: 'app-rate-center',
  templateUrl: './rate-center.component.html',
  styleUrls: ['./rate-center.component.css']
})
export class RateCenterComponent implements OnInit {
 
  public center : Center = new Center();
  public grade: Grade = new Grade();
  
  public pom: any = localStorage.getItem('centar_id');
  
  constructor(private appointmentService: AppointmentService,private centerService: CenterService, private authService: AuthService) { }

  ngOnInit(): void {
    this.centerService.getById(this.pom).subscribe(res => {
      this.center = res;
      console.log(this.center);
    })

  }

  submitRating() {

  }

  logout(){
    this.authService.logout()
  }

}
