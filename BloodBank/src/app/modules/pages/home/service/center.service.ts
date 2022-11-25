import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CenterDTO } from 'src/app/modules/hospital/model/centerDTO';

@Injectable({
  providedIn: 'root'
})
export class CenterService {
  
  apiHost: string = 'http://localhost:8080/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getAll(): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>(this.apiHost + 'api/centers', {headers: this.headers});
  }

  getCentersbyPage(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>(this.apiHost + 'api/centers/' + id, {headers: this.headers});
  }

  getCentersSortedbyName(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>(this.apiHost + 'api/centers/name/' + id, {headers: this.headers});
  }


  getCentersSortedbyNameDes(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>(this.apiHost + 'api/centers/nameDes/' + id, {headers: this.headers});
  }

  getCentersSortedbyCity(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>(this.apiHost + 'api/centers/city/' + id, {headers: this.headers});
  }

  getCentersSortedbyCityDes(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>(this.apiHost + 'api/centers/cityDes/' + id, {headers: this.headers});
  }


  getCentersSortedbyAverageRating(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>(this.apiHost + 'api/centers/averageRating/' + id, {headers: this.headers});
  }

  getCentersSortedbyAverageRatingDes(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>(this.apiHost + 'api/centers/averageRatingDes/' + id, {headers: this.headers});
  }

  getAllbyNameCity(ime: string, mesto: string, page: number): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>('api/centers/' + ime + '/' + mesto + '/' + page, {headers: this.headers});
  }

  getAllbyStreet(street: string, page: number): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>('api/centers/'+ street +'/' + page, {headers: this.headers});
  }

}
