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
}
