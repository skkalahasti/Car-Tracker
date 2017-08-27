import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http} from "@angular/http";

@Injectable()
export class VehicleLocationService {

  constructor(private http:Http) { }

  getlocationhistory(vinnumber): Observable<any[]> {

    return this.http.get(`http://localhost:8080/api/readings/${vinnumber}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));

  }

}
