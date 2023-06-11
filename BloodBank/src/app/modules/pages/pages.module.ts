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
import { AuthWelcomeService } from '../hospital/services/auth-welcome.service';
import { HomeADMINCENTERComponent } from './home-admincenter/home-admincenter.component';
import { BloodViewComponent } from './blood-view/blood-view.component';
import { DonorsComponent } from './donors/donors.component';
import { EditCenterComponent } from './edit-center/edit-center.component';
import { CalendarAdminComponent } from './calendar-admin/calendar-admin.component';
import { ChangePasswordComponent } from './change-password/change-password.component';


const routes: Routes = [
  { path: '', component: WelcomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'homeAdmin', component: HomeAdminComponent, canActivate: [AuthWelcomeService] },
  { path: 'home', component: HomeUserComponent, canActivate: [AuthWelcomeService] },
  { path: 'homeAdminCenter', component: HomeADMINCENTERComponent, canActivate: [AuthWelcomeService] },
  { path: 'calendar', component: CalendarAdminComponent, canActivate: [AuthWelcomeService] },

];

@NgModule({
  declarations: [
    WelcomeComponent,
    LoginComponent,
    HomeAdminComponent,
    HomeUserComponent,
    HomeADMINCENTERComponent,
    BloodViewComponent,
    DonorsComponent,
    EditCenterComponent,
    CalendarAdminComponent,
    ChangePasswordComponent
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
  exports: [ RouterModule ]
})
export class PagesModule { }
