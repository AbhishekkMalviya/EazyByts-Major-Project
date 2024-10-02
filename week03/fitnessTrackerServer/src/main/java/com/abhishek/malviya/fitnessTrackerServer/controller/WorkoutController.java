package com.abhishek.malviya.fitnessTrackerServer.controller;


import com.abhishek.malviya.fitnessTrackerServer.dto.WorkoutDTO;
import com.abhishek.malviya.fitnessTrackerServer.services.workout.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class WorkoutController {
    private final WorkoutService workoutService;

    @PostMapping("/workout")
    public ResponseEntity<?> postWorkout(@RequestBody WorkoutDTO workoutDTO){
        try{
            return ResponseEntity.ok(workoutService.postWorkout(workoutDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong!");
        }
    }

    @GetMapping("/workouts")
    public ResponseEntity<?> getWorkouts(){
        try {
            return ResponseEntity.ok(workoutService.getWorkouts());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something Went Wrong!");
        }
    }
}
