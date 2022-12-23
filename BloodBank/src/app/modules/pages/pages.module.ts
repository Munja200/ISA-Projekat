import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from 'src/app/app-routing.module'; 
import { WelcomeComponent } from './welcome/welcome.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSelectModule } from '@angular/material/select';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MaterialModule } from 'src/app/material/material.module';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeAdminComponent } from './homeADMIN/homeAdmin.component';
import { HomeUserComponent } from './homeUSER/homeUser.component';
import { AuthUserGuard } from '../hospital/services/authUser.guard';
import { AuthCenterAdminGuard } from '../hospital/services/authCenterAdmin.guard';
import { AuthAdminGuard } from '../hospital/services/authAdmin.guard';
import { HomeCenterAdminComponent } from './homeCENTER_ADMIN/homeCenterAdmin.component';

const routes: Routes = [
  { path: '', component: WelcomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'homeAdmin', component: HomeAdminComponent, canActivate: [ AuthAdminGuard ] },
  { path: 'home', component: HomeUserComponent, canActivate: [ AuthUserGuard ] },
  { path: 'homeCenterAdmin', component: HomeCenterAdminComponent, canActivate: [ AuthCenterAdminGuard ] },
];

@NgModule({
  declarations: [
    WelcomeComponent,
    LoginComponent,
    HomeAdminComponent,
    HomeUserComponent,
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatSelectModule,
    RouterModule.forChild(routes),
  ],
  exports: [ RouterModule ],
  providers: [ 
    AuthUserGuard,
    AuthCenterAdminGuard,
    AuthAdminGuard,
  ], 
})
export class PagesModule { }
