package com.kronempire.game.controllers;

import com.kronempire.game.models.Player;
import com.kronempire.game.models.PlayerHasBuilding;
import com.kronempire.game.models.PlayerStat;
import com.kronempire.game.repository.PlayerHasBuildingRepository;
import com.kronempire.game.repository.PlayerRepository;
import com.kronempire.game.security.service.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class PlayerStatController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerHasBuildingRepository playerHasBuildingRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/get-stats")
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
        System.out.println(stats.getBuildings().get(0));
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
