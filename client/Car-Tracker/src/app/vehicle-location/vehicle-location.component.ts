import { Component, OnInit } from '@angular/core';
import {VehicleLocationService} from "./vehicle-location-service.service";

@Component({
  selector: 'app-vehicle-location',
  templateUrl: './vehicle-location.component.html',
  styleUrls: ['./vehicle-location.component.css']
})
export class VehicleLocationComponent implements OnInit {

  vehiclelocationhis;

  constructor(private vehicleLocationService : VehicleLocationService ) { }


  ngOnInit() {

  }

  getlocationhistory(vinnumber){

    this.vehiclelocationhis = this.vehicleLocationService.getlocationhistory(vinnumber).subscribe(
      locationhistory => this.vehiclelocationhis = locationhistory,
      error => console.log(error));

  }


}
