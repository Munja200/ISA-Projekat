import { Component, OnInit } from '@angular/core';
import { Termin } from '../../hospital/model/termin';
import { CenterDTO } from '../../hospital/model/centerDTO';
import { TerminDTO } from '../../hospital/model/terminDTO';
import { TerminWithCenterNameDTO } from '../../hospital/model/terminWithCenterNameDTO';
import { Router } from '@angular/router';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { CenterAdministratorService } from '../../hospital/services/centerAdministrator.service';
import { CenterService } from '../service/center.service';
import { TerminService } from '../service/termin.service';
import { AuthService } from '../../hospital/services/auth.service';

@Component({
  selector: 'app-history-termins',
  templateUrl: './history-termins.component.html',
  styleUrls: ['./history-termins.component.css']
})
export class HistoryTerminsComponent implements OnInit {

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

        this.terminService.getTerminiByUserId(this.personId).subscribe(res => {
          this.terminiWithCenterName = res;
        })

    })   
    }
  }

  logout(){
    this.authService.logout()
  }

}


