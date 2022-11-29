import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CenterAdministratorDTO } from '../model/centerAdministratorDTO';

@Injectable({
  providedIn: 'root'
})
export class CenterAdministratorService {
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  registerCenterAdministrator(administratorCenterDTO: CenterAdministratorDTO): Observable<any> {
    return this.http.post<any>('api/administratorCenters/add', administratorCenterDTO, {headers: this.headers});
  }
  
}
