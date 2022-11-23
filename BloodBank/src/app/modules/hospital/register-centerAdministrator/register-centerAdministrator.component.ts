import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CenterAdministratorDTO } from '../model/centerAdministratorDTO';
import { CenterDTO } from '../model/centerDTO';
import { CenterService } from '../services/center.service';
import { CenterAdministratorService } from '../services/centerAdministrator.service';

@Component({
  selector: 'app-register-center',
  templateUrl: './register-centerAdministrator.component.html',
  styleUrls: ['./register-centerAdministrator.component.css']
})
export class RegisterCenterAdministratorComponent implements OnInit {
  public genders: String[] = ['Male',' Female'];
  public bloodTypes: String[] = ['O-','O+','A-','A+','B-','B+','AB-','AB+']
  public password: String = "";
  public centerAdministrator: CenterAdministratorDTO = new CenterAdministratorDTO();
  public centers: CenterDTO[] = [];

  constructor(private router: Router, private centerService: CenterService, private centerAdministratorService: CenterAdministratorService) { }

  ngOnInit(): void {
    this.centerService.getAllForAdministratorRegistration().subscribe(res => {
      this.centers = res;
    });
  }

  registeCenterAdministrator() {
    this.centerAdministratorService.registerCenterAdministrator(this.centerAdministrator).subscribe(res => {
      console.log("Radi")
    });
  }

  consoleLog(){
    console.log(this.centerAdministrator)
  }
}
