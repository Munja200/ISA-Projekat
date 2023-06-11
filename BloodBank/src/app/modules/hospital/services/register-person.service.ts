import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from '../model/person';
import { RegisteredPerson } from '../model/registeredPerson';
import { RegisteredUserUpdateDTO } from '../model/registeredUserUpdateDTO';
import { PersonDTO } from '../model/personDTO';

@Injectable({
  providedIn: 'root'
})
export class RegisterPersonService {
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getAll(): Observable<Person[]> {
    return this.http.get<Person[]>('api/persons', {headers: this.headers});
  }

  getPerson(id: number): Observable<Person> {
    return this.http.get<Person>('api/persons/' + id, {headers: this.headers});
  }

  getRegisteredPerson(id: number): Observable<RegisteredPerson> {
    return this.http.get<RegisteredPerson>('api/registeredUsers/oneRegisteredUser/' + id, {headers: this.headers});
  }

  registerPerson(person: any): Observable<any> {
    return this.http.post<any>('api/persons', person, {headers: this.headers});
  }

  updateRegisteredUser(registeredUserDto: RegisteredUserUpdateDTO){
    return this.http.post<any>('api/registeredUsers/updateRegisteredUser/' + registeredUserDto.id, registeredUserDto, {headers: this.headers});
  }

  getAllByNameSurname(name: string, surname: string, id: number){
    return this.http.get<any>('api/registeredUsers/' + name + '/' + surname + '/' + id, {headers: this.headers});

  }

  getRegisteredUsersByCenterAndPersonId(centerId: number, personId: number) {
    return this.http.get<any>('api/registeredUsers/findByCenter/' + centerId + '/person/' + personId, { headers: this.headers });
  }
  

  verify(id: string){
    return this.http.get<Person>('api/persons/verify/' + id, {headers: this.headers});
  }

  getUserByUsername(username: string) {
    return this.http.get<Person>('api/persons/username/' + username, {headers: this.headers});
  }

  updateRegisteredPerson(person: Person){
    return this.http.post<any>('api/persons/updateRegisteredUser/' + person.id, person, {headers: this.headers});
  }
  
}
