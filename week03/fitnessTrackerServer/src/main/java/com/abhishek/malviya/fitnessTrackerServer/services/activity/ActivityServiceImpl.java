package com.abhishek.malviya.fitnessTrackerServer.services.activity;

import com.abhishek.malviya.fitnessTrackerServer.dto.ActivityDTO;
import com.abhishek.malviya.fitnessTrackerServer.entity.Activity;
import com.abhishek.malviya.fitnessTrackerServer.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService{
    private final ActivityRepository activityRepository;

    public ActivityDTO postActivity(ActivityDTO activityDTO){
        Activity activity= new Activity();

        activity.setDate(activityDTO.getDate());
        activity.setSteps(activityDTO.getSteps());
        activity.setDistance(activityDTO.getDistance());
        activity.setCaloriesBurned(activityDTO.getCaloriesBurned());

        return activityRepository.save(activity).getActivityDTO();
    }


    public List<ActivityDTO> getActivities(){
        List<Activity> activities = activityRepository.findAll();
        return activities.stream().map(Activity::getActivityDTO).collect(Collectors.toList());
    }
}
