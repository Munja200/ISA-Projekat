import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { ApiService } from './api.service';
import { catchError, map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { of } from 'rxjs/internal/observable/of';
import { Observable } from 'rxjs';
import { RegisterPersonService } from './register-person.service';

@Injectable()
export class AuthService {

  constructor(
    private apiService: ApiService,
    private person: RegisterPersonService,
    private router: Router
  ) {
  }
  apiHost: string = 'http://localhost:8080/';

  private _api_url = 'http://localhost:8082/api';

  private access_token = null;

  login(user:any) {
    const loginHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    });
    // const body = `username=${user.username}&password=${user.password}`;
    const body = {
      'username': user.username,
      'password': user.password
    };
    

    
    return this.apiService.post(this.apiHost + 'auth/login', JSON.stringify(body), loginHeaders)
      .pipe(map((res) => {
        console.log('Login success');
        this.access_token = res.body.accessToken;
        localStorage.setItem("jwt", res.body.accessToken)
      }));
      
  }

  
  signup(user:any) {
    const signupHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    });
    return this.apiService.post(this.apiHost + 'auth/signup', JSON.stringify(user), signupHeaders)
      .pipe(map(() => {
        console.log('Sign up success');
      }));
  }

  logout() {
    //this.userService.currentUser = null;
    localStorage.removeItem("jwt");
    this.access_token = null;
    this.router.navigate(['/login']);
  }

  tokenIsPresent() {
    return this.access_token != undefined && this.access_token != null;
  }

  getToken() {
    return this.access_token;
  }

}
