import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BloodDTO } from '../model/bloodDto';
import { Observable } from 'rxjs';
import { Blood } from '../model/blood';

@Injectable({
  providedIn: 'root'
})
export class BloodService {

  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getAllBloodForCenter(centerId: number): Observable<BloodDTO[]> {
    return this.http.get<BloodDTO[]>('api/bloods/allBloodCenter/' + centerId, {headers: this.headers});
  }

  changeBlood(centerId: number, quantity: number, bloodType: string) : Observable<Blood> {
    return this.http.post<Blood>('api/bloods/changeBlood/' + centerId + '/' + quantity + '/' + bloodType, {headers: this.headers});
  }

}
