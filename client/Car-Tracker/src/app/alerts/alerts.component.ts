import { Component, OnInit } from '@angular/core';
import {AlertsService} from "./alerts.service";

@Component({
  selector: 'app-alerts',
  templateUrl: './alerts.component.html',
  styleUrls: ['./alerts.component.css']
})
export class AlertsComponent {


  highalerts;
  duration;

  constructor(public alertService: AlertsService) { }

  getalerts(dur_time){

    console.log(dur_time)
    this.highalerts = this.alertService.findHighAlerts(dur_time).subscribe(
      alerts => this.highalerts = alerts,
      error => console.log(error));

  }

}


