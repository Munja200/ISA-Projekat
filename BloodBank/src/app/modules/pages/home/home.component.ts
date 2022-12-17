import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Address } from '../../hospital/model/address';
import { CenterDTO } from '../../hospital/model/centerDTO';
import { CenterService } from '../service/center.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public displayedColumns = ['name', 'city', 'average_rating' ,'description'];
  public rooms: CenterDTO[] = [];
  public dataSource = new MatTableDataSource<CenterDTO>();
  public sort : boolean = false;
  public page: number = 0;
  public averageSort: boolean = false;
  public nameSort: boolean = false;
  public citySort: boolean = false;

  public address: Address = new Address(0, false, 0, 0, '', '', '', '');
  public centerDTO: CenterDTO = new CenterDTO(0,'', this.address, '', 0, false);

  public ime: string = 'none';
  public mesto: string = 'none';
  public average: number = 0;
  public street: string = 'none';
  public searchs: CenterDTO[] = [];

  constructor(private centerService: CenterService, private router: Router) { }
  ngOnInit(): void {
    this.averageSort = false;
    this.nameSort = false;
    this.citySort = false;
    this.centerService.getCentersbyPage(this.page).subscribe(res => {
      this.rooms = res;
      this.dataSource.data = this.rooms;
    })
  }

  public registePerson() {
    
    this.router.navigate(['/register']);
  
  }

  public questionForms() {
      
    this.router.navigate(['/questionForm']);

  }

  public registerCenter(){
    this.router.navigate(['/registerCenter']);
  }

  public registerCenterAdministrator(){
    this.router.navigate(['/registerCenterAdministrator']);
  }

  public profileRegisteredUser(){
    this.router.navigate(['/profilOfRegisteredUser']);
  }

  public registeredPersons(){
    this.router.navigate(['/registeredPersons']);
  }

  public answerComplaints(){
    this.router.navigate(['/complaints']);
  }

  public nextButton(){
    if(this.rooms.length >= 10 ){
      this.page =this.page + 1;
    
      if(this.averageSort == true){
        this.sort = (!this.sort);

        this.sortByAverageRating();
      }else if(this.nameSort == true){
        this.sort = (!this.sort);

        this.sortByName();
      }else if(this.citySort == true){
        this.sort = (!this.sort);

        this.sortByCity();
      }else{
        this.centerService.getCentersbyPage(this.page).subscribe(res => {
          this.rooms = res;
          this.dataSource.data = this.rooms;
        })
      }
    }
  }

  public previousButton(){
    if(this.page - 1 >=0 ){
      this.page =this.page - 1;
      if(this.averageSort == true){
        this.sort = (!this.sort)

        this.sortByAverageRating();
      }else if(this.nameSort == true){
        this.sort = (!this.sort)

        this.sortByName();
      }else if(this.citySort == true){
        this.sort = (!this.sort)

        this.sortByCity();
      }else{
        this.centerService.getCentersbyPage(this.page).subscribe(res => {
          this.rooms = res;
          this.dataSource.data = this.rooms;
        })
      }
    }
  }

  public sortByName() {
      this.averageSort = false;
      this.nameSort = true;
      this.citySort = false;

      if(this.sort == false){
        this.centerService.getCentersSortedbyName(this.page).subscribe(res => {
          this.rooms = res;
          this.dataSource.data = this.rooms;
        })
    
        this.sort = true;
      }else{
        this.centerService.getCentersSortedbyNameDes(this.page).subscribe(res => {
          this.rooms = res;
          this.dataSource.data = this.rooms;
        })
    
        this.sort = false;
      }
    
  }


  public sortByCity() {
    this.averageSort = false;
    this.nameSort = false;
    this.citySort = true;
    
    if(this.sort == false){
      this.centerService.getCentersSortedbyCity(this.page).subscribe(res => {
        this.rooms = res;
        this.dataSource.data = this.rooms;
      })

      this.sort = true;
    }else{
      this.centerService.getCentersSortedbyCityDes(this.page).subscribe(res => {
        this.rooms = res;
        this.dataSource.data = this.rooms;
      })

      this.sort = false;
    }   
    
  }

  public sortByAverageRating() {
    this.averageSort = true;
    this.nameSort = false;
    this.citySort = false;

    if(this.sort == false){
      this.centerService.getCentersSortedbyAverageRating(this.page).subscribe(res => {
        this.rooms = res;
        this.dataSource.data = this.rooms;
      })

      this.sort = true;
    }else{
      this.centerService.getCentersSortedbyAverageRatingDes(this.page).subscribe(res => {
        this.rooms = res;
        this.dataSource.data = this.rooms;
      })

      this.sort = false;
    }
  }

  public reset(){
    this.averageSort = false;
    this.nameSort = false;
    this.citySort = false;
    this.centerService.getCentersbyPage(this.page).subscribe(res => {
      this.rooms = res;
      this.dataSource.data = this.rooms;
    })
  }

  public searchCenterByNameAndCity() {
    this.page = 0;
    this.centerService.getAllbyNameCity(this.ime, this.mesto, this.page).subscribe(res => {
      this.rooms = res;
      this.searchs = this.rooms;
      this.dataSource.data = this.rooms;
    })
  }

  public filterCenterByStreet() {
    this.page = 0;
    this.centerService.getAllbyStreet(this.street, this.page).subscribe(res => {
      //ovde kako uzeti samo one iz pretrageeeeee MAGIJAAAAAAAAA by: Galic :D
      this.searchs = res;
      this.dataSource.data = this.searchs;
    })
  }


}
