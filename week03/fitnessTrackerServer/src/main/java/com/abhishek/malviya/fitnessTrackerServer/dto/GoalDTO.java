package com.abhishek.malviya.fitnessTrackerServer.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GoalDTO {

    private  Long id;

    private String description;

    private Date startDate, endDate;

    private boolean achieved;
}
