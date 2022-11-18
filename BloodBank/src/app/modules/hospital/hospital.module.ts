import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatSelectModule } from "@angular/material/select";
import { MatSortModule } from "@angular/material/sort";
import { MatTableModule } from "@angular/material/table";
import { RouterModule, Routes } from "@angular/router";
import { MaterialModule } from "src/app/material/material.module";
import { RegisterPersonComponent } from "./register-person/register-person.component";
import { QuestionFormComponent } from './question-form/question-form.component';
import {MatRadioModule} from '@angular/material/radio';


const routes: Routes = [
  { path: 'register', component: RegisterPersonComponent },
  { path: 'questionForm', component: QuestionFormComponent },

];

@NgModule({
  declarations: [
    RegisterPersonComponent,
    QuestionFormComponent
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
    MatSelectModule
  ],
  exports: [ RouterModule ]
})
export class HospitalModule { }
