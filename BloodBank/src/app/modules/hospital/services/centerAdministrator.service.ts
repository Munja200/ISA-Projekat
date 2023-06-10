import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CenterAdministratorDTO } from '../model/centerAdministratorDTO';
import { CenterDTO } from '../model/centerDTO';

@Injectable({
  providedIn: 'root'
})
export class CenterAdministratorService {
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  registerCenterAdministrator(administratorCenterDTO: CenterAdministratorDTO): Observable<any> {
    return this.http.post<any>('api/administratorCenters/add', administratorCenterDTO, {headers: this.headers});
  }

  getCenterIdByAdminCenterId(centerId: number): Observable<any> {
    return this.http.get<number>('api/administratorCenters/centar/' + centerId, {headers: this.headers});
  }
  
}
