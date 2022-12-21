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


const routes: Routes = [
  { path: 'registerCenter', component: RegisterCenterComponent },
  { path: 'register', component: RegisterPersonComponent },
  { path: 'questionForm', component: QuestionFormComponent },
  { path: 'registerCenterAdministrator', component: RegisterCenterAdministratorComponent},
  { path: 'registerCenterAdministrator', component: RegisterCenterAdministratorComponent},
  { path: 'profilOfRegisteredUser', component: ProfilOfRegisteredUserComponent},
  { path: 'editProfilRegisteredUser', component: EditProfilRegisteredUserComponent},
  { path: 'registeredPersons', component: SearchRegisteredPersons},
  { path: 'complaints', component: ComplaintsComponent},
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
  ],
  exports: [ RouterModule ]
})
export class HospitalModule { }
