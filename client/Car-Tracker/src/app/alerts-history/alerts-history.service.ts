import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http} from "@angular/http";

@Injectable()
export class AlertsHistoryService {

  constructor(private http: Http) {
  }

  findAlertsHistory(vinnumber): Observable<any[]> {

    return this.http.get(`http://localhost:8080/api/alerts/vin/${vinnumber}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));

  }

}
