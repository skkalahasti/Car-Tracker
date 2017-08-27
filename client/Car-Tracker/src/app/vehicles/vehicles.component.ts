import { Component, OnInit } from '@angular/core';
import {VehiclesService} from "./vehicles-service.service";

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit{

  vehicles;

  constructor(private vehiclesService: VehiclesService) {}

  ngOnInit(): void {
    this.vehicles = this.vehiclesService.showVehicles().subscribe(
      vehicles => this.vehicles = vehicles,
      error => console.log(error));

  }
}
