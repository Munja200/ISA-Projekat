import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { AuthUserService } from './authUser.service';

@Injectable({
  providedIn: 'root'
})
export class AuthUserGuard implements CanActivate {
  
  constructor(private authUserService: AuthUserService, private router: Router) { } 

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    if(this.authUserService.isAuthenticated()){
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }

}
