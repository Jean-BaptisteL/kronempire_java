package com.kronempire.game.queues;

import com.kronempire.game.models.PlayerHasBuilding;
import com.kronempire.game.models.PlayerStat;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class ConstructionQueue {

    public Map<LocalDateTime, Map<PlayerHasBuilding, Map<String, Integer>>> buildingsConstructions = new HashMap<>();

    public Map<Integer, Map<String, Integer>> constructionsPrices = new HashMap<>();

}
