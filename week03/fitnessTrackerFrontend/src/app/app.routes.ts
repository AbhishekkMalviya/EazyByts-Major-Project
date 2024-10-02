import { Routes } from '@angular/router';
import { ActivityComponent } from './component/activity/activity.component';
import { WorkoutComponent } from './component/workout/workout.component';
import { GoalComponent } from './component/goal/goal.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';


export const routes: Routes = [
    { path: "activity", component: ActivityComponent},
    { path: "workout", component: WorkoutComponent},
    { path: "goal", component:GoalComponent},
    { path: "dashboard", component:DashboardComponent},

];
