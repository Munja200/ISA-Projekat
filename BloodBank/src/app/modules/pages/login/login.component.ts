import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Subject} from 'rxjs';
import {takeUntil} from 'rxjs/operators';
import { AuthService } from '../../hospital/services/auth.service';

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
    private formBuilder: FormBuilder
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
    /**
     * Innocent until proven guilty
     */
    
    this.notification;
    this.submitted = true;

    this.authService.login(this.form.value)
      .subscribe(data => {
        console.log(data);
          let userRole = localStorage.getItem('userRoles');
          let userRoles = userRole?.split(' ');
          let isAdmin = false;
          let isUser = false;
          let isCenterAdmin = false;
          if(userRoles)
            for(let i = 0; i < userRoles?.length; i ++){
              if(userRoles[i] == 'ROLE_ADMIN'){
                isAdmin = true;
                break;
              }
            }
          if(userRoles)
            for(let i = 0; i < userRoles?.length; i ++){
              if(userRoles[i] == 'ROLE_CENTER_ADMIN'){
                isCenterAdmin = true;
                break;
              }
            }
          if(userRoles)
            for(let i = 0; i < userRoles?.length; i ++){
              if(userRoles[i] == 'ROLE_USER'){
                isUser = true;
                break;
              } 
            }
          
          if(isUser){
            if(isAdmin) this.router.navigate(['/homeAdmin'])
            else if(isCenterAdmin) this.router.navigate(['/homeCenterAdmin'])
            else this.router.navigate(['/home'])
          }
        },
        error => {
          console.log(error);
          this.submitted = false;
          this.notification = {msgType: 'error', msgBody: 'Incorrect username or password.'};
        });
  }

}
