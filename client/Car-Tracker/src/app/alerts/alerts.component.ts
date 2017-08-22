import { Component, OnInit } from '@angular/core';
import {AlertsService} from "./alerts.service";

@Component({
  selector: 'app-alerts',
  templateUrl: './alerts.component.html',
  styleUrls: ['./alerts.component.css']
})
export class AlertsComponent implements OnInit {


  highalerts;
  duration_time;
  duration;

  constructor(public alertService: AlertsService) { }

  ngOnInit(): void {
    this.duration=[1,2,4,12,24];
    this.duration_time=2;
    this.getalerts();
  }

  getalerts(){


    this.highalerts = this.alertService.findHighAlerts(this.duration_time).subscribe(
      alerts => this.highalerts = alerts,
      error => console.log(error));

  }


}


