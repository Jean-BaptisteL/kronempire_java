package com.kronempire.game.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyUnitPlayer implements Serializable {

    @Column(name = "id_player_stat")
    private int playerStatId;

    @Column(name = "id_unit")
    private int unitId;

    public int getPlayerStatId() {
        return playerStatId;
    }

    public void setPlayerStatId(int playerStatId) {
        this.playerStatId = playerStatId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }
}
