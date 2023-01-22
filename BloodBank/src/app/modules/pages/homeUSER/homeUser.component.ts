import { AuthService } from './../../hospital/services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from '../../hospital/model/address';
import { CenterDTO } from '../../hospital/model/centerDTO';
import { CenterService } from '../service/center.service';

@Component({
  selector: 'app-homeUser',
  templateUrl: './homeUser.component.html',
  styleUrls: ['./homeUser.component.css']
})
export class HomeUserComponent implements OnInit {
  public centers: CenterDTO[] = [];

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

  constructor(private centerService: CenterService, private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
    this.averageSort = false;
    this.nameSort = false;
    this.citySort = false;
    this.centerService.getCentersbyPage(this.page).subscribe(res => {
      this.centers = res;
    })
  }

  logout(){
    this.authService.logout()
  }

  public Appointments(id: any){
    localStorage.setItem('centar_id', id);
    this.router.navigate(['/centerAppointments']);
  }

  public nextButton(){
    if(this.centers.length >= 10 ){
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
          this.centers = res;
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
          this.centers = res;
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
          this.centers = res;
        })
    
        this.sort = true;
      }else{
        this.centerService.getCentersSortedbyNameDes(this.page).subscribe(res => {
          this.centers = res;
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
        this.centers = res;
      })

      this.sort = true;
    }else{
      this.centerService.getCentersSortedbyCityDes(this.page).subscribe(res => {
        this.centers = res;
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
        this.centers = res;
      })

      this.sort = true;
    }else{
      this.centerService.getCentersSortedbyAverageRatingDes(this.page).subscribe(res => {
        this.centers = res;
      })

      this.sort = false;
    }
  }

  public reset(){
    this.averageSort = false;
    this.nameSort = false;
    this.citySort = false;
    this.centerService.getCentersbyPage(this.page).subscribe(res => {
      this.centers = res;
    })
  }

  public searchCenterByNameAndCity() {
    this.page = 0;
    this.centerService.getAllbyNameCity(this.ime, this.mesto, this.page).subscribe(res => {
      this.centers = res;
      this.searchs = this.centers;
    })
  }

  public filterCenterByStreet() {
    this.page = 0;
    this.centerService.getAllbyStreet(this.street, this.page).subscribe(res => {
      //ovde kako uzeti samo one iz pretrageeeeee MAGIJAAAAAAAAA by: Galic :D
      this.searchs = res;
    })
  }
}
