import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http} from "@angular/http";

@Injectable()
export class AlertsHistoryService {

  constructor(private http: Http) {
  }

  findAlertsHistory(): Observable<any[]> {

    return this.http.get(`http://localhost:8080/api/alerts/priority/high/`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));

  }

}
