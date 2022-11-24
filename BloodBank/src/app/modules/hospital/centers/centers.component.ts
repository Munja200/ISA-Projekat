import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { CenterDTO } from '../model/centerDTO';

@Component({
  selector: 'app-centers',
  templateUrl: './centers.component.html',
  styleUrls: ['./centers.component.css']
})
export class Centers implements OnInit {

  public centersForm: FormGroup | any;
  public centers: CenterDTO = new CenterDTO();


  constructor(private router: Router, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.centersForm = this.fb.group({
      centers: [this.centers]
    });
  }

}
