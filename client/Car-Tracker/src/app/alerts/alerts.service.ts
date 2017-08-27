import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class AlertsService {

  constructor(private http: Http) {
  }

  findHighAlerts(duration_time): Observable<any[]> {

    return this.http.get(`http://localhost:8080/api/alerts/vincount/${duration_time -6}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));

  }

}
