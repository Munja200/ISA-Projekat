import { Component, OnInit } from '@angular/core';
import { Person } from '../model/person';
import { RegisterPersonService } from '../services/register-person.service';


@Component({
  selector: 'app-register-person',
  templateUrl: './register-person.component.html',
  styleUrls: ['./register-person.component.css']
})
export class RegisterPersonComponent implements OnInit {
  public person: Person = new Person();
  private password:String= this.person.password;

  constructor(private registerPersonService: RegisterPersonService) { }

  ngOnInit(): void {
  }

  public registePerson() {
    if (!this.isValidInput()) return;
    this.registerPersonService.registerPerson(this.person).subscribe(res => {
    
    });
  }

  private isValidInput(): boolean {
    return this.person?.dateOfBirth.toString() != ''  && this.person?.bloodType != '' && this.person?.surname != '';
  }

}
