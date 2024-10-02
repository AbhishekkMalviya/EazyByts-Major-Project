package com.abhishek.malviya.fitnessTrackerServer.controller;

import com.abhishek.malviya.fitnessTrackerServer.dto.ActivityDTO;
import com.abhishek.malviya.fitnessTrackerServer.services.activity.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping("/activity")
    public ResponseEntity<?> postActivity(@RequestBody ActivityDTO activityDTO){
        ActivityDTO createActivity = activityService.postActivity(activityDTO);

        if(createActivity!= null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createActivity);
        }
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
    }

    @GetMapping("/activities")
    public ResponseEntity<?> getActivities(){
        try{
            return ResponseEntity.ok(activityService.getActivities());
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went Wrong");
        }
    }
}
