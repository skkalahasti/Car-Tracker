import { Component, OnInit } from '@angular/core';
import {AlertsHistoryService} from "./alerts-history.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-alerts-history',
  templateUrl: './alerts-history.component.html',
  styleUrls: ['./alerts-history.component.css']
})
export class AlertsHistoryComponent implements OnInit {

  alertshistory

  constructor(private route:ActivatedRoute, private alertsHistoryService: AlertsHistoryService) { }

  ngOnInit() {

    this.route.params.subscribe(params =>{
      this.alertsHistoryService.findAlertsHistory(params.id,params.time).subscribe(
        alerts => this.alertshistory = alerts);

    });
  }

}

