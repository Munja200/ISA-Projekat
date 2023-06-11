import { Component, OnInit } from '@angular/core';
import { CenterService } from '../service/center.service';
import { Router } from '@angular/router';
import { AuthService } from '../../hospital/services/auth.service';
import { CenterDTO } from '../../hospital/model/centerDTO';

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

  constructor(private centerService: CenterService, private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
    this.averageSort = false;
    this.centerService.getCentersbyPage(this.page).subscribe(res => {
      this.centers = res;
    })
  }

  logout(){
    this.authService.logout()
  }

  public sortByAverageRating() {
    this.averageSort = true;

    if(this.sort == false){
      this.centerService.getCentersSortedbyAverageRating(this.page).subscribe(res => {
        this.centers = res;
      })

      this.sort = true;
    }else{
      this.centerService.getCentersSortedbyAverageRatingDes(this.page).subscribe(res => {
        this.centers = res;
      })

      this.sort = false;
    }
  }

  public nextButton(){
    if(this.centers.length >= 10 ){
      this.page =this.page + 1;
    
      if(this.averageSort == true){
        this.sort = (!this.sort);

        this.sortByAverageRating();
      }else{
        this.centerService.getCentersbyPage(this.page).subscribe(res => {
          this.centers = res;
        })
      }
    }
  }

  public previousButton(){
    if(this.page - 1 >=0 ){
      this.page =this.page - 1;
      if(this.averageSort == true){
        this.sort = (!this.sort)

        this.sortByAverageRating();
      }else{
        this.centerService.getCentersbyPage(this.page).subscribe(res => {
          this.centers = res;
        })
      }
    }
  }

  public reset(){
    this.averageSort = false;
    this.datum = new Date();

    this.centerService.getCentersbyPage(this.page).subscribe(res => {
      this.centers = res;
    })
  }

  public search(){
    this.showForm = true;

  }

}
