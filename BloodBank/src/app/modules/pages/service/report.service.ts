import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Report } from '../../hospital/model/report';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  saveReport(report: any): Observable<any> {
    return this.http.post<any>('api/reports/add', report, {headers: this.headers});
  }
  
}
