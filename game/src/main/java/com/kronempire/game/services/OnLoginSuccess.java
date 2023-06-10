package com.kronempire.game.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class OnLoginSuccess {

    // want to load playerStat, playerHasBuildings, playerHasEvents?, playerHasMessage?, playerHasTech,
    @GetMapping("/player/loginSuccess")
    public void loadEverything() {

    }
}
