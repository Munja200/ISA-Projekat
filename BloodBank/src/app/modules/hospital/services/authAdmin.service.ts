import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class AuthAdminService {
  isAuthenticated(): boolean{
    let userRole = localStorage.getItem('userRoles');
    let userRoles = userRole?.split(' ');
    if(userRoles)
      for(let i = 0; i < userRoles?.length; i ++){
        if(userRoles[i] == 'ROLE_ADMIN'){
          return true;
        } 
      }
    return false;
  }
}
