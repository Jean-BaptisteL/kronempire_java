package com.kronempire.game.service;

import com.kronempire.game.models.PlayerHasBuilding;
import com.kronempire.game.models.PlayerStat;
import com.kronempire.game.queues.ConstructionQueue;
import com.kronempire.game.repository.PlayerStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PendingConstruction {

    @Autowired
    private PlayerStatRepository playerStatRepository;

    @Autowired
    private ConstructionQueue constructionQueue;

    public void resetQueue() {
        List<PlayerStat> playerStatList = playerStatRepository.findAll();
        for (PlayerStat playerStat : playerStatList) {
            playerStat.setBuildInProgress(false);
            playerStat.setTechnoInProgress(false);
            playerStat.setUnitsInProgress(false);
            playerStat.setEventInProgress(false);
            playerStatRepository.save(playerStat);
        }
    }

    public Map<String, Integer> priceBuilding(PlayerHasBuilding playerHasBuilding) {
        Map<LocalDateTime, Map<PlayerHasBuilding, Map<String, Integer>>> buildingsConstructions = constructionQueue.buildingsConstructions;
        Map<String, Integer> stats = new HashMap<>();
        for (Map.Entry<LocalDateTime, Map<PlayerHasBuilding, Map<String, Integer>>> entry : buildingsConstructions.entrySet()) {
            Map<PlayerHasBuilding, Map<String, Integer>> value = entry.getValue();
            if (value.containsKey(playerHasBuilding))
                stats = value.get(playerHasBuilding);
            break;
        }
        return stats;
    }
}
