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


const routes: Routes = [
  { path: 'register-center', component: RegisterCenterComponent },
  { path: 'register', component: RegisterPersonComponent },
  { path: 'register-centerAdministrator', component: RegisterCenterAdministratorComponent}
];

@NgModule({
  declarations: [
    RegisterPersonComponent,
    RegisterCenterComponent,
    RegisterCenterAdministratorComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes),
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatSelectModule
  ],
  exports: [ RouterModule ]
})
export class HospitalModule { }
