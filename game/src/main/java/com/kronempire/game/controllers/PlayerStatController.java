package com.kronempire.game.controllers;

import com.kronempire.game.models.*;
import com.kronempire.game.repository.PlayerRepository;
import com.kronempire.game.repository.PlayerStatRepository;
import com.kronempire.game.security.JwtRequestFilter;
import com.kronempire.game.security.service.JwtUtil;
import com.kronempire.game.services.PlayerService;
import com.kronempire.game.services.PlayerStatService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playerStat")
public class PlayerStatController {

    private PlayerHasBuilding playerHasBuilding;
    private PlayerHasTechnology playerHasTechnology;
    private PlayerHasUnit playerHasUnit;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerStatRepository playerStatRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    private PlayerStatService playerStatService;

    @GetMapping("/get")
    public ResponseEntity<PlayerStat> getPlayerStatById(HttpServletRequest request) {
        final String authorizationHeader = request.getHeader("Authorization");
        String playerEmail = null;
        String jwt;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            playerEmail = jwtUtil.tokenBodyExtractor(jwt).getSubject();
        }

        PlayerStat stat = playerService.getStatByPlayerEmail(playerEmail);
        System.out.println("player stat log ::" + stat.toString());

        return new ResponseEntity<>(stat, HttpStatus.OK);
    }
}
