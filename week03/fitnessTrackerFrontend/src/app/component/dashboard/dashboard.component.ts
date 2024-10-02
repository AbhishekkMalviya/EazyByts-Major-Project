import { Component, ElementRef, ViewChild, viewChild } from '@angular/core';
import { UserService } from '../../service/user.service';
import { SharedModule } from '../../shared/shared.module';
import Chart, { CategoryScale } from 'chart.js/auto';

Chart.register(CategoryScale);

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  statsData:any;
  workouts: any;
  activities: any;

  // @viewChild('workoutLineChart') private workoutLineChartRef:ElementRef;
  // @viewChild('activityLineChart') private activityLineChartRef:ElementRef;
  @ViewChild('workoutLineChart', { static: false }) private workoutLineChartRef: ElementRef;  // Corrected ViewChild
  @ViewChild('activityLineChart', { static: false }) private activityLineChartRef: ElementRef;  // Corrected ViewChild

  constructor(private userService:UserService){  }

  ngOnInit(){
    this.getStats();
    this.getGraphStats();
  }

  getGraphStats(){
    this.userService.getGraphStats().subscribe(res=>{
      this.workouts = res.workout;
      this.activities=res.activities;
      console.log(this.workouts, this.activities);
      if(this.workoutLineChartRef || this.workoutLineChartRef){
        this.createLineChart();
      }
    })
  }


  createLineChart(){
    const workoutCtx = this.workoutLineChartRef.nativeElement.getContext('2d');
    const activityCtx = this.activityLineChartRef.nativeElement.getContext('2d');

    new Chart(workoutCtx, {
      type: 'bar',
      data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
          label: '# of Votes',
          data: [12, 19, 3, 5, 2, 3],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }

  getStats(){
    this.userService.getStats().subscribe(res=>{
      console.log(res);
      this.statsData = res;
    })
  }
}
