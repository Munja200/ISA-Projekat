import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { AuthService } from '../../hospital/services/auth.service';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { Router } from '@angular/router';
import { RegisteredPerson } from '../../hospital/model/registeredPerson';
import { Address } from '../../hospital/model/address';
import { RegisteredUserUpdateDTO } from '../../hospital/model/registeredUserUpdateDTO';
import { Person } from '../../hospital/model/person';
import { MatTableDataSource } from '@angular/material/table';
import { CenterDTO } from '../../hospital/model/centerDTO';
import { CenterService } from '../service/center.service';

@Component({
  selector: 'app-edit-center',
  templateUrl: './edit-center.component.html',
  styleUrls: ['./edit-center.component.css']
})
export class EditCenterComponent implements OnInit {

  public dataSource = new MatTableDataSource<Person>();

  public address: Address = new Address();
  public id : number = 0;
  public personId : number = 0;
  public centerDTO: CenterDTO = new CenterDTO();
  

  constructor(private authService: AuthService, private registerPersonService: RegisterPersonService, private centerService: CenterService, private router: Router) { }

  ngOnInit(): void {
    const username = this.authService.getCurrentUserUsername();
    if (username) {
      this.registerPersonService.getUserByUsername(username).subscribe(person => {
        this.personId = person.id;
        console.log(this.personId);
  
        
        this.centerService.getAllForAdminCenter(this.personId).subscribe(centar => {
          this.centerDTO = centar;
          console.log(centar);
      });
    });
    }
  }

  public editProfile() {
    
  }

  logout(){
    this.authService.logout()
  }

  private isInputValid(): boolean {
    return this.centerDTO.name != '' && this.centerDTO.address.country != '' && this.centerDTO.address.city != ''
    && this.centerDTO.address.street != '' && this.centerDTO.address.number != '' && this.centerDTO.description != '' ;
}

requiredDescriptionControl = new FormControl('', [
    Validators.required,
  ]);
  requiredScoreControl = new FormControl('', [
    Validators.required,
  ]);
  requiredNameControl = new FormControl('', [
    Validators.required,
  ]);
  requiredNumberControl = new FormControl('', [
    Validators.required,
  ]);
  requiredPhoneNumberControl = new FormControl('', [
    Validators.required,
  ]);
  requiredAddressControl = new FormControl('', [
    Validators.required,
  ]);
  requiredCityControl = new FormControl('', [
    Validators.required,
  ]);
  requiredCountryControl = new FormControl('', [
    Validators.required,
  ]);

}


