package com.kronempire.game.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kronempire.game.models.*;
import com.kronempire.game.repository.*;
import com.kronempire.game.security.service.JwtUtil;
import com.kronempire.game.security.service.PlayerSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private  PlayerStatRepository playerStatRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private PlayerHasBuildingRepository playerHasBuildingRepository;

    @Autowired
    private PlayerHasTechnologyRepository playerHasTechnologyRepository;

    @Autowired
    private PlayerHasUnitRepository playerHasUnitRepository;

    private AuthenticationManager authenticationManager;

    private PlayerSpringService userDetailsService;

    private JwtUtil jwtUtil;

    @Autowired
    public PlayerController(AuthenticationManager authenticationManager, PlayerSpringService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody String playerJson) throws JsonProcessingException {
        System.out.println("kjfglwi");
        ObjectMapper mapper = new ObjectMapper();
        Player player = mapper.readValue(playerJson, Player.class);
        System.out.println(playerJson);
        player.setDate_player(LocalDate.now());
        player.setLastConnection_player(LocalDateTime.now());
        player.setStatus_player(1);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        player.setPassword_player(passwordEncoder.encode(player.getPassword_player()));
        try {
            if (playerRepository.findPlayerByEmail(player.getEmail()) == null) {
                if (Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",player.getEmail())){
                    if (Pattern.matches("^[\\w-\\.]+$", player.getPseudo_player())){
                        playerRepository.save(player);
                        Player playerSaved = playerRepository.findPlayerByEmail(player.getEmail());
                        PlayerStat stat = new PlayerStat();
                        stat.setPlayer(player);
                        Integer playerStatNumber = playerStatRepository.countAllPlayerStats();
                        if (playerStatNumber == 0){
                            stat.setCoordinates_player_stat("1-1");
                        } else {
                            if (playerStatNumber % 10 == 0 ) {
                                stat.setCoordinates_player_stat((playerStatNumber/10+1) + "-1");
                            } else {
                                stat.setCoordinates_player_stat((playerStatNumber/10+1) + "-" + ((playerStatNumber % 10)+1));
                            }
                        }
                        playerStatRepository.save(stat);
                        PlayerStat newPlayerStat = playerStatRepository.findPlayerStatByPlayer(playerSaved);
                        List<Building> buildings = buildingRepository.findAll();
                        PlayerHasBuilding playerHasBuilding = new PlayerHasBuilding();
                        for (Building building : buildings) {
                            playerHasBuilding.setBuildingId(building.getId_building());
                            playerHasBuilding.setPlayerStatId(newPlayerStat.getId_player_stat());
                            playerHasBuildingRepository.save(playerHasBuilding);
                        }
                        List<Technology> technologies = technologyRepository.findAll();
                        PlayerHasTechnology playerHasTechnology = new PlayerHasTechnology();
                        for (Technology technology : technologies) {
                            playerHasTechnology.setTechnologyId(technology.getId_tech());
                            playerHasTechnology.setPlayerStatId(newPlayerStat.getId_player_stat());
                            playerHasTechnologyRepository.save(playerHasTechnology);
                        }
                        List<Unit> units = unitRepository.findAll();
                        PlayerHasUnit playerHasUnit = new PlayerHasUnit();
                        for (Unit unit : units) {
                            playerHasUnit.setUnitId(unit.getId_unit());
                            playerHasUnit.setPlayerStatId(newPlayerStat.getId_player_stat());
                            playerHasUnitRepository.save(playerHasUnit);
                        }
                        return new ResponseEntity<>("Registration OK", HttpStatus.CREATED);
                    }
                    System.out.println("Pseudo not valid");
                    return new ResponseEntity<>("Pseudo not valid", HttpStatus.OK);
                }
                System.out.println("Email not valid");
                return new ResponseEntity<>("Email not valid", HttpStatus.OK);
            }
            System.out.println("Email already exists");
            //return new ResponseEntity<>("{'response': 'Email already exists'}", HttpStatus.OK);
            return ResponseEntity.badRequest().body("Email already exists");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> authentification(@RequestBody Player player) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            player.getEmail(), player.getPassword_player()));
        }
        catch (BadCredentialsException e) {
            throw new Exception("Email ou mot de passe incorrect", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(player.getEmail());
        return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
    }
}
