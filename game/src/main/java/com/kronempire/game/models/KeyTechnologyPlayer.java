package com.kronempire.game.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyTechnologyPlayer implements Serializable {

    @Column(name = "id_player_stat")
    private int playerStatId;

    @Column(name = "id_tech")
    private int technologyId;

    public int getPlayerStatId() {
        return playerStatId;
    }

    public void setPlayerStatId(int playerStatId) {
        this.playerStatId = playerStatId;
    }

    public int getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(int technologyId) {
        this.technologyId = technologyId;
    }
}
