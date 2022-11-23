import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from '../model/address';
import { CenterDTO } from '../model/centerDTO';
import { CenterService } from '../services/center.service';

@Component({
  selector: 'app-register-center',
  templateUrl: './register-center.component.html',
  styleUrls: ['./register-center.component.css']
})
export class RegisterCenterComponent implements OnInit {
  public address: Address = new Address();
  public center: CenterDTO = new CenterDTO(0, '', this.address, '', 0, false);

  constructor(private centerService: CenterService, private router: Router) { }

  ngOnInit(): void {

  }

  registeCenter(): void {
    this.centerService.registerCenter(this.center).subscribe(res => {
      console.log("Radi")
    });
  }
}
