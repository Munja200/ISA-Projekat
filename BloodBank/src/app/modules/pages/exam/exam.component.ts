import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../hospital/services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TerminDTO } from '../../hospital/model/terminDTO';
import { Person } from '../../hospital/model/person';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { RegisteredUserUpdateDTO } from '../../hospital/model/registeredUserUpdateDTO';
import { ReportService } from '../service/report.service';
import { Report } from '../../hospital/model/report';
import { BloodService } from '../../hospital/services/blood.service';
import { TerminService } from '../service/termin.service';
import { Termin } from '../../hospital/model/termin';

@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  styleUrls: ['./exam.component.css']
})
export class ExamComponent implements OnInit {

  showingForm1: boolean = false;
  showingForm3: boolean = false;

  name: string = '';
  surname : string = '';

  public pocetak: Date = new Date();
  public kraj: Date = new Date();

  public terminDTO : TerminDTO = new TerminDTO();

  public registeredUserDto: RegisteredUserUpdateDTO = new RegisteredUserUpdateDTO(0, '', '', '', '', '', '', '', new Date(), '', null, '', 0);
  public korisnikId : number = 0;
  public centerId : number = 0;
  public terminId : number = 0;

  public report: Report = new Report();
  public quantity : number = 0;
  public description : string = '';
  public bloodType : string = '';

  terminDTOpomoc : TerminDTO = new TerminDTO();

  constructor(private bloodService: BloodService, private terminService: TerminService, private reportService: ReportService, private route: ActivatedRoute, private registerPersonService: RegisterPersonService, private router: Router, private authService: AuthService, ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.terminId = params['termin_id'];
      this.korisnikId = params['korId'];
      this.name = params['name'];
      this.surname = params['surname'];
      this.pocetak = params['startDate'];
      this.kraj = params['endDate'];
      this.centerId = params['center'];
    });

    this.registerPersonService.getPerson(this.korisnikId).subscribe( res => {
      this.registeredUserDto = res;
    })
  }

  logout(){
    this.authService.logout()
  }
  
  save() {
    this.report.bloodType = this.bloodType;
    this.report.description = this.description;
    this.report.quantity = this.quantity;
    this.reportService.saveReport(this.report).subscribe( res3 => {
      alert('You have successfully examed patient');
  
  })

    this.bloodService.changeBlood(this.centerId, this.quantity, this.bloodType).subscribe (krvv => {   
      alert('Blood quantity updated');

  })

  this.terminService.getById(this.terminId).subscribe(res => {
    this.terminDTOpomoc = res;
    this.terminDTOpomoc.report = this.report;
    this.terminService.editTermina(this.terminDTOpomoc).subscribe((res) => {
      console.log(res)
      alert("You have successfully scheduling appointment!");
      this.router.navigate(['/homeAdminCenter']);
    });
  });

  

  
  //this.router.navigate(['/homeAdminCenter']);

  }

  showForm1() {
    this.showingForm1 = true;
    this.showingForm3 = false;
  }

  givePenal() {
    this.showingForm1 = false;
    this.showingForm3 = false;
    this.registeredUserDto.penal = this.registeredUserDto.penal + 1; 
    this.registerPersonService.updateRegisteredUser(this.registeredUserDto).subscribe( res2 => {
      alert('You have successfully given a penalty to a user');
      this.router.navigate(['/homeAdminCenter']);
  })
}

  showForm3() {
    this.showingForm1 = false;
    this.showingForm3 = true;
  }

  formatirajDatum(datum: string): string {
    const [godina, mesec, dan, sat, minut] = datum.split(',');
    return `${godina}-${mesec}-${dan} ${sat}:${minut}:00`;
  }
  
  padNumber(number: number): string {
    return number.toString().padStart(2, '0');
  }

}
