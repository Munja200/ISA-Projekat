import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from '../model/person';
import { Question } from '../model/question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getAll(): Observable<Question[]> {
    return this.http.get<Question[]>('api/questions', {headers: this.headers});
  }
  createQuestion(question: any): Observable<any> {
    return this.http.post<any>('api/questionForms/add', question, {headers: this.headers});
  }
  
}
