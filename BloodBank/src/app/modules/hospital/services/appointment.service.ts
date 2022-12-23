import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppointmentDTO } from '../model/appointmentDTO';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getAllCentersByAdministratorCenterUsername(username: string): Observable<AppointmentDTO[]> {
    return this.http.get<AppointmentDTO[]>('api/appointment/center/' + username, {headers: this.headers});
  }

}