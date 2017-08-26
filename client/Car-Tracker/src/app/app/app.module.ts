import { BrowserModule } from '@angular/platform-browser';
import {Component, NgModule} from '@angular/core';
import { FormsModule } from "@angular/forms";
import { AppComponent } from './app.component';
import {Http, HttpModule} from "@angular/http";
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
import {SignalPlotService} from "../signalplot/signal-plot.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { ChartModule } from 'angular2-chartjs';
import { AlertHistoryAllComponent } from '../alert-history-all/alert-history-all.component';
import {AlertHistoyAllService} from '../alert-history-all/alert-histoy-all.service'

const appRoutes: Routes = [
  {path: 'vehicles', component: VehiclesComponent},
  {path: 'alerts', component: AlertsComponent},
  {path: 'alerthistory', component: AlertHistoryAllComponent},
  {path: 'alerthistory/:id/:time', component: AlertsHistoryComponent},
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
    AlertHistoryAllComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    HttpModule,
    ChartModule,
    RouterModule.forRoot(appRoutes),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDsA8vswxtGr5Odrbtvg7hAIxhQTsyQHz0'
    })

  ],
  providers: [VehiclesService, AlertsComponent, AlertsService, VehiclesComponent,AlertsHistoryComponent, AlertsHistoryService, VehicleLocationComponent,VehicleLocationService, SignalplotComponent, SignalPlotService,AlertHistoryAllComponent, AlertHistoyAllService],
  bootstrap: [AppComponent]
})
export class AppModule { }
