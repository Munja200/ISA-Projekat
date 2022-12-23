import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppointmentDTO } from '../model/appointmentDto';
import { CenterDTO } from '../model/centerDTO';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

 
  getAllFreeCentersAppointment(page: number, id_centra: number): Observable<any> {
    return this.http.get<AppointmentDTO[]>('api/appointment/free/' + page+'/'+ id_centra, {headers: this.headers});
  }

  getAllFreeCentersAppointmentSorted(page: number, id_centra: number): Observable<any> {
    return this.http.get<AppointmentDTO[]>('api/appointment/free/sort/' + page+'/'+ id_centra, {headers: this.headers});
  }

  getAllFreeCentersAppointmentSortedDesc(page: number, id_centra: number): Observable<any> {
    return this.http.get<AppointmentDTO[]>('api/appointment/free/sortDesc/' + page+'/'+ id_centra, {headers: this.headers});
  }

  setFreebyUser(id_appointment: number, id_centra: string): Observable<any> {
    return this.http.get<AppointmentDTO[]>('api/appointment/setAppointmentUser/' + id_appointment +'/'+ id_centra, {headers: this.headers});
  }

  setAppointmentFree(id_appointment: number): Observable<any> {
    return this.http.get<AppointmentDTO[]>('api/appointment/setFree/' + id_appointment , {headers: this.headers});
  }
  
  getUserAppointment(page: number, username : string): Observable<any> {
    return this.http.get<AppointmentDTO[]>('api/appointment/featureAppointment/' + page+'/'+ username , {headers: this.headers});
  }

  
  getUserAppointmentSorted(page: number, username : string): Observable<any> {
    return this.http.get<AppointmentDTO[]>('api/appointment/featureAppointmentSorted/' + page+'/'+ username , {headers: this.headers});
  }

}
