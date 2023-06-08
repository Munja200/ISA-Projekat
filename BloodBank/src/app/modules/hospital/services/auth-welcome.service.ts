import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
}) 
export class AuthWelcomeService implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): boolean {
    if (this.authService.isLoggedIn()) {
      return true; 
    } else {
      this.router.navigate(['']); // ide na WelcomeComponent ako nije logovan
      return false;
    }
  }
  }