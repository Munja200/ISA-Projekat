import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { CenterService } from '../service/center.service';
import { AuthService } from '../../hospital/services/auth.service';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { Termin } from '../../hospital/model/termin';
import { TerminService } from '../service/termin.service';
import { TerminDTO } from '../../hospital/model/terminDTO';
import { CenterAdministratorService } from '../../hospital/services/centerAdministrator.service';

@Component({
  selector: 'app-calendar-admin',
  templateUrl: './calendar-admin.component.html',
  styleUrls: ['./calendar-admin.component.css']
})
export class CalendarAdminComponent implements OnInit {

  public termini: TerminDTO[] = [];
  personId : number = 0;
  centerId : number = 0;

  constructor(private router: Router, private centerAdministratorService: CenterAdministratorService, private terminService: TerminService, private centerService: CenterService, private authService: AuthService, private registerPersonService : RegisterPersonService) { }

  ngOnInit(): void {

    const username = this.authService.getCurrentUserUsername();
    if (username) {
      this.registerPersonService.getUserByUsername(username).subscribe(person => {
        this.personId = person.id;
        console.log(this.personId);
  
        this.centerService.getAllForAdminCenter(this.personId).subscribe(res => {
          console.log(res);
          this.centerId = res.id
          this.terminService.getTerminiByCenterId(this.centerId).subscribe(res1 => {
            this.termini = res1;
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


  


}
