import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../hospital/services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TerminDTO } from '../../hospital/model/terminDTO';
import { Person } from '../../hospital/model/person';
import { RegisterPersonService } from '../../hospital/services/register-person.service';
import { RegisteredUserUpdateDTO } from '../../hospital/model/registeredUserUpdateDTO';

@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  styleUrls: ['./exam.component.css']
})
export class ExamComponent implements OnInit {

  showingForm1: boolean = false;
  showingForm3: boolean = false;

  name: string = '';
  surname : string = '';

  public pocetak: Date = new Date();
  public kraj: Date = new Date();

  public registeredUserDto: RegisteredUserUpdateDTO = new RegisteredUserUpdateDTO(0, '', '', '', '', '', '', '', new Date(), '', null, '', 0);
  public korisnikId : number = 0;

  constructor(private route: ActivatedRoute, private registerPersonService: RegisterPersonService, private router: Router, private authService: AuthService, ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.korisnikId = params['korId'];
      this.name = params['name'];
      this.surname = params['surname'];
      this.pocetak = params['startDate'];
      this.kraj = params['endDate'];
    });

    this.registerPersonService.getPerson(this.korisnikId).subscribe( res => {
      this.registeredUserDto = res;
    })
  }

  logout(){
    this.authService.logout()
  }

  showForm1() {
    this.showingForm1 = true;
    this.showingForm3 = false;
  }

  givePenal() {
    this.showingForm1 = false;
    this.showingForm3 = false;
    this.registeredUserDto.penal = this.registeredUserDto.penal + 1; 
    this.registerPersonService.updateRegisteredUser(this.registeredUserDto).subscribe( res2 => {
      alert('Uspesno ste dodelili penal korisniku');
      this.router.navigate(['/homeAdminCenter']);
  })
}

  showForm3() {
    this.showingForm1 = false;
    this.showingForm3 = true;
  }

  formatirajDatum(datum: string): string {
    const [godina, mesec, dan, sat, minut] = datum.split(',');
    return `${godina}-${mesec}-${dan} ${sat}:${minut}:00`;
  }
  
  padNumber(number: number): string {
    return number.toString().padStart(2, '0');
  }

}
