import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../hospital/services/auth.service';
import { AppointmentService } from '../../hospital/services/appointment.service';
import { AppointmentDTO } from '../../hospital/model/appointmentDto';
import { CenterDTO } from '../../hospital/model/centerDTO';
import { Center } from '../../hospital/model/center';
import { CenterService } from '../service/center.service';
import { Grade } from '../../hospital/model/grade';
import { GradeService } from '../../hospital/services/grade.service';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { Person } from '../../hospital/model/person';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rate-center',
  templateUrl: './rate-center.component.html',
  styleUrls: ['./rate-center.component.css']
})
export class RateCenterComponent implements OnInit {
 
  public center : Center = new Center();
  public grade: Grade = new Grade();
  public showForm: boolean = true;

  public personId: number = 0;
  public currentPerson: Person = new Person();
  public isSubmitted: boolean = false;
  
  public pom: any = localStorage.getItem('centar_id');
  public prenesenaOcenaId: any = localStorage.getItem('grade_id');
  public prenesenaOcenaCenterId: any = localStorage.getItem('grade_center_id');
  public prenesenaOcenaPersonId: any = localStorage.getItem('grade_person_id');
  public prenesenaOcenaScore: any = localStorage.getItem('grade_score');
  
  constructor(private router: Router, private registerPersonService: RegisterPersonService, private gradeService: GradeService,private centerService: CenterService, private authService: AuthService) { }

  ngOnInit(): void {

    this.grade.id = parseInt(this.prenesenaOcenaId)
    this.grade.centerId = parseInt(this.prenesenaOcenaCenterId)
    this.grade.personId = parseInt(this.prenesenaOcenaPersonId)
    this.grade.score = parseInt(this.prenesenaOcenaScore)

    console.log(this.grade)

    this.centerService.getById(this.pom).subscribe(res => {
      this.center = res;
      console.log(this.center);
    })
    
  }

  submitRating() {
    if (this.grade.score < 1 || this.grade.score > 10) {
      alert('Please enter a rating between 1 and 10.');
        return;
    } else {
    this.gradeService.updateGrade(this.grade).subscribe(
      response => {
        alert('Grade are changed successfully');
        this.router.navigate(['/grade']);
      },
      error => {
        console.error('Error creating grade:', error);
      }
    );
    }
  }

  logout(){
    this.authService.logout()
  }

}
