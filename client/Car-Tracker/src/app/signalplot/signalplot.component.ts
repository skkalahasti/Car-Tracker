import {Component} from '@angular/core';
import {SignalPlotService} from "./signal-plot.service";
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-signalplot',
  templateUrl: './signalplot.component.html',
  styleUrls: ['./signalplot.component.css']
})

export class SignalplotComponent{

/*Line chart data*/
type
  data
  options


readings;

  constructor(private signalPlot: SignalPlotService, private http: HttpClient) {



    this.type = 'line';
    this.data = {
      labels:[],
        //["January", "February", "March", "April", "May", "June", "July"],
      datasets: [
        {
          label: "My First dataset",
          data: [65, 59, 80, 81, 56, 55, 40]
        }
      ]
    };
    this.options = {
      responsive: true,
      maintainAspectRatio: false
    };


    this.getreadings();


  }

  chartadd(){
  /*  document.getElementById("charttype").innerHTML = "<chart [type]="+type+ "[data]="+this.data+"[options]="+options+"></chart>"*/
    const element= document.getElementById("charttype");
  const chartnode=document.createElement("chart");
  chartnode.setAttribute("type","data");
    chartnode.setAttribute("type","type");
    chartnode.setAttribute("options","options");
  element.appendChild(chartnode);
  }


  getreadings(){


    this.readings = this.http.get('http://localhost:8080/api/readings/signalplot').subscribe(
      read => {

        this.readings = read;
        this.data.labels=this.readings.labels;
        console.log(this.data.labels);

      },     err => {
        console.log('Something went wrong!');
      });

  }

}
