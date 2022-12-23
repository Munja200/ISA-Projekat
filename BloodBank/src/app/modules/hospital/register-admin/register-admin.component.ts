import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminDTO } from '../model/adminDTO';
import { RegisterPersonService } from '../services/register-person.service';

@Component({
  selector: 'app-register-admin',
  templateUrl: './register-admin.component.html',
  styleUrls: ['./register-admin.component.css']
})
export class RegisterAdminComponent implements OnInit {
  public genders: String[] = ['Male','Female'];
  public bloodTypes: String[] = ['O-','O+','A-','A+','B-','B+','AB-','AB+']
  public password: String = "";
  public admin: AdminDTO = new AdminDTO();

  constructor(private router: Router, private registerPersonService: RegisterPersonService) { }

  ngOnInit(): void {

  }

  registeAdmin() {
    this.registerPersonService.registerAdmin(this.admin).subscribe(res => {
      console.log(res);
    });
  }

  consoleLog(){
    console.log(this.admin)
  }
}
