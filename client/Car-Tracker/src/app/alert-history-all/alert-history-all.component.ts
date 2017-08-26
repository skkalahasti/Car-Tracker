import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AlertHistoyAllService} from "./alert-histoy-all.service";

@Component({
  selector: 'app-alert-history-all',
  templateUrl: './alert-history-all.component.html',
  styleUrls: ['./alert-history-all.component.css']
})
export class AlertHistoryAllComponent{
  alertshistory: any[];

  constructor(private route: ActivatedRoute, private alertHistoryAllService: AlertHistoyAllService) { }

  gethistoricalalerts(vinnumber){
  this.route.params.subscribe(params => {
  this.alertHistoryAllService.findAlertsHistory(vinnumber).subscribe(
    alerts => this.alertshistory = alerts);

   });

}

}
