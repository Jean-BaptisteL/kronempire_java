package com.kronempire.game.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "player_has_building")
@IdClass(KeyBuildingPlayer.class)
public class PlayerHasBuilding {

    @Id
    private int playerStatId;

    @Id
    private int buildingId;

    @MapsId("id_player_stat")
    @ManyToOne
    @JoinColumn(name = "id_player_stat")
    @JsonIgnore
    private PlayerStat playerStat;

    @MapsId("id_building")
    @ManyToOne
    @JoinColumn(name = "id_building")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_building")
    private Building building;

    @Column(name = "level", length = 5)
    @ColumnDefault(value = "0")
    private int level;

    public int getPlayerStatId() {
        return playerStatId;
    }

    public void setPlayerStatId(int playerStatId) {
        this.playerStatId = playerStatId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public PlayerStat getPlayerStat() {
        return playerStat;
    }

    public void setPlayerStat(PlayerStat playerStat) {
        this.playerStat = playerStat;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
