import { ComplaintDTO } from './../model/complaintDTO';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegisterComplaintService {
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }
  
  getAllByPageToAnswer(pageID: number){
    return this.http.get<any>('api/complaint/allByPageToAnswer/' + pageID, { headers: this.headers });
  }

  postAnswer(complaintDTO: ComplaintDTO){
    return this.http.post<ComplaintDTO>('api/complaint/answer', complaintDTO, {headers: this.headers}); 
  }

}