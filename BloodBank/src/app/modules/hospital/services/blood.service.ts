import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BloodDTO } from '../model/blood';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BloodService {

  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getAllBloodForCenter(centerId: number): Observable<BloodDTO[]> {
    return this.http.get<BloodDTO[]>('api/bloods/allBloodCenter/' + centerId, {headers: this.headers});
  }

}
