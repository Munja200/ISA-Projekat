import { Component, OnInit } from '@angular/core';
import { BloodDTO } from '../../hospital/model/blood';
import { BloodService } from '../../hospital/services/blood.service';
import { Router } from '@angular/router';
import { AuthService } from '../../hospital/services/auth.service';

@Component({
  selector: 'app-blood-view',
  templateUrl: './blood-view.component.html',
  styleUrls: ['./blood-view.component.css']
})
export class BloodViewComponent implements OnInit {

  public bloods : BloodDTO[] = [];

  constructor(private authService: AuthService,private bloodService: BloodService, private router: Router) { }

  ngOnInit(): void {
    this.bloodService.getAllBloodForCenter(1).subscribe(res => {
      this.bloods = res;
  });

  }

  logout(){
    this.authService.logout()
  }
}
