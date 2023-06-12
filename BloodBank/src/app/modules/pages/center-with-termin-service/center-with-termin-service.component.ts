import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-center-with-termin-service',
  templateUrl: './center-with-termin-service.component.html',
  styleUrls: ['./center-with-termin-service.component.css']
})
export class CenterWithTerminServiceComponent {

  private centerWithTermin: any;

  constructor() { }

  setCenterWithTermin(centerWithTermin: any): void {
    this.centerWithTermin = centerWithTermin;
  }

  getCenterWithTermin(): any {
    return this.centerWithTermin;
  }

}
