package com.kronempire.game.component;

import com.kronempire.game.models.PlayerHasBuilding;
import com.kronempire.game.models.PlayerStat;
import com.kronempire.game.queues.ConstructionQueue;
import com.kronempire.game.repository.PlayerHasBuildingRepository;
import com.kronempire.game.repository.PlayerStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class Scheduler {

    @Autowired
    public ConstructionQueue constructionQueue;

    @Autowired
    public PlayerStatRepository playerStatRepository;

    @Autowired
    public PlayerHasBuildingRepository playerHasBuildingRepository;

    @Scheduled(fixedRate = 1000)
    public void building() {
        Map<LocalDateTime, Map<PlayerHasBuilding, Map<String, Integer>>> buildingsConstructions = constructionQueue.buildingsConstructions;
        ArrayList<LocalDateTime> pastBuild = new ArrayList<>();
        for (Map.Entry<LocalDateTime, Map<PlayerHasBuilding, Map<String, Integer>>> entry : buildingsConstructions.entrySet()) {
            LocalDateTime key = entry.getKey();
            if (key.isAfter(LocalDateTime.now())) {
                pastBuild.add(key);
                Map<PlayerHasBuilding, Map<String, Integer>> value = entry.getValue();
                for (Map.Entry<PlayerHasBuilding, Map<String, Integer>> buildingMapEntry : value.entrySet()) {
                    PlayerHasBuilding playerHasBuilding = buildingMapEntry.getKey();
                    constructionQueue.constructionsPrices.remove(playerHasBuilding.getPlayerStatId());
                    constructionQueue.constructionList.remove(playerHasBuilding.getPlayerStatId());
                    Map<String, Integer> prices = buildingMapEntry.getValue();
                    PlayerStat playerStat = playerHasBuilding.getPlayerStat();
                    playerStat.setMetalQuantity_player_stat(playerStat.getMetalQuantity_player_stat() - prices.get("metalPrice"));
                    playerStat.setWoodQuantity_player_stat(playerStat.getWoodQuantity_player_stat() - prices.get("woodPrice"));
                    playerStat.setManaQuantity_player_stat(playerStat.getMetalQuantity_player_stat() - prices.get("manaPrice"));
                    playerStat.setKronQuantity_player_stat(playerStat.getKronQuantity_player_stat() - prices.get("kronPrice"));
                    playerStat.setBuildInProgress(false);
                    playerHasBuilding.setLevel(playerHasBuilding.getLevel() + 1);
                    playerStatRepository.save(playerStat);
                    playerHasBuildingRepository.save(playerHasBuilding);
                }
            }
        }
        for (LocalDateTime localDateTime : pastBuild) {
            buildingsConstructions.remove(localDateTime);
        }
    }
}
