import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../hospital/services/auth.service';

@Component({
  selector: 'app-homeAdmin',
  templateUrl: './homeCenterAdmin.component.html',
  styleUrls: ['./homeCenterAdmin.component.css']
})
export class HomeCenterAdminComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit(): void {

  }

  logout(){
    this.authService.logout()
  }

}
