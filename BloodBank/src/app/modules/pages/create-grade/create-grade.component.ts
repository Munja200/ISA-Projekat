import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { GradeService } from '../../hospital/services/grade.service';
import { CenterService } from '../service/center.service';
import { AuthService } from '../../hospital/services/auth.service';
import { Grade } from '../../hospital/model/grade';
import { Center } from '../../hospital/model/center';

@Component({
  selector: 'app-create-grade',
  templateUrl: './create-grade.component.html',
  styleUrls: ['./create-grade.component.css']
})
export class CreateGradeComponent implements OnInit {

  public pom: any = localStorage.getItem('centar_id');
  public pomp: any = localStorage.getItem('person_id');
  public grade: Grade = new Grade();
  public center : Center = new Center();
  public showForm: boolean = false;

  constructor(private router: Router, private registerPersonService: RegisterPersonService, private gradeService: GradeService,private centerService: CenterService, private authService: AuthService) { }

  ngOnInit(): void {

    this.centerService.getById(this.pom).subscribe(res => {
      this.center = res;
      console.log(this.center);
    })

    this.grade.centerId = this.pom
    this.grade.personId = parseInt(this.pomp)

  }

  createGrade() {
    if (this.grade.score < 1 || this.grade.score > 10) {
      alert('Please enter a rating between 1 and 10.');
        return;
    } else {
    this.gradeService.createGrade(this.grade).subscribe(
      response => {
        alert('You have successfully rated the center!');
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
