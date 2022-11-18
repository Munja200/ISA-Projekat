import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { CenterDTO } from '../../hospital/model/centerDTO';
import { CenterService } from './service/center.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public displayedColumns = ['name', 'city', 'average_rating' ,'description'];
  public rooms: CenterDTO[] = [];
  public dataSource = new MatTableDataSource<CenterDTO>();
  constructor(private centerService: CenterService,private router: Router) { }

  ngOnInit(): void {
    this.centerService.getAll().subscribe(res => {
      this.rooms = res;
      console.log(res[0].averageRating);
      this.dataSource.data = this.rooms;
    })
  }

  public registePerson() {
    
    this.router.navigate(['/register']);
  
}

public questionForms() {
    
  this.router.navigate(['/questionForm']);

}


}
