import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class SignalPlotService {

  constructor(private http: Http) {

  }

  getlocationhistory(vinnumber): Observable<any[]> {

    return this.http.get('http://localhost:8080/api/readings/signalplot')
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));

  }
}
