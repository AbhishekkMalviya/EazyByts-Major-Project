package com.abhishek.malviya.fitnessTrackerServer.services.stats;

import com.abhishek.malviya.fitnessTrackerServer.dto.GraphDTO;
import com.abhishek.malviya.fitnessTrackerServer.dto.StatsDTO;
import com.abhishek.malviya.fitnessTrackerServer.entity.Activity;
import com.abhishek.malviya.fitnessTrackerServer.entity.Workout;
import com.abhishek.malviya.fitnessTrackerServer.repository.ActivityRepository;
import com.abhishek.malviya.fitnessTrackerServer.repository.GoalRepository;
import com.abhishek.malviya.fitnessTrackerServer.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService{
    private  final GoalRepository goalRepository;

    private final ActivityRepository activityRepository;

    private final WorkoutRepository workoutRepository;

    public StatsDTO getStats(){
        Long achievedGoals =goalRepository.countAchievedGoals();
        Long notAchievedGoals =goalRepository.countNotAchievedGoals();

        Integer totalSteps= activityRepository.getTotalSteps();
        Double totalDistance = activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurned = activityRepository.getTotalActivityCalories();

        Integer totalWorkoutDuration=workoutRepository.getTotalDuration();
        Integer totalWorkoutCaloriesBurned = workoutRepository.getTotalCaloriesBurned();

        int totalCaloriesBurned = (totalActivityCaloriesBurned!=null? totalActivityCaloriesBurned:0)
                + (totalWorkoutCaloriesBurned!=null? totalWorkoutCaloriesBurned:0);


        StatsDTO statsDTO = new StatsDTO();
        statsDTO.setAchievedGoals(achievedGoals != null ? achievedGoals : 0);
        statsDTO.setNotAchievedGoals(achievedGoals != null ? notAchievedGoals : 0);

        statsDTO.setSteps(totalSteps!= null? totalSteps : 0);
        statsDTO.setDistance(totalDistance != null ? totalDistance : 0);
        statsDTO.setTotalCaloriesBurned(totalCaloriesBurned);
        statsDTO.setDuration(totalWorkoutDuration!=null ? totalWorkoutDuration:0);
        return statsDTO;
    }

    public GraphDTO getGraphStats(){
        Pageable pageable = PageRequest.of(0,7);
        List<Workout> workouts = workoutRepository.findLast7Workouts(pageable);
        List<Activity> activities = activityRepository.findLast7Activities(pageable);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setWorkouts(workouts.stream().map(Workout::getWorkoutDto).collect(Collectors.toList()));
        graphDTO.setActivities(activities.stream().map(Activity::getActivityDTO).collect(Collectors.toList()));

        return graphDTO;
    }
}
