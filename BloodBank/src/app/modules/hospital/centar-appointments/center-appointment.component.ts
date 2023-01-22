import { Component, OnInit } from '@angular/core';
import { AppointmentDTO } from '../model/appointmentDto';
import { AppointmentService } from '../services/appointment.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-center-appointment',
  templateUrl: './center-appointment.component.html',
  styleUrls: ['./center-appointment.component.css']
})
export class CenterAppointmentComponent implements OnInit {
  public centers: AppointmentDTO[] = [];

  public sort : boolean = false;
  public page: number = 0;
  public dateSort: boolean = false;
  public pom: any = localStorage.getItem('centar_id');
  
  constructor(private appointmentService: AppointmentService, private authService: AuthService) { }

  ngOnInit(): void {
    this.dateSort = false;
    this.appointmentService.getAllFreeCentersAppointment(this.page,this.pom).subscribe(res => {
      this.centers = res;
    })
    console.log(this.centers)
  }

  public converzion(vreme: any):any {
    let date = new Date(vreme);
  	let current_date = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+ date.getDate();
	  let current_time = date.getHours()+":"+date.getMinutes()+":"+ date.getSeconds();
	  let date_time = current_date+" "+current_time;	

    return date_time;
  }

  public nextButton(){
    if(this.centers.length >= 10 ){
      this.page =this.page + 1;
    
      if(this.dateSort == true){
        this.sort = (!this.sort);

        this.sortByDate();
      }else{
        this.appointmentService.getAllFreeCentersAppointment(this.page,this.pom).subscribe(res => {
          this.centers = res;
        })
      }
    }
  }
  
  public add(appointment: any){
    let username = localStorage.getItem('username');
    if(username!= null){
    this.appointmentService.setFreebyUser(appointment.id, username).subscribe(res => {
      
      this.centers.splice(appointment);
      this.appointmentService.getAllFreeCentersAppointment(this.page,this.pom).subscribe(res => {
        this.centers = res;
      })
    })}
    
  }

  public previousButton(){
    if(this.page - 1 >=0 ){
      this.page =this.page - 1;
      if(this.dateSort == true){
        this.sort = (!this.sort)

        this.sortByDate();
      }else{
        this.appointmentService.getAllFreeCentersAppointment(this.page,this.pom).subscribe(res => {
          this.centers = res;
        })
      }
    }
  }

  public sortByDate() {
    
    if(this.sort == false){
      this.appointmentService.getAllFreeCentersAppointmentSorted(this.page,this.pom).subscribe(res => {
        this.centers = res;
      })
  
      this.sort = true;
    }else{
      this.appointmentService.getAllFreeCentersAppointmentSortedDesc(this.page,this.pom).subscribe(res => {
        this.centers = res;
      })
      this.sort = false;
    }
  }

}
