import { Component, OnInit } from '@angular/core';
import {AlertsHistoryService} from "./alerts-history.service";

@Component({
  selector: 'app-alerts-history',
  templateUrl: './alerts-history.component.html',
  styleUrls: ['./alerts-history.component.css']
})
export class AlertsHistoryComponent implements OnInit {

  alertshistory

  constructor(private alertsHistoryService: AlertsHistoryService) { }

  ngOnInit() {

    this.gethistoricalalerts(this.alertshistory);

  }

  gethistoricalalerts(vinnumber){

    this.alertshistory = this.alertsHistoryService.findAlertsHistory(vinnumber).subscribe(
      alerts => this.alertshistory = alerts,
      error => console.log(error));

  }

}
