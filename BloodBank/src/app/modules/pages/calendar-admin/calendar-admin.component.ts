import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { CenterService } from '../service/center.service';
import { AuthService } from '../../hospital/services/auth.service';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { Termin } from '../../hospital/model/termin';
import { TerminService } from '../service/termin.service';
import { TerminDTO } from '../../hospital/model/terminDTO';
import { CenterAdministratorService } from '../../hospital/services/centerAdministrator.service';
import { Center } from '../../hospital/model/center';
import { CenterDTO } from '../../hospital/model/centerDTO';

@Component({
  selector: 'app-calendar-admin',
  templateUrl: './calendar-admin.component.html',
  styleUrls: ['./calendar-admin.component.css']
})
export class CalendarAdminComponent implements OnInit {

  public termini: TerminDTO[] = [];
  personId : number = 0;
  centerId : number = 0;
  public showForm: boolean = false;
  startDate: Date = new Date();
  endDate: Date = new Date();
  datum: Date = new Date();
  duration : number = 0;
  public minEndDate: string = '';
  public termin : Termin = new Termin();
  public terminDTO : TerminDTO = new TerminDTO();
  public centar : Center = new Center();
  public centerDTO : CenterDTO = new CenterDTO();

  public appointmenti: TerminDTO[] = [];


  constructor(private router: Router, private centerAdministratorService: CenterAdministratorService, private terminService: TerminService, private centerService: CenterService, private authService: AuthService, private registerPersonService : RegisterPersonService) 
  {
    const today = new Date();
    this.minEndDate = today.toISOString().substring(0, 16);
   }

  
  ngOnInit(): void {
    
    const username = this.authService.getCurrentUserUsername();
    if (username) {
      this.registerPersonService.getUserByUsername(username).subscribe(person => {
        this.personId = person.id;
        console.log(this.personId);
  
        this.centerService.getAllForAdminCenter(this.personId).subscribe(res => {
          console.log(res);
          this.centerDTO = res;
          this.centerId = res.id

          this.terminService.getSlobodniTerminiByCenterId(this.centerId).subscribe(res1 => {
            this.termini = res1;
          })

          this.terminService.getTerminiByCenterId(this.centerId).subscribe(appointmenti => {
            this.appointmenti = appointmenti;
          })

        })

    })   
    }
  }

  logout(){
    this.authService.logout()
  }

  formatirajDatum(datum: string): string {
    const [godina, mesec, dan, sat, minut] = datum.split(',');
    return `${godina}-${mesec}-${dan} ${sat}:${minut}:00`;
  }

  addPeriod() {
    this.showForm = true;
  }

  cancel() {
    this.startDate = new Date()
    this.endDate = new Date()
    this.duration = 0
    this.showForm = false;
  }

  createPeriod() {  
    console.log(this.appointmenti);

    this.termin.pocetakTermina = this.startDate;
    this.termin.krajTermina = this.endDate;
    this.termin.trajanje = this.duration;
    this.termin.center.id = this.centerId;
    this.termin.centerId = this.centerId;

    console.log(this.termin);
  
    if (this.isInputValid()) {
      let isWithinWorkingHours = false;
  
      this.centerDTO.radnoVreme.forEach((radnoVreme) => {
  
        if (this.startDate >= radnoVreme.vremeOtvaranja && this.endDate <= radnoVreme.vremeZatvaranja) {
          isWithinWorkingHours = true;
        }
      });
  
      if (isWithinWorkingHours) {
        let isConflict = false;
      
        this.appointmenti.forEach((termin: TerminDTO) => {
          if (this.startDate <= termin.krajTermina && this.endDate >= termin.pocetakTermina) {
            alert("Already exists appointment which is scheduled in this time!");
            isConflict = true;
            return; // Prekida petlju ako se pronađe preklapanje
          }
        });
      
        if (!isConflict) {
          this.terminService.createTermin(this.termin).subscribe((res) => {
            alert("Appointment is succesfully created!");
            this.cancel();
            this.ngOnInit();
          });
        }
      } else {
        alert("Selected period is not within working hours!");
      }
      
    }
  }

  parseDate(date: Date): Date {
    return new Date(date);
  }  


  private isInputValid(): boolean {

    if (this.duration == 0 || !this.startDate || !this.endDate) {
      alert("Must fill all fields!");
      return false;
    }
    if(this.endDate <= this.startDate){
      alert("Start Date must be less than the End Date!")
      return false;
    }
    return true;
  }



}
