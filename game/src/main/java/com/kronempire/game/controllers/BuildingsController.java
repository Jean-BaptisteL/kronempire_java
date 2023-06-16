package com.kronempire.game.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kronempire.game.models.Building;
import com.kronempire.game.models.BuildingNeedsTechnology;
import com.kronempire.game.repository.BuildingNeedsTechnologyRepository;
import com.kronempire.game.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buildings")
public class BuildingsController {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingNeedsTechnologyRepository buildingNeedsTechnologieRepository;

    @GetMapping("/all")
    public ResponseEntity<Map<String, List>> getAllBuildings() {
        try {
            Map<String, List> datas = new HashMap<>();
            List<Building> buildings = buildingRepository.findAll();
            List<BuildingNeedsTechnology> buildingNeedsTechnologies = buildingNeedsTechnologieRepository.findAll();
            datas.put("buildings", buildings);
            datas.put("buildingNeedsTechnologies", buildingNeedsTechnologies);
            return new ResponseEntity<>(datas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}