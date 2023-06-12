import { Component, OnInit } from '@angular/core';
import { CenterDTO } from '../../hospital/model/centerDTO';
import { Address } from '../../hospital/model/address';
import { Router } from '@angular/router';
import { AuthService } from '../../hospital/services/auth.service';
import { CenterService } from '../service/center.service';

@Component({
  selector: 'app-grade',
  templateUrl: './grade.component.html',
  styleUrls: ['./grade.component.css']
})
export class GradeComponent implements OnInit {
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

  public Rate(id: any){
    localStorage.setItem('centar_id', id);
    this.router.navigate(['/rate']);
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
}

