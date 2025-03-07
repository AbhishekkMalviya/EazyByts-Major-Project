package com.abhishek.malviya.fitnessTrackerServer.services.workout;

import com.abhishek.malviya.fitnessTrackerServer.dto.WorkoutDTO;
import com.abhishek.malviya.fitnessTrackerServer.entity.Workout;
import com.abhishek.malviya.fitnessTrackerServer.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;


    public WorkoutDTO postWorkout(WorkoutDTO workoutDTO){
        Workout workout = new Workout();

        workout.setType(workoutDTO.getType());
        workout.setDate(workoutDTO.getDate());
        workout.setDuration(workoutDTO.getDuration());
        workout.setCaloriesBurned(workoutDTO.getCaloriesBurned());

        return workoutRepository.save(workout).getWorkoutDto();
    }

    public List<WorkoutDTO> getWorkouts(){
        List<Workout> workouts = workoutRepository.findAll();
        return workouts.stream().map(Workout::getWorkoutDto).collect(Collectors.toList());
    }

}
