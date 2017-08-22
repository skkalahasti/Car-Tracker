import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { AppComponent } from './app.component';
import { HttpModule } from "@angular/http";
import { RouterModule, Routes } from "@angular/router";
import { VehiclesComponent } from '../vehicles/vehicles.component';
import {VehiclesService} from "../vehicles/vehicles-service.service";
import { AlertsComponent } from '../alerts/alerts.component';
import {AlertsService} from "../alerts/alerts.service";
import { AlertsHistoryComponent } from '../alerts-history/alerts-history.component';


const appRoutes: Routes = [
  {path: 'vehicles', component: VehiclesComponent},
  {path: 'alerts', component: AlertsComponent},
  {path: '', redirectTo: '/vehicles', pathMatch: 'full'}
  ];


@NgModule({
  declarations: [
    AppComponent,
    VehiclesComponent,
    AlertsComponent,
    AlertsHistoryComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [VehiclesService, AlertsComponent, AlertsService, VehiclesComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
