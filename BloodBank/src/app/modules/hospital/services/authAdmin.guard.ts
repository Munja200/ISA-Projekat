import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { AuthAdminService } from './authAdmin.service';

@Injectable({
  providedIn: 'root'
})
export class AuthAdminGuard implements CanActivate {
  
  constructor(private authAdminService: AuthAdminService, private router: Router) { } 

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    if(this.authAdminService.isAuthenticated()){
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }

}
