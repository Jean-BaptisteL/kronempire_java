package com.kronempire.game.services;

import com.kronempire.game.models.Player;
import com.kronempire.game.models.PlayerStat;

public interface PlayerStatService {
    public PlayerStat getPlayerStatByPlayer(Player player);

    public PlayerStat savePlayerStat(PlayerStat playerStat);
}
