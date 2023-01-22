import { Component, OnInit } from '@angular/core';
import { AppointmentDTO } from '../model/appointmentDto';
import { AppointmentService } from '../services/appointment.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-user-appointments',
  templateUrl: './user-appointments.component.html',
  styleUrls: ['./user-appointments.component.css']
})
export class UserAppointmentsComponent implements OnInit {
  public centers: AppointmentDTO[] = [];

  public sort : boolean = false;
  public page: number = 0;
  public dateSort: boolean = false;

  
  constructor(private appointmentService: AppointmentService, private authService: AuthService) { }

  ngOnInit(): void {
    this.dateSort = false;
    let pom = localStorage.getItem('username');
    if(pom != null){ 
      this.appointmentService.getUserAppointment(this.page, pom).subscribe(res => {
        this.centers = res;
      })
      console.log(this.centers)
    } 
  }

  public converzion(vreme: any):any {
    let date = new Date(vreme);
  	let current_date = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+ date.getDate();
	  let current_time = date.getHours()+":"+date.getMinutes()+":"+ date.getSeconds();
	  let date_time = current_date+" "+current_time;	

    return date_time;
  }

  public nextButton(){
    let pom = localStorage.getItem('username');
    if(pom != null){ 
    
    if(this.centers.length >= 10 ){
      this.page =this.page + 1;
    
      if(this.dateSort == true){
        this.sort = (!this.sort);

        this.sortByDate();
      }else{
        this.appointmentService.getUserAppointmentSorted(this.page,pom).subscribe(res => {
          this.centers = res;
        })
      }
    }
    }
  }
  
  public refuse(appointment: any){
    this.appointmentService.setAppointmentFree(appointment.id).subscribe(res => {
      this.centers.splice(appointment);
      let pom = localStorage.getItem('username');
    if(pom != null){ 
      this.appointmentService.getUserAppointment(this.page, pom).subscribe(res => {
        this.centers = res;
      })
    }

    })
    
  }

  public previousButton(){
    let pom = localStorage.getItem('username');
    if(pom != null){ 
    
    if(this.page - 1 >=0 ){
      this.page =this.page - 1;
      if(this.dateSort == true){
        this.sort = (!this.sort)

        this.sortByDate();
      }else{
        this.appointmentService.getUserAppointmentSorted(this.page,pom).subscribe(res => {
          this.centers = res;
        })
      }
    }
    }
  }

  public sortByDate() {
    let pom = localStorage.getItem('username');
    if(pom != null){ 
    
    if(this.sort == false){
      this.appointmentService.getUserAppointmentSorted(this.page,pom).subscribe(res => {
        this.centers = res;
      })
  
      this.sort = true;
    }else{
      this.appointmentService.getUserAppointment(this.page,pom).subscribe(res => {
        this.centers = res;
      })
      this.sort = false;
    }
    }
  }

}
