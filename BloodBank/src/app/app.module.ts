import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { MaterialModule } from "./material/material.module";
import { HospitalModule } from "./modules/hospital/hospital.module";
import { PagesModule } from "./modules/pages/pages.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { JwtInterceptorService } from "./modules/hospital/interceptor/TokenInterceptor";
import { ApiService } from "./modules/hospital/services/api.service";
import { AuthService } from "./modules/hospital/services/auth.service";
import { GoogleMapsModule } from '@angular/google-maps';
import { MapsComponent } from './modules/maps/maps.component'


@NgModule({
  declarations: [
    AppComponent,
    MapsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule,
    PagesModule,
    HospitalModule,
    GoogleMapsModule


  ],
   providers: [ 
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptorService,
      multi: true
    },
    AuthService,
    ApiService,
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
