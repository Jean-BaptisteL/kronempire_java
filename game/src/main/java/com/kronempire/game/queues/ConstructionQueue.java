package com.kronempire.game.queues;

import com.kronempire.game.models.PlayerHasBuilding;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class ConstructionQueue {

    // clef de la 1e map: date de fin de construction
    // clef de la 2e map: PlayerHasBuilding
    // clef de la 3e map: nom de bâtiment; valeur prix
    public Map<LocalDateTime, Map<PlayerHasBuilding, Map<String, Integer>>> buildingsConstructions = new HashMap<>();

    public Map<Integer, Map<String, Integer>> constructionsPrices = new HashMap<>();

    public Map<Integer, Map<String, String>> constructionList = new HashMap<>();

}
