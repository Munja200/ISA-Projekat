import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from '../model/address';
import { Person } from '../model/person';
import { RegisterPersonService } from '../services/register-person.service';

@Component({
  selector: 'app-register-person',
  templateUrl: './register-person.component.html',
  styleUrls: ['./register-person.component.css']
})
export class RegisterPersonComponent implements OnInit {
  public address: Address = new Address();
  public person: Person = new Person(0,'','','','','','','',0,new Date(),'','','',this.address);
  public password: String= this.person.password;
  public genders: String[] = ['Male',' Female'];
  public bloodTypes: String[] = ['O-','O+','A-','A+','B-','B+','AB-','AB+']

  constructor(private registerPersonService: RegisterPersonService,private router: Router) { }

  ngOnInit(): void {
   
  }

  public registePerson() {
    if (!this.isValidInput()) return;
    this.registerPersonService.registerPerson(this.person).subscribe(res => {
      this.router.navigate(['/home']);
    });
  }

  private isValidInput(): boolean {
    return this.person?.dateOfBirth.toString() != ''  && this.person?.bloodType != '' && this.person?.surname != '';
  }

}
