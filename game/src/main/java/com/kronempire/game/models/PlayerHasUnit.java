package com.kronempire.game.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "player_has_unit")
@IdClass(KeyUnitPlayer.class)
public class PlayerHasUnit {

    @Id
    private int playerStatId;

    @Id
    private int unitId;

    @MapsId("id_player_stat")
    @ManyToOne
    @JoinColumn(name = "id_player_stat")
    private PlayerStat playerStat;

    @MapsId("id_unit")
    @ManyToOne
    @JoinColumn(name = "id_unit")
    private Unit unit;

    @Column(name = "quantity", length = 10)
    @ColumnDefault(value = "0")
    private int quantity;

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

    public PlayerStat getPlayerStat() {
        return playerStat;
    }

    public void setPlayerStat(PlayerStat playerStat) {
        this.playerStat = playerStat;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
