import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http} from "@angular/http";

@Injectable()
export class AlertsHistoryService {

  constructor(private http: Http) {
  }

  findAlertsHistory(vinnumber,time): Observable<any[]> {

    return this.http.get(`http://localhost:8080/api/alerts/vin/${vinnumber}/${time}-6`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));

  }

}
