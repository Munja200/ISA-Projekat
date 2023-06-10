import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Address } from '../model/address';
import { Person } from '../model/person';
import { RegisteredPerson } from '../model/registeredPerson';
import { RegisteredUserUpdateDTO } from '../model/registeredUserUpdateDTO';
import { RegisterPersonService } from '../services/register-person.service';

@Component({
  selector: 'app-profil-of-registered-user',
  templateUrl: './profil-of-registered-user.component.html',
  styleUrls: ['./profil-of-registered-user.component.css']
})
export class ProfilOfRegisteredUserComponent implements OnInit {
  
  public dataSource = new MatTableDataSource<Person>();

  public address: Address = new Address();
  public person: Person = new Person(0,'','','','','','','',0,new Date(),'','','',this.address);
  public registeredUser: RegisteredPerson = new RegisteredPerson(0, false, this.person);
  public id : number = 0;
  
  constructor(private registerPersonService: RegisterPersonService,private router: Router) { }

  ngOnInit(): void {
    this.registerPersonService.getRegisteredPerson(3).subscribe(res => {
      this.registeredUser = res;
      console.log(this.registeredUser);
    })
  }

  public editProfile() {
      this.router.navigate(['/editProfilRegisteredUser']);
    
  }

}
