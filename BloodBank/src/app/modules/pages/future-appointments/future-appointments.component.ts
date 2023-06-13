import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CenterAdministratorService } from '../../hospital/services/centerAdministrator.service';
import { TerminService } from '../service/termin.service';
import { CenterService } from '../service/center.service';
import { AuthService } from '../../hospital/services/auth.service';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { Termin } from '../../hospital/model/termin';
import { TerminDTO } from '../../hospital/model/terminDTO';
import { CenterDTO } from '../../hospital/model/centerDTO';
import { TerminWithCenterNameDTO } from '../../hospital/model/terminWithCenterNameDTO';

@Component({
  selector: 'app-future-appointments',
  templateUrl: './future-appointments.component.html',
  styleUrls: ['./future-appointments.component.css']
})
export class FutureAppointmentsComponent implements OnInit {

  personId : number = 0;
  centerId : number = 0;
  duration : number = 0;
  public termin : Termin = new Termin();
  public terminDTO : TerminDTO = new TerminDTO();
  public centerDTO : CenterDTO = new CenterDTO();

  public terminiWithCenterName: TerminWithCenterNameDTO[] = [];

  constructor(private router: Router, private centerAdministratorService: CenterAdministratorService, 
    private terminService: TerminService, private centerService: CenterService, private authService: AuthService, 
    private registerPersonService : RegisterPersonService) { }

  ngOnInit(): void {

    const username = this.authService.getCurrentUserUsername();
    if (username) {
      this.registerPersonService.getUserByUsername(username).subscribe(person => {
        this.personId = person.id;
        console.log(this.personId);

        this.terminService.getTerminiByKorId(this.personId).subscribe(res => {
          this.terminiWithCenterName = res;
        })

    })   
    }
  }

  logout(){
    this.authService.logout()
  }

}
