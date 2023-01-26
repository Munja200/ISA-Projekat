import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MapsService {

  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'text/plain' });

  constructor(private http: HttpClient) { }

 
  generateCords(message: string): Observable<any> {
    return this.http.post<any>('api/isa/myexchange/endcord', message, {headers: this.headers});
  }
}
