import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from '../model/address';
import { Person } from '../model/person';
import { RegisteredPerson } from '../model/registeredPerson';
import { RegisteredUserUpdateDTO } from '../model/registeredUserUpdateDTO';
import { RegisterPersonService } from '../services/register-person.service';
import { FormControl, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-edit-profil-registered-user',
  templateUrl: './edit-profil-registered-user.component.html',
  styleUrls: ['./edit-profil-registered-user.component.css']
})
export class EditProfilRegisteredUserComponent implements OnInit {
   
  public dataSource = new MatTableDataSource<Person>();

  public address: Address = new Address();
  public person: Person = new Person(0,'','','','','','','',0,new Date(),'','','',this.address);
  public registeredUser: RegisteredPerson = new RegisteredPerson(0, false, this.person);
  public id : number = 0;
  public personId : number = 0;
  public registeredUserDto: RegisteredUserUpdateDTO = new RegisteredUserUpdateDTO(0, '', '', '', '', '', '', '', new Date(), '', this.address, '');
  

  constructor(private authService: AuthService, private registerPersonService: RegisterPersonService, private router: Router) { }

  ngOnInit(): void {
    const username = this.authService.getCurrentUserUsername();
    console.log(username);
    if (username) {
      this.registerPersonService.getUserByUsername(username).subscribe(osoba => {
          this.registeredUserDto = osoba;
          this.registeredUserDto.password = '';
      });
    }
  }

  public editProfile() {
    if (this.isInputValid()) {
      console.log(this.person);
      this.registerPersonService.updateRegisteredUser(this.registeredUserDto).subscribe(res => {
        this.registeredUserDto = res;      
        alert("You have successfully updated!");
        this.router.navigate(['/home']);
      });
    } else {
      alert("You must fill in all fields!");
    }
  }

  private isInputValid(): boolean {
    return this.registeredUserDto.name != '' && this.registeredUserDto.surname != '' && this.registeredUserDto.phonNumber != '' && this.registeredUserDto.address.country != '' && this.registeredUserDto.address.city != ''
    && this.registeredUserDto.address.street != '' && this.registeredUserDto.occupation != '' && this.registeredUserDto.bloodType != '' && this.registeredUserDto.password != ''
}

  logout() {
    
  }

  requiredBloodTypeControl = new FormControl('', [
    Validators.required,
    Validators.pattern(/^(A|B|AB|O)[+-]$/)
  ]);
  requiredPasswordControl = new FormControl('', [
    Validators.required,
  ]);
  requiredNameControl = new FormControl('', [
    Validators.required,
  ]);
  requiredNumberControl = new FormControl('', [
    Validators.required,
  ]);
  requiredSurnameControl = new FormControl('', [
    Validators.required,
  ]);
  requiredJmbgControl = new FormControl('', [
    Validators.required,
  ]);
  requiredConfirmationPasswordControl = new FormControl('', [
    Validators.required,
  ])
  requiredPhoneNumberControl = new FormControl('', [
    Validators.required,
  ]);
  requiredOccupationControl = new FormControl('', [
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
  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

}
