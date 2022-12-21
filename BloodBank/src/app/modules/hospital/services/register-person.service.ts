import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from '../model/person';

@Injectable({
  providedIn: 'root'
})
export class RegisterPersonService {
  apiHost: string = 'http://localhost:8080/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getAll(): Observable<Person[]> {
    return this.http.get<Person[]>(this.apiHost + 'api/persons', {headers: this.headers});
  }

  getPerson(id: number): Observable<Person> {
    return this.http.get<Person>(this.apiHost + 'api/persons/' + id, {headers: this.headers});
  }

  registerPerson(person: any): Observable<any> {
    console.log(person);
    return this.http.post<any>(this.apiHost + 'api/persons', person, {headers: this.headers});
  }
}
