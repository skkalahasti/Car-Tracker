import {Component, OnInit} from '@angular/core';
import {SignalPlotService} from "./signal-plot.service";
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-signalplot',
  templateUrl: './signalplot.component.html',
  styleUrls: ['./signalplot.component.css']
})

export class SignalplotComponent implements OnInit{

  /*Line chart data*/
  type
  data
  options
  fuelVolume=[];
  engineRpm=[];
  mark;
  timest:Date[]=[];


readings;


  constructor(private signalPlot: SignalPlotService, private http: HttpClient){ }

  ngOnInit(): void {
    this.type = 'line';
    this.data = {
      labels: [],
      datasets: [
        {
          label: "Not Yet Assigned",
          data: [],
          backgroundColor: [
            'rgba(54, 162, 235, 0.2)',
          ],
          borderColor: [
            'rgba(255, 206, 86, 1)',
          ]
        }
      ]
    };

    this.options = {
      responsive: true,
      maintainAspectRatio: false,
    };
  }



  getreadings(vinnumber, time, param){


    this.mark= false;

    this.readings = this.http.get(`http://localhost:8080/api/readings/${vinnumber}/${time-6}`).subscribe(
      read => {

        this.readings = read;

        for(let i=0;i<this.readings.length;i++){
          this.fuelVolume.push(this.readings[i].fuelVolume);
          this.engineRpm.push(this.readings[i].engineRpm);
          this.timest.push(this.readings[i].timestamp);
        }

        if(param=="fuelVolume") {
          this.data.datasets[0].data = this.fuelVolume;
          this.data.datasets[0].label="Fuel Volume";
        }
        else {
          this.data.datasets[0].data = this.engineRpm;
          this.data.datasets[0].label = "Engine Rpm";
        }

        this.data.labels=this.timest;
        this.mark=true;

      },     err => {
        console.log('Something went wrong!');
      });

  }

}
