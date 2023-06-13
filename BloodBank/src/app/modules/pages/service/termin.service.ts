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

  /*
  getTerminiByCenterId(id: number): Observable<any> {
    return this.http.get<TerminDTO[]>('api/termini/' + id, {headers: this.headers});
  }
  */

  getTerminiByCenterId(id: number): Observable<any> {
    return this.http.get<Termin[]>('api/termini/' + id, {headers: this.headers});
  }

  getSlobodniTerminiByCenterId(id: number): Observable<any> {
    return this.http.get<Termin[]>('api/termini/slobodni/' + id, {headers: this.headers});
  }

  getZauzetiTerminiByCenterId(id: number): Observable<any> {
    return this.http.get<Termin[]>('api/termini/zauzeti/' + id, {headers: this.headers});
  }
  
  createTermin(termini: any): Observable<any> {
    return this.http.post<any>('api/termini/add', termini, {headers: this.headers});
  }

  editTermin(terminDTO: TerminDTO, korId: any): Observable<Termin> {
    return this.http.post<Termin>('api/termini/izmena/' + terminDTO.id + '/' + korId, terminDTO, {headers: this.headers});
  }


  getAllbyNameSurname(ime: string, prezime: string, centerId: number): Observable<TerminDTO[]> {
    return this.http.get<TerminDTO[]>('api/termini/search/' + ime + '/' + prezime + '/' + centerId, {headers: this.headers});
  }

  getTerminiByKorId(id: number): Observable<any> {
    return this.http.get<Termin[]>('api/termini/buduci/' + id, {headers: this.headers});
  }

  editTermina(terminDTO: TerminDTO): Observable<Termin> {
    return this.http.post<Termin>('api/termini/izmenaTermina/' + terminDTO.id , terminDTO, {headers: this.headers});
  }

  editTerminQF(terminDTO: TerminDTO): Observable<Termin> {
    return this.http.post<Termin>('api/termini/izmenaTermina/qf/' + terminDTO.id , terminDTO, {headers: this.headers});
  }

  getById(id: number): Observable<any> {
    return this.http.get<TerminDTO>('api/termini/termin/get/' + id, {headers: this.headers});
  }

  getTerminiByUserId(id: number): Observable<any> {
    return this.http.get<Termin[]>('api/termini/prosli/' + id, {headers: this.headers});
  }

}
