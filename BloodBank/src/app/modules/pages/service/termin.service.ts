import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Termin } from '../../hospital/model/termin';
import { TerminDTO } from '../../hospital/model/terminDTO';

@Injectable({
  providedIn: 'root'
})
export class TerminService {

  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getTerminiByCenterId(id: number): Observable<any> {
    return this.http.get<TerminDTO[]>('api/termini/' + id, {headers: this.headers});
  }

}
