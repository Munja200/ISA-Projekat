import { Component, OnInit } from '@angular/core';
import { CheckboxRequiredValidator } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisteredPersonDTO } from '../model/registeredPersonDTO';
import { RegisterPersonService } from '../services/register-person.service';

@Component({
  selector: 'app-search-RegisteredPersons',
  templateUrl: './search-RegisteredPersons.component.html',
  styleUrls: ['./search-RegisteredPersons.component.css']
})
export class SearchRegisteredPersons implements OnInit {

  public registeredPersons: RegisteredPersonDTO[] = [];

  public name: string = '';
  public surname: string = '';
  public currentPageID: number = 0;
  public nameSearch: string = 'none';
  public surnameSearch: string = 'none';
  public pageID: number = 0;

  constructor(private registerPersonService : RegisterPersonService, private router: Router) { }

  ngOnInit(): void {
    this.registerPersonService.getAllByNameSurname(this.nameSearch, this.surnameSearch, this.pageID).subscribe(res => {
      this.registeredPersons = res;
    })
  }
  
  backToHomePage(){
    this.router.navigate(['/home']);
  }

  search(){
    this.chechValid()
    this.registerPersonService.getAllByNameSurname(this.nameSearch, this.surnameSearch, this.currentPageID).subscribe(res => {
      this.registeredPersons = res;
    })
  }

  previous(){
    this.pageID -= 1;
    this.chechValid()
    this.registerPersonService.getAllByNameSurname(this.nameSearch, this.surnameSearch, this.currentPageID).subscribe(res => {
      this.registeredPersons = res;
    })
  }

  next(){
    this.pageID += 1;
    this.chechValid()
    this.registerPersonService.getAllByNameSurname(this.nameSearch, this.surnameSearch, this.currentPageID).subscribe(res => {
      this.registeredPersons = res;
    })
  }

  chechValid(){
    if(this.pageID == null || this.pageID <= 0) this.pageID = 0
    this.currentPageID = this.pageID;

    if(this.name == null || this.name == '') this.nameSearch = 'none'
    else this.nameSearch = this.name;

    if(this.surname == null || this.surname == '') this.surnameSearch = 'none'
    else this.surnameSearch = this.surname;
  }
}

