package com.kronempire.game.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "player_has_technology")
@IdClass(KeyTechnologyPlayer.class)
public class PlayerHasTechnology {

    @Id
    private int playerStatId;

    @Id
    private int technologyId;

    @MapsId("id_player_stat")
    @ManyToOne
    @JoinColumn(name = "id_player_stat")
    private PlayerStat playerStat;

    @MapsId("id_technology")
    @ManyToOne
    @JoinColumn(name = "id_technology")
    private Technology technology;

    @Column(name = "level", length = 5)
    @ColumnDefault(value = "0")
    private int level;

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

    public PlayerStat getPlayerStat() {
        return playerStat;
    }

    public void setPlayerStat(PlayerStat playerStat) {
        this.playerStat = playerStat;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
