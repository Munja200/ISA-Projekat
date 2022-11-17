import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RouterModule, Routes } from "@angular/router";
import { MaterialModule } from "src/app/material/material.module";
import { RegisterPersonComponent } from "./register-person/register-person.component";


const routes: Routes = [
  { path: 'register', component: RegisterPersonComponent }
];

@NgModule({
  declarations: [
    RegisterPersonComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes),
   
  ],exports: [ RouterModule ]
})
export class HospitalModule { }
