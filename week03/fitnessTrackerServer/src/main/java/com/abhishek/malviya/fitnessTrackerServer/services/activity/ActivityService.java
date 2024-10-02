package com.abhishek.malviya.fitnessTrackerServer.services.activity;

import com.abhishek.malviya.fitnessTrackerServer.dto.ActivityDTO;

import java.util.List;

public interface ActivityService  {

    ActivityDTO postActivity(ActivityDTO activityDTO);

    List<ActivityDTO> getActivities();
}
