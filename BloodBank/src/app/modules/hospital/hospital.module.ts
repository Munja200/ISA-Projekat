import { ComplaintsComponent } from './complaints/complaints.component';
import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatSelectModule } from "@angular/material/select";
import { MatSortModule } from "@angular/material/sort";
import { MatTableModule } from "@angular/material/table";
import { RouterModule, Routes } from "@angular/router";
import { MaterialModule } from "src/app/material/material.module";
import { RegisterCenterComponent } from "./register-center/register-center.component";
import { RegisterCenterAdministratorComponent } from "./register-centerAdministrator/register-centerAdministrator.component";
import { RegisterPersonComponent } from "./register-person/register-person.component";
import { QuestionFormComponent } from './question-form/question-form.component';
import { MatRadioModule } from '@angular/material/radio';
import { ProfilOfRegisteredUserComponent } from './profil-of-registered-user/profil-of-registered-user.component';
import { EditProfilRegisteredUserComponent } from './edit-profil-registered-user/edit-profil-registered-user.component';
import { SearchRegisteredPersons } from "./search-RegisteredPersons/search-RegisteredPersons.component";
import { AppRoutingModule } from "src/app/app-routing.module";
import { CalendarComponent } from './calendar/calendar.component';
import { BrowserModule } from "@angular/platform-browser";
import { DayPilotModule } from "@daypilot/daypilot-lite-angular";
import { HttpClientModule } from "@angular/common/http";
import { CenterAppointmentComponent } from './centar-appointments/center-appointment.component';
import { UserAppointmentsComponent } from './user-appointments/user-appointments.component';
import { VerifyComponent } from './verify/verify.component';
import { MapsComponent } from '../maps/maps.component';
import { AuthWelcomeService } from './services/auth-welcome.service';
import { BloodViewComponent } from '../pages/blood-view/blood-view.component';
import { DonorsComponent } from '../pages/donors/donors.component';
import { EditCenterComponent } from '../pages/edit-center/edit-center.component';
import { ChangePasswordComponent } from '../pages/change-password/change-password.component';
import { CalendarAdminComponent } from '../pages/calendar-admin/calendar-admin.component';
import { GradeComponent } from '../pages/grade/grade.component';
import { RateCenterComponent } from '../pages/rate-center/rate-center.component';



const routes: Routes = [
  { path: 'registerCenter', component: RegisterCenterComponent, canActivate: [AuthWelcomeService] },
  { path: 'register', component: RegisterPersonComponent  },
  { path: 'questionForm', component: QuestionFormComponent, canActivate: [AuthWelcomeService]  },
  { path: 'registerCenterAdministrator', component: RegisterCenterAdministratorComponent, canActivate: [AuthWelcomeService] },
  { path: 'profilOfRegisteredUser', component: ProfilOfRegisteredUserComponent, canActivate: [AuthWelcomeService] },
  { path: 'editProfilRegisteredUser', component: EditProfilRegisteredUserComponent, canActivate: [AuthWelcomeService] },
  { path: 'registeredPersons', component: SearchRegisteredPersons, canActivate: [AuthWelcomeService] },
  { path: 'complaints', component: ComplaintsComponent, canActivate: [AuthWelcomeService] },
  { path: 'calendaaaar', component: CalendarComponent, canActivate: [AuthWelcomeService] },
  { path: 'centerAppointments', component: CenterAppointmentComponent, canActivate: [AuthWelcomeService] },
  { path: 'userAppointments', component: UserAppointmentsComponent, canActivate: [AuthWelcomeService] },
  { path: 'login/verify/:id', component: VerifyComponent, canActivate: [AuthWelcomeService] },
  { path: 'maps', component: MapsComponent, canActivate: [AuthWelcomeService] },
  { path: 'bloods', component: BloodViewComponent, canActivate: [AuthWelcomeService]},
  { path: 'donors', component: DonorsComponent, canActivate: [AuthWelcomeService]},
  { path: 'editCenter', component: EditCenterComponent, canActivate: [AuthWelcomeService]},
  { path: 'changePassword', component: ChangePasswordComponent, canActivate: [AuthWelcomeService]},
  { path: 'calendar', component: CalendarAdminComponent, canActivate: [AuthWelcomeService] },
  { path: 'grade', component: GradeComponent, canActivate: [AuthWelcomeService] },
  { path: 'rate', component: RateCenterComponent, canActivate: [AuthWelcomeService] }
  
];

@NgModule({
  declarations: [
    RegisterPersonComponent,
    QuestionFormComponent,
    RegisterCenterComponent,
    RegisterCenterAdministratorComponent,
    ProfilOfRegisteredUserComponent,
    EditProfilRegisteredUserComponent,
    SearchRegisteredPersons,
    ComplaintsComponent,
    CalendarComponent,
    CenterAppointmentComponent,
    UserAppointmentsComponent,
    VerifyComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes),
    MatTableModule,
    MatPaginatorModule,
    MatRadioModule,
    MatSortModule,
    MatSelectModule,
    AppRoutingModule,
    DayPilotModule,
    BrowserModule,
    HttpClientModule,
  ],
  exports: [ RouterModule ]
})
export class HospitalModule { }
