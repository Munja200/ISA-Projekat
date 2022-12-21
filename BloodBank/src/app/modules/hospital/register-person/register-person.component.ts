import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Address } from '../model/address';
import { Person } from '../model/person';
import { AuthService } from '../services/auth.service';
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

  constructor(private registerPersonService: RegisterPersonService,private router: Router,
    private authService: AuthService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {
   
  }

  public registePerson() {
    if (!this.isValidInput()) return;
   // this.registerPersonService.registerPerson(this.person).subscribe(res => {
    //  this.router.navigate(['/home']);
      
   // });
console.log(this.person)
    this.authService.signup(this.person)
    .subscribe(data => {
      console.log(data);
      this.authService.login(this.person).subscribe(() => {
      });
      this.router.navigate(['/home']);
    },
      error => {
        console.log('Sign up error');
      });

  }

  private isValidInput(): boolean {
    return this.person?.dateOfBirth.toString() != ''  && this.person?.bloodType != '' && this.person?.surname != '';
  }

}
