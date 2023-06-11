import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Subject} from 'rxjs';
import {takeUntil} from 'rxjs/operators';
import { AuthService } from '../../hospital/services/auth.service';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { Person } from '../../hospital/model/person';

interface DisplayMessage {
  msgType: string;
  msgBody: string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  title = 'Login';
  form!: FormGroup;

  personId : number = 0;
  currentPerson: Person = new Person();

  /**
   * Boolean used in telling the UI
   * that the form has been submitted
   * and is awaiting a response
   */
  submitted = false;

   /**
   * Notification message from received
   * form request or router
   */
    notification!: DisplayMessage;

    returnUrl!: string;
    private ngUnsubscribe: Subject<void> = new Subject<void>();
  


  constructor(
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private registerPersonService : RegisterPersonService
  ) { }

  ngOnInit() {
    this.route.params
      .pipe(takeUntil(this.ngUnsubscribe))
      .subscribe((params: any) => {
        this.notification = params as DisplayMessage;
      });
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    this.form = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])],
      password: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])]
    });
  }

  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  onSubmit() {   
    
    this.notification;
    this.submitted = true;

        this.authService.login(this.form.value)
        .subscribe(data => {
          console.log(data);
          let userRoles = localStorage.getItem('userRoles');
          let isAdmin = false;
          let isAdminCenter = false;
      
          if (userRoles) {
            let roles = userRoles.split(' ');
      
            for (let i = 0; i < roles.length; i++) {
              if (roles[i] === 'ROLE_ADMIN') {
                isAdmin = true;
                break;
              } else if (roles[i] === 'ROLE_ADMIN_CENTER') {
                isAdminCenter = true;
                break;
              }
            }
          }
      
          if (isAdmin) {
            this.router.navigate(['/homeAdmin']);
          } else if (isAdminCenter) {
            const username = this.authService.getCurrentUserUsername();
      if (username) {
        this.registerPersonService.getUserByUsername(username).subscribe(person => {
        this.personId = person.id;
        console.log(this.personId);

       this.currentPerson = person;

        if(this.currentPerson.firstLogin){
          console.log(this.currentPerson);
          this.router.navigate(['/changePassword']);

        }else{
        this.router.navigate(['/homeAdminCenter']);
        }
      });
    }
          } else {
            this.router.navigate(['/home']);
          }
        },
        error => {
          console.log(error);
          this.submitted = false;
          this.notification = { msgType: 'error', msgBody: 'Incorrect username or password.' };
        });
      
  }

}
