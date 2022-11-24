import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CenterDTO } from '../model/centerDTO';

@Injectable({
  providedIn: 'root'
})
export class CenterService {
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  registerCenter(center: any): Observable<any> {
    return this.http.post<any>('api/centers/add', center, {headers: this.headers});
  }

  getAllForAdministratorRegistration(): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>('api/centers/allForAdministratorRegistration', {headers: this.headers});
  }
  
  getAllCentersSortedDescByName(page: number): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>('api/centers/nameDes/' + page, {headers: this.headers});
  }

  getAllCentersSortedByName(page: number): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>('api/centers/name/' + page, {headers: this.headers});
  } 

  getAllCentersSortedDescByCity(page: number): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>('api/centers/cityDes/' + page, {headers: this.headers});
  }

  getAllCentersSortedByCity(page: number): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>('api/centers/city/' + page, {headers: this.headers});
  } 

  getAllCentersSortedDescByAverageRating(page: number): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>('api/centers/averageRatingDes/' + page, {headers: this.headers});
  }

  getAllCentersSortedByAverageRating(page: number): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>('api/centers/averageRating/' + page, {headers: this.headers});
  } 
}
