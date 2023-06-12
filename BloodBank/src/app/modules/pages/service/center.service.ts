import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CenterDTO } from 'src/app/modules/hospital/model/centerDTO';
import { Center } from '../../hospital/model/center';
import { CenterWithTerminDTO } from '../../hospital/model/centerWithTerminDTO';

@Injectable({
  providedIn: 'root'
})
export class CenterService {
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getAll(): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>('api/centers', {headers: this.headers});
  }

  getCentersbyPage(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>('api/centers/' + id, {headers: this.headers});
  }

  getCentersSortedbyName(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>('api/centers/name/' + id, {headers: this.headers});
  }


  getCentersSortedbyNameDes(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>('api/centers/nameDes/' + id, {headers: this.headers});
  }

  getCentersSortedbyCity(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>('api/centers/city/' + id, {headers: this.headers});
  }

  getCentersSortedbyCityDes(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>('api/centers/cityDes/' + id, {headers: this.headers});
  }


  getCentersSortedbyAverageRating(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>('api/centers/averageRating/' + id, {headers: this.headers});
  }

  getCentersSortedbyAverageRatingDes(id: number): Observable<any> {
    return this.http.get<CenterDTO[]>('api/centers/averageRatingDes/' + id, {headers: this.headers});
  }

  getAllbyNameCity(ime: string, mesto: string, page: number): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>('api/centers/' + ime + '/' + mesto + '/' + page, {headers: this.headers});
  }

  getAllbyStreet(street: string, page: number): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>('api/centers/'+ street +'/' + page, {headers: this.headers});
  }

  getAllForAdminCenter(adminId : number) : Observable<CenterDTO> {
    return this.http.get<CenterDTO>('api/centers/allForAdminCenter/' + adminId, {headers: this.headers});
  }

  getById(id: number): Observable<Center> {
    return this.http.get<Center>('api/centers/cntr/' + id, {headers: this.headers});
  }

  /*
  getCentersbyDateWithFreeAppointments(datum: Date): Observable<any> {
    return this.http.get<CenterDTO[]>('api/centers/slobodniCentri/' + datum, {headers: this.headers});
  }
  */
  
  getCentersbyDateWithFreeAppointments(datum: Date): Observable<any> {
    return this.http.get<CenterWithTerminDTO[]>('api/centers/slobodniCentri/' + datum, {headers: this.headers});
  }
  
  updateCenter(centerDto: CenterDTO){
    return this.http.post<any>('api/centers/update/' + centerDto.id, centerDto, {headers: this.headers});
  }

}
