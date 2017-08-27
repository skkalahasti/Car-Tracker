import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class AlertHistoyAllService {

  constructor(private http: Http) {
  }

  findAlertsHistory(vinnumber): Observable<any[]> {

    return this.http.get(`http://localhost:8080/api/alerts/vin/${vinnumber}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));

  }

}
