package com.abhishek.malviya.fitnessTrackerServer.services.goal;

import com.abhishek.malviya.fitnessTrackerServer.dto.GoalDTO;

import java.util.List;

public interface GoalService {
    GoalDTO postGoal(GoalDTO goalDTO);

    List<GoalDTO> getGoals();

    GoalDTO updateStatus(Long id);
}
