import {Component} from '@angular/core';
import {VehicleLocationService} from "../vehicle-location/vehicle-location-service.service";

@Component({
  selector: 'app-signalplot',
  templateUrl: './signalplot.component.html',
  styleUrls: ['./signalplot.component.css']
})
export class SignalplotComponent{

  readings;
  time;
  data;
  parameter;

  setparameter(read){
    this.readings=read;
  }

  settime(time){
    this.time = time;
  }

  constructor(private vehicleLocationService : VehicleLocationService) {

  }

  fty(rt)
  {
    alert(rt);
  }


  getreadings(vinnumber){

    this.readings= this.vehicleLocationService.getlocationhistory(vinnumber).subscribe(
      reads => this.readings = reads,
      error => console.log(error));

  }



}
