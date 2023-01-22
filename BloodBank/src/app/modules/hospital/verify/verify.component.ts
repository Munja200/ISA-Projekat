import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { RegisterPersonService } from '../services/register-person.service';

@Component({
  selector: 'app-verify',
  templateUrl: './verify.component.html',
  styleUrls: ['./verify.component.css']
})
export class VerifyComponent implements OnInit {

  constructor(
    private service: RegisterPersonService ,private route: ActivatedRoute,private router: Router,) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.service.verify(params['id']).subscribe(res => {
        console.log(params['id'])
        this.router.navigate(['/login']);
   
      })
    });
  }

}
