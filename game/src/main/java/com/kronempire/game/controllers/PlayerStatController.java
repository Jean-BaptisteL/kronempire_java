package com.kronempire.game.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kronempire.game.component.Scheduler;
import com.kronempire.game.models.Building;
import com.kronempire.game.models.Player;
import com.kronempire.game.models.PlayerHasBuilding;
import com.kronempire.game.models.PlayerStat;
import com.kronempire.game.queues.ConstructionQueue;
import com.kronempire.game.repository.PlayerHasBuildingRepository;
import com.kronempire.game.repository.PlayerRepository;
import com.kronempire.game.repository.PlayerStatRepository;
import com.kronempire.game.security.service.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/stats")
public class PlayerStatController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerHasBuildingRepository playerHasBuildingRepository;

    @Autowired
    private PlayerStatRepository playerStatRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ConstructionQueue constructionQueue;

    @GetMapping("/get")
    public ResponseEntity<Map<String,Object>> getStats(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        String playerEmail = null;
        String jwt = null;
        jwt = authorizationHeader.substring(7);
        playerEmail = jwtUtil.tokenBodyExtractor(jwt).getSubject();
        Player player = playerRepository.findPlayerByEmail(playerEmail);
        PlayerStat stats = player.getStats().get(0);
        List<PlayerHasBuilding> playerHasBuildings = playerHasBuildingRepository.findPlayerHasBuildingByPlayerStat(stats);
        Map<String, Integer> constructionList = constructionQueue.constructionsPrices.get(stats.getId_player_stat());
        if (stats.isBuildInProgress()){
            stats.setMetalQuantity_player_stat(stats.getMetalQuantity_player_stat() - constructionList.get("metalPrice"));
            stats.setWoodQuantity_player_stat(stats.getWoodQuantity_player_stat() - constructionList.get("woodPrice"));
            stats.setManaQuantity_player_stat(stats.getManaQuantity_player_stat() - constructionList.get("manaPrice"));
            stats.setKronQuantity_player_stat(stats.getMetalQuantity_player_stat() - constructionList.get("kronPrice"));
        }
        Map<String, Object> data = new HashMap<>();
        data.put("stat", stats);
        data.put("playerHasBuildings", playerHasBuildings);
        data.put("buildingConstruction", constructionQueue.constructionList.get(stats.getId_player_stat()));
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PutMapping("/construct")
    public ResponseEntity<String> buildingConstruction(HttpServletRequest request, @RequestBody Map<String, Long> data) throws JsonProcessingException {
        String authorizationHeader = request.getHeader("Authorization");
        String playerEmail = null;
        String jwt = null;
        jwt = authorizationHeader.substring(7);
        playerEmail = jwtUtil.tokenBodyExtractor(jwt).getSubject();

        Player player = playerRepository.findPlayerByEmail(playerEmail);
        PlayerStat playerStat = playerStatRepository.findPlayerStatByPlayer(player);

        PlayerHasBuilding playerHasBuilding = playerHasBuildingRepository.findPlayerHasBuildingByPlayerStatIdAndBuildingId((long) playerStat.getId_player_stat(), data.get("id_building"));
        PlayerHasBuilding playerHasMine = playerHasBuildingRepository.findPlayerHasBuildingByPlayerStatIdAndBuildingId(data.get("id_player_stat"), 1L);
        PlayerHasBuilding playerHasScierie = playerHasBuildingRepository.findPlayerHasBuildingByPlayerStatIdAndBuildingId(data.get("id_player_stat"), 2L);
        PlayerHasBuilding playerHasMana = playerHasBuildingRepository.findPlayerHasBuildingByPlayerStatIdAndBuildingId(data.get("id_player_stat"), 3L);
        PlayerHasBuilding playerHasHouses = playerHasBuildingRepository.findPlayerHasBuildingByPlayerStatIdAndBuildingId(data.get("id_player_stat"), 7L);

        int buildingLevel = playerHasBuilding.getLevel() + 1;
        Building building = playerHasBuilding.getBuilding();

        // Nombre de secondes depuis la dernière action du joueur
        int seconds = (int) Duration.between(player.getLastConnection_player(), LocalDateTime.now()).getSeconds();

        // Calcul du prix du bâtiment et du temps de construction
        int metalPrice = building.getMetalPrice_building() * building.getPriceFactor_building() * buildingLevel;
        int woodPrice = building.getWoodPrice_building() * building.getPriceFactor_building() * buildingLevel;
        int manaPrice = building.getManaPrice_building() * building.getPriceFactor_building() * buildingLevel;
        int kronPrice = building.getKronPrice_building() * building.getPriceFactor_building() * buildingLevel;
        LocalDateTime buildTime = LocalDateTime.now().plusSeconds(building.getBuildTime_building() * building.getTimeFactor_building() * buildingLevel);

        //Calcul et sauvegarde des ressources réelles du joueur
        int playerMetal = playerStat.getMetalQuantity_player_stat() + (playerHasMine.getBuilding().getLevelFactor_building() * (1 + playerHasMine.getLevel()) * seconds);
        int playerWood = playerStat.getWoodQuantity_player_stat() + (playerHasScierie.getBuilding().getLevelFactor_building() * (1 + playerHasScierie.getLevel()) * seconds);
        int playerMana = playerStat.getManaQuantity_player_stat() + (playerHasMana.getBuilding().getLevelFactor_building() * (1 + playerHasMana.getLevel()) * seconds);
        int playerPop = 0;
        int playerPopLimite = 100 + (100 * playerHasHouses.getBuilding().getLevelFactor_building() * playerHasHouses.getLevel());
        int playerPopTheoric = (int) (playerStat.getPopQuantity_player_stat() + (playerStat.getPopQuantity_player_stat() * 0.01 * seconds));
        playerPop = Math.min(playerPopTheoric, playerPopLimite);

        int playerKron = (int) (playerStat.getKronQuantity_player_stat() + (0.1 * playerPop * seconds));
        playerStat.setMetalQuantity_player_stat(playerMetal);
        playerStat.setWoodQuantity_player_stat(playerWood);
        playerStat.setManaQuantity_player_stat(playerMana);
        playerStat.setPopQuantity_player_stat(playerPop);
        playerStat.setKronQuantity_player_stat(playerKron);
        System.out.println(playerStat.getMetalQuantity_player_stat());

        if(metalPrice > playerMetal || woodPrice > playerWood || manaPrice > playerMana || kronPrice > playerKron) {
            return new ResponseEntity<>("Les ressources sont inférieures aux prix.", HttpStatus.NOT_ACCEPTABLE);
        }

        //Ajout dans la liste des constructions en cours
        Map<String, Integer> price = new HashMap<>();
        price.put("metalPrice", metalPrice);
        price.put("woodPrice", woodPrice);
        price.put("manaPrice", manaPrice);
        price.put("kronPrice", kronPrice);

        if (playerStat.isBuildInProgress()) {
            return new ResponseEntity<>("Une construction est déjà en cours.", HttpStatus.NOT_ACCEPTABLE);
        }
        playerStat.setBuildInProgress(true);

        if (constructionQueue.buildingsConstructions.containsKey(buildTime)) {
            constructionQueue.buildingsConstructions.get(buildTime).put(playerHasBuilding, price);
        } else {
            Map<PlayerHasBuilding, Map<String, Integer>> playerBuildingPrice = new HashMap<>();
            playerBuildingPrice.put(playerHasBuilding, price);
            constructionQueue.buildingsConstructions.put(buildTime, playerBuildingPrice);
        }

        constructionQueue.constructionsPrices.put(playerStat.getId_player_stat(), price);

        Map<String, String> playerConstruction = new HashMap<>();
        playerConstruction.put("building" , building.getName_building());
        playerConstruction.put("date", buildTime.toString());

        constructionQueue.constructionList.put(playerStat.getId_player_stat(), playerConstruction);
        player.setLastConnection_player(LocalDateTime.now());
        playerStatRepository.save(playerStat);
        playerRepository.save(player);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
