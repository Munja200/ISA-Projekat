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

  public personId: number = 0;
  public currentPerson: Person = new Person();
  
  public pom: any = localStorage.getItem('centar_id');
  
  constructor(private router: Router, private registerPersonService: RegisterPersonService, private gradeService: GradeService,private centerService: CenterService, private authService: AuthService) { }

  ngOnInit(): void {
    
    this.centerService.getById(this.pom).subscribe(res => {
      this.center = res;
      console.log(this.center);
    })

   
      const username = this.authService.getCurrentUserUsername();
      if (username) {
        this.registerPersonService.getUserByUsername(username).subscribe(person => {
          this.personId = person.id;
          console.log(this.personId);
    
          this.currentPerson = person;
    
          this.gradeService.findGradeByCenterAndPersonId(this.pom, this.personId).subscribe(ocena => {
            this.grade = ocena;
            console.log(ocena);
          });
        });
      }
    

  }

  submitRating() {
    if (this.grade.score < 1 || this.grade.score > 10) {
      alert('Please enter a rating between 1 and 10.');
        return;
    } else {
    this.gradeService.updateGrade(this.grade).subscribe(
      response => {
        alert('Grade created successfully');
        this.router.navigate(['/grade']);
      },
      error => {
        // Obrada greške
        console.error('Error creating grade:', error);
      }
    );
    }


    
  }

  logout(){
    this.authService.logout()
  }

}
