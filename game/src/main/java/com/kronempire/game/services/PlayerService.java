package com.kronempire.game.services;

import com.kronempire.game.models.Player;
import com.kronempire.game.models.PlayerStat;

public interface PlayerService {

    public PlayerStat getStatByPlayerEmail(String email);
}
