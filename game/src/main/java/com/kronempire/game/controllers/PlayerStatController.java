package com.kronempire.game.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kronempire.game.component.Scheduler;
import com.kronempire.game.models.Building;
import com.kronempire.game.models.Player;
import com.kronempire.game.models.PlayerHasBuilding;
import com.kronempire.game.models.PlayerStat;
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
    private Scheduler scheduler;

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
        Map<String, Object> data = new HashMap<>();
        data.put("stat", stats);
        data.put("playerHasBuildings", playerHasBuildings);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PutMapping("/construct")
    public ResponseEntity<Map<String,Object>> buildingConstruction(@RequestBody Map<String, Long> data) throws JsonProcessingException {
        PlayerHasBuilding playerHasBuilding = playerHasBuildingRepository.findPlayerHasBuildingByPlayerStatIdAndBuildingId(data.get("id_player_stat"), data.get("id_building"));
        PlayerHasBuilding playerHasMine = playerHasBuildingRepository.findPlayerHasBuildingByPlayerStatIdAndBuildingId(data.get("id_player_stat"), 1L);
        PlayerHasBuilding playerHasScierie = playerHasBuildingRepository.findPlayerHasBuildingByPlayerStatIdAndBuildingId(data.get("id_player_stat"), 2L);
        PlayerHasBuilding playerHasMana = playerHasBuildingRepository.findPlayerHasBuildingByPlayerStatIdAndBuildingId(data.get("id_player_stat"), 3L);
        PlayerHasBuilding playerHasHouses = playerHasBuildingRepository.findPlayerHasBuildingByPlayerStatIdAndBuildingId(data.get("id_player_stat"), 7L);
        PlayerStat playerStat = playerHasBuilding.getPlayerStat();
        int buildingLevel = playerHasBuilding.getLevel() + 1;
        Building building = playerHasBuilding.getBuilding();
        Player player = playerHasBuilding.getPlayerStat().getPlayer();

        // Nombre de secondes depuis la dernière action du joueur
        int seconds = (int) Duration.between(player.getLastConnection_player(), LocalDateTime.now()).getSeconds();

        // Calcul du prix du bâtiment
        int metalPrice = building.getMetalPrice_building() * building.getPriceFactor_building() * buildingLevel;
        int woodPrice = building.getWoodPrice_building() * building.getPriceFactor_building() * buildingLevel;
        int manaPrice = building.getManaPrice_building() * building.getPriceFactor_building() * buildingLevel;
        int kronPrice = building.getKronPrice_building() * building.getPriceFactor_building() * buildingLevel;

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
        //playerStatRepository.save(playerStat);

        /*if(metalPrice > playerMetal || woodPrice > playerWood || manaPrice > playerMana || kronPrice > playerKron) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }*/
        //Ajout dans la liste des constructions en cours
        Map<String, Integer> price = new HashMap<>();
        price.put("metalPrice", metalPrice);
        price.put("woodPrice", woodPrice);
        price.put("manaPrice", manaPrice);
        price.put("kronPrice", kronPrice);
        if (scheduler.buildingsConstructions.containsKey(LocalDateTime.now())) {
            scheduler.buildingsConstructions.get(LocalDateTime.now()).put(playerHasBuilding, price);
        } else {
            Map<PlayerHasBuilding, Map<String, Integer>> playerBuildingPrice = new HashMap<>();
            playerBuildingPrice.put(playerHasBuilding, price);
            scheduler.buildingsConstructions.put(LocalDateTime.now(), playerBuildingPrice);
        }
        player.setLastConnection_player(LocalDateTime.now());
        //playerRepository.save(player);
        return null;
    }
}
