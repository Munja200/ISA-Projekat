import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { AuthCenterAdminService } from './authCenterAdmin.service';

@Injectable({
  providedIn: 'root'
})
export class AuthCenterAdminGuard implements CanActivate {
  
  constructor(private authCenterAdminService: AuthCenterAdminService, private router: Router) { } 

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    if(this.authCenterAdminService.isAuthenticated()){
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }

}
