import { Component, OnInit } from '@angular/core';
import { Termin } from '../../hospital/model/termin';
import { TerminDTO } from '../../hospital/model/terminDTO';
import { CenterDTO } from '../../hospital/model/centerDTO';
import { CenterAdministratorService } from '../../hospital/services/centerAdministrator.service';
import { Center } from '../../hospital/model/center';
import { Router } from '@angular/router';
import { TerminService } from '../service/termin.service';
import { CenterService } from '../service/center.service';
import { AuthService } from '../../hospital/services/auth.service';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { Observable, catchError, map, of } from 'rxjs';
import { Person } from '../../hospital/model/person';

@Component({
  selector: 'app-occupied-calendar-admin',
  templateUrl: './occupied-calendar-admin.component.html',
  styleUrls: ['./occupied-calendar-admin.component.css']
})
export class OccupiedCalendarAdminComponent implements OnInit {

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

  public osoba : Person = new Person();
  public osobaId : number = 0;
  public osobe: Person[] = [];

  public ime: string = '';
  public prezime : string = '';

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

          this.terminService.getZauzetiTerminiByCenterId(this.centerId).subscribe(res1 => {
            this.termini = res1;
            this.osobe = [];
          
            this.termini.forEach((termin: TerminDTO) => {
              this.osobaId = termin.korisnikId;
          
              this.registerPersonService.getPerson(this.osobaId).subscribe(res2 => {
                const osoba: Person = res2;
                this.osobe.push(osoba);
          
                console.log(osoba);
              });
            });
          });
          

          })
        })  
    }
  }
  
  getPerson(personId: number): Observable<string> {
    return this.registerPersonService.getPerson(personId).pipe(
      map(person => `${person.name}`)
    );
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
    console.log(this.centerDTO);
  
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
        this.terminService.createTermin(this.termin).subscribe((res) => {
          alert("You have successfully created period!");
          this.cancel();
          this.ngOnInit();
        });
      } else {
        alert("Selected period is not within working hours!");
      }
    }
  }

  public Appointments(id: any){
    localStorage.setItem('termin_id', id);
    this.router.navigate(['/centerAppointments']);
  }

  parseDate(date: Date): Date {
    return new Date(date);
  }  

  public reset(){
    this.ime = '';
    this.prezime = '';
    this.terminService.getZauzetiTerminiByCenterId(this.centerId).subscribe(res => {
      this.termini = res;
      this.osobe = [];
          
            this.termini.forEach((termin: TerminDTO) => {
              this.osobaId = termin.korisnikId;
          
              this.registerPersonService.getPerson(this.osobaId).subscribe(res2 => {
                const osoba: Person = res2;
                this.osobe.push(osoba);
          
                console.log(osoba);
              });
            });
    })
  }

  private isInputValidButton(): boolean {

    if (this.ime == '' ||  this.prezime == '') {
      //alert("Must fill all fields!");
      return false;
    }
    else{
      return true;
    }
  }

  public searchByNameAndSurname() {
    if(this.isInputValidButton()) {
      this.terminService.getAllbyNameSurname(this.ime, this.prezime, this.centerId).subscribe(res => {
        this.termini = res;
        this.osobe = [];
            
              this.termini.forEach((termin: TerminDTO) => {
                this.osobaId = termin.korisnikId;
            
                this.registerPersonService.getPerson(this.osobaId).subscribe(res2 => {
                  const osoba: Person = res2;
                  this.osobe.push(osoba);
            
                  console.log(osoba);
                });
              });
      })

    } else {
      alert("Must fill all fields!");
    }
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
