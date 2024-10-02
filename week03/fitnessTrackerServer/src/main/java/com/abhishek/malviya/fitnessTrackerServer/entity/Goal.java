package com.abhishek.malviya.fitnessTrackerServer.entity;

import com.abhishek.malviya.fitnessTrackerServer.dto.GoalDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String description
            ;
    private Date startDate, endDate;

    private boolean achieved;

    public GoalDTO getGoalDTO(){
        GoalDTO goalDTO=new GoalDTO();
        goalDTO.setDescription(description);
        goalDTO.setId(id);
        goalDTO.setStartDate(startDate);
        goalDTO.setEndDate(endDate);
        goalDTO.setAchieved(achieved);
        return goalDTO;
    }
}
