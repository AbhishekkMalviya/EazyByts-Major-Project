package com.abhishek.malviya.fitnessTrackerServer.services.workout;

import com.abhishek.malviya.fitnessTrackerServer.dto.GoalDTO;
import com.abhishek.malviya.fitnessTrackerServer.dto.WorkoutDTO;

import java.util.List;

public interface WorkoutService {

    WorkoutDTO postWorkout(WorkoutDTO workoutDTO);

    List<WorkoutDTO> getWorkouts();


}
