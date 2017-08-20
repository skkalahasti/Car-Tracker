import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";


import { AppComponent } from './app.component';
import { HttpModule } from "@angular/http";
import { RouterModule, Routes } from "@angular/router";
import { VehiclesComponent } from './vehicles/vehicles.component';
import {VehiclesService} from "./vehicles/vehicles-service.service";

const appRoutes: Routes = [
  {path: 'vehicles', component: VehiclesComponent},
  {path: '', redirectTo: '/vehicles', pathMatch: 'full'}
  ];


@NgModule({
  declarations: [
    AppComponent,
    VehiclesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [VehiclesComponent,VehiclesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
