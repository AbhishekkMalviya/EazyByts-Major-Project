package com.abhishek.malviya.fitnessTrackerServer.services.stats;

import com.abhishek.malviya.fitnessTrackerServer.dto.GraphDTO;
import com.abhishek.malviya.fitnessTrackerServer.dto.StatsDTO;

public interface StatsService {
    StatsDTO getStats();

    GraphDTO getGraphStats();
}
