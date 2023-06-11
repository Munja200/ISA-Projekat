import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../hospital/services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { Person } from '../../hospital/model/person';
import { Role } from '../../hospital/model/role';



@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  
  password: string = '';

  form!: FormGroup;

  personId : number = 0;
  currentPerson : Person = new Person();

  osoba: Person = new Person();


  constructor(
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private registerPersonService : RegisterPersonService
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      password: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])]
    });
  }

  onSubmit() {
    const username = this.authService.getCurrentUserUsername();
    if (username) {
      this.registerPersonService.getUserByUsername(username).subscribe(person => {
        this.personId = person.id;
        console.log(this.personId);
  
        this.currentPerson = person;        
        this.currentPerson.password = this.form.value.password; 
  
        this.currentPerson.firstLogin = false;
        console.log(this.currentPerson);
  
        this.registerPersonService.updateRegisteredPerson(this.currentPerson).subscribe(updatedPerson => {
          //updatedPerson.roles = "ROLE_ADMIN_CENTER"
          this.router.navigate(['/homeAdminCenter']);
        });
      });
    }
  }
  

}