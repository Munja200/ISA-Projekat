import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../hospital/services/auth.service';
import { RegisteredPersonDTO } from '../../hospital/model/registeredPersonDTO';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { CenterService } from '../service/center.service';
import { CenterDTO } from '../../hospital/model/centerDTO';

@Component({
  selector: 'app-home-admincenter',
  templateUrl: './home-admincenter.component.html',
  styleUrls: ['./home-admincenter.component.css']
})
export class HomeADMINCENTERComponent implements OnInit {
  public rUsers : RegisteredPersonDTO[] = [];

  
  sortColumn: string = '';
  sortDirection: string = 'asc';
  centerId : number = 0;
  personId : number = 0;

  CenterDto = new CenterDTO();

  constructor(private router: Router, private centerService: CenterService, private authService: AuthService, private registerPersonService : RegisterPersonService) { }

  ngOnInit(): void {
    const username = this.authService.getCurrentUserUsername();
    if (username) {
      this.registerPersonService.getUserByUsername(username).subscribe(person => {
        this.personId = person.id;
        console.log(this.personId);
  
        
        this.centerService.getAllForAdminCenter(this.personId).subscribe(centar => {
          this.CenterDto = centar;
          console.log(centar);
          this.centerId = centar.id;
  
          this.registerPersonService.getRegisteredUsersByCenterAndPersonId(this.centerId, this.personId).subscribe(res => {
            this.rUsers = res;
          });
        });
      });
    }
  }
  
  logout(){
    this.authService.logout()
  }

  
sortByName() {
  this.sortColumn = 'name';
  this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
  this.sortData();
}

sortBySurname() {
  this.sortColumn = 'surname';
  this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
  this.sortData();
}

sortByDate() {
  this.sortColumn = 'dateOfBirth';
  this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
  this.sortData();
}

sortByBloodType() {
  this.sortColumn = 'bloodType';
  this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
  this.sortData();
}

sortData() {
    this.rUsers.sort((a, b) => {
      const valA = this.getValue(a, this.sortColumn);
      const valB = this.getValue(b, this.sortColumn);
  
      if (typeof valA === 'string' && typeof valB === 'string') {
        return this.sortDirection === 'asc' ? valA.localeCompare(valB) : valB.localeCompare(valA);
      } else if (valA instanceof Date && valB instanceof Date) {
        return this.sortDirection === 'asc' ? valA.getTime() - valB.getTime() : valB.getTime() - valA.getTime();
      }
  
      return 0;
    });
}
  

getValue(item: any, column: string) {
  switch (column) {
    case 'name':
      return item.person.name;
    case 'surname':
      return item.person.surname;
      case 'dateOfBirth':
        return new Date(item.person.dateOfBirth);
      case 'bloodType':
      return item.person.bloodType;
    default:
      return '';
  }
}

}
