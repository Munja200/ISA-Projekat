import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Grade } from '../model/grade';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GradeService {


    headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  
    constructor(private http: HttpClient) { }
  
    createGrade(grade: any): Observable<any> {
      return this.http.post<any>('api/grades/add/', grade, {headers: this.headers});
    }

    updateGrade(grade: Grade){
      return this.http.post<any>('api/grades/update/' + grade.id, grade, {headers: this.headers});
    }

    findGradeByCenterId(centerId : number) : Observable<Grade> {
      return this.http.get<Grade>('api/grades/findByCenter/' + centerId, {headers: this.headers});
    }

    findGradeByCenterAndPersonId(centerId : number, personId: number) : Observable<Grade> {
      return this.http.get<Grade>('api/grades/findByCenterAndPerson/' + centerId + '/' + personId, {headers: this.headers});
    }
  
  }
