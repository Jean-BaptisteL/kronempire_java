package com.kronempire.game.component;

import com.kronempire.game.models.PlayerHasBuilding;
import com.kronempire.game.models.PlayerStat;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Scheduler {

    public Map<LocalDateTime, Map<PlayerHasBuilding, Map<String, Integer>>> buildingsConstructions = new HashMap<>();

    @Scheduled(fixedRate = 1000)
    public void fixedRateSch() {
        System.out.println(buildingsConstructions);
    }
}
