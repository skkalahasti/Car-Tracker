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
import {AlertsHistoryService} from "../alerts-history/alerts-history.service";
import { VehicleLocationComponent } from '../vehicle-location/vehicle-location.component';
import {VehicleLocationService} from "../vehicle-location/vehicle-location-service.service";
import { AgmCoreModule } from '@agm/core';
import { SignalplotComponent } from '../signalplot/signalplot.component';
import {ChartModule} from 'primeng/primeng';


const appRoutes: Routes = [
  {path: 'vehicles', component: VehiclesComponent},
  {path: 'alerts', component: AlertsComponent},
  {path: 'alerthistory', component: AlertsHistoryComponent},
  {path: 'locationhistory', component: VehicleLocationComponent},
  {path: 'signalplot', component: SignalplotComponent},
  {path: '', redirectTo: '/vehicles', pathMatch: 'full'}
  ];


@NgModule({
  declarations: [
    AppComponent,
    VehiclesComponent,
    AlertsComponent,
    AlertsHistoryComponent,
    VehicleLocationComponent,
    SignalplotComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ChartModule,
    RouterModule.forRoot(appRoutes),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDsA8vswxtGr5Odrbtvg7hAIxhQTsyQHz0'
    })

  ],
  providers: [VehiclesService, AlertsComponent, AlertsService, VehiclesComponent,AlertsHistoryComponent, AlertsHistoryService, VehicleLocationComponent,VehicleLocationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
