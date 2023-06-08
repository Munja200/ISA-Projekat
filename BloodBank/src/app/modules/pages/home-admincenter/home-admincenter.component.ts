import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../hospital/services/auth.service';

@Component({
  selector: 'app-home-admincenter',
  templateUrl: './home-admincenter.component.html',
  styleUrls: ['./home-admincenter.component.css']
})
export class HomeADMINCENTERComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
  }

  logout(){
    this.authService.logout()
  }

}
