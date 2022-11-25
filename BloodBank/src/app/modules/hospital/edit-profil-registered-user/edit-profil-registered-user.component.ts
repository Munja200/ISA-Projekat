import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from '../model/address';
import { Person } from '../model/person';
import { RegisteredPerson } from '../model/registeredPerson';
import { RegisteredUserUpdateDTO } from '../model/registeredUserUpdateDTO';
import { RegisterPersonService } from '../services/register-person.service';

@Component({
  selector: 'app-edit-profil-registered-user',
  templateUrl: './edit-profil-registered-user.component.html',
  styleUrls: ['./edit-profil-registered-user.component.css']
})
export class EditProfilRegisteredUserComponent implements OnInit {
  
  public address: Address = new Address(0, false, 0, 0, '', '', '', '');
  public person: Person = new Person(0,'','','','','','','',0,new Date(),'','','',this.address);
  public registeredUser: RegisteredPerson = new RegisteredPerson(0, false, this.person);
  public registeredUserDto: RegisteredUserUpdateDTO = new RegisteredUserUpdateDTO(4, '', '', '', '', '', '', '', new Date(), '', this.address);

  constructor(private registerPersonService: RegisterPersonService,private router: Router) { }

  ngOnInit(): void {
    this.registerPersonService.getRegisteredPerson(4).subscribe(res => {
      this.registeredUser = res;
      console.log(this.registeredUser);
  })
}

  public editProfile() {
    this.registerPersonService.updateRegisteredUser(this.registeredUserDto).subscribe(res => {
      this.registeredUser = res;
      window.confirm("Information of registered user is changed!");

  })
}

}
