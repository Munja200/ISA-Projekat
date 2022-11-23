import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CenterDTO } from '../model/centerDTO';

@Injectable({
  providedIn: 'root'
})
export class CenterService {
  apiHost: string = 'http://localhost:8080/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  registerCenter(center: any): Observable<any> {
    return this.http.post<any>(this.apiHost + 'api/centers/add', center, {headers: this.headers});
  }

  getAllForAdministratorRegistration(): Observable<CenterDTO[]> {
    return this.http.get<CenterDTO[]>(this.apiHost + 'api/centers/allForAdministratorRegistration', {headers: this.headers});
  }
  
}
