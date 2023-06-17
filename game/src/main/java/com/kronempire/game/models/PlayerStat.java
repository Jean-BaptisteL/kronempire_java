package com.kronempire.game.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "player_stat")
public class PlayerStat {

    @Id
    @Column(name = "id_player_stat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_player_stat;

    @Column(name = "score_player_stat", nullable = false, length = 10)
    @ColumnDefault("0")
    private int score_player_stat;

    @Column(name = "metal_quantity_player_stat", nullable = false, length = 100)
    @ColumnDefault("0")
    private int metalQuantity_player_stat;

    @Column(name = "wood_quantity_player_stat", nullable = false, length = 100)
    @ColumnDefault("0")
    private int woodQuantity_player_stat;

    @Column(name = "mana_quantity_player_stat", nullable = false, length = 100)
    @ColumnDefault("0")
    private int manaQuantity_player_stat;

    @Column(name = "kron_quantity_player_stat", nullable = false, length = 100)
    @ColumnDefault("0")
    private int kronQuantity_player_stat;

    @Column(name = "pop_quantity_player_stat", nullable = false, length = 100)
    @ColumnDefault("100")
    private int popQuantity_player_stat;

    @Column(name = "moral_player_stat", nullable = false, length = 3)
    @ColumnDefault("50")
    private int moral_player_stat;

    @Column(name = "devotion_player_stat", nullable = false, length = 3)
    @ColumnDefault("50")
    private int devotion_player_stat;

    @Column(name = "victory_cnt_player_stat", nullable = false, length = 10)
    @ColumnDefault("0")
    private int victoryCnt_player_stat;

    @Column(name = "defeat_cnt_player_stat", nullable = false, length = 10)
    @ColumnDefault("0")
    private int defeatCnt_player_stat;

    @Column(name = "coordinates_player_stat", nullable = false, length = 10)
    private String coordinates_player_stat;

    @ManyToOne
    @JoinColumn(name = "id_player")
    @JsonIgnore
    private Player player;

    @OneToMany(mappedBy = "playerStat")
    @JsonIgnore
    private List<PlayerHasBuilding> buildings;

    @OneToMany(mappedBy = "playerStat")
    @JsonIgnore
    private List<PlayerHasTechnology> technologies;

    @Column(name = "buildInProgress_player_stat")
    private Boolean buildInProgress;

    @Column(name = "technoInProgress_player_stat")
    private Boolean technoInProgress;

    @Column(name = "unitsInProgress_player_stat")
    private Boolean unitsInProgress;

    @Column(name = "eventInProgress_player_stat")
    private Boolean eventInProgress;

    public int getId_player_stat() {
        return id_player_stat;
    }

    public void setId_player_stat(int id_player_stat) {
        this.id_player_stat = id_player_stat;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player_id) {
        this.player = player_id;
    }

    public int getScore_player_stat() {
        return score_player_stat;
    }

    public void setScore_player_stat(int score_player_stat) {
        this.score_player_stat = score_player_stat;
    }

    public int getMetalQuantity_player_stat() {
        return metalQuantity_player_stat;
    }

    public void setMetalQuantity_player_stat(int metalQuantity_player_stat) {
        this.metalQuantity_player_stat = metalQuantity_player_stat;
    }

    public int getWoodQuantity_player_stat() {
        return woodQuantity_player_stat;
    }

    public void setWoodQuantity_player_stat(int woodQuantity_player_stat) {
        this.woodQuantity_player_stat = woodQuantity_player_stat;
    }

    public int getManaQuantity_player_stat() {
        return manaQuantity_player_stat;
    }

    public void setManaQuantity_player_stat(int manaQuantity_player_stat) {
        this.manaQuantity_player_stat = manaQuantity_player_stat;
    }

    public int getKronQuantity_player_stat() {
        return kronQuantity_player_stat;
    }

    public void setKronQuantity_player_stat(int kronQuantity_player_stat) {
        this.kronQuantity_player_stat = kronQuantity_player_stat;
    }

    public int getPopQuantity_player_stat() {
        return popQuantity_player_stat;
    }

    public void setPopQuantity_player_stat(int popQuantity_player_stat) {
        this.popQuantity_player_stat = popQuantity_player_stat;
    }

    public int getMoral_player_stat() {
        return moral_player_stat;
    }

    public void setMoral_player_stat(int moral_player_stat) {
        this.moral_player_stat = moral_player_stat;
    }

    public int getDevotion_player_stat() {
        return devotion_player_stat;
    }

    public void setDevotion_player_stat(int devotion_player_stat) {
        this.devotion_player_stat = devotion_player_stat;
    }

    public int getVictoryCnt_player_stat() {
        return victoryCnt_player_stat;
    }

    public void setVictoryCnt_player_stat(int victoryCnt_player_stat) {
        this.victoryCnt_player_stat = victoryCnt_player_stat;
    }

    public int getDefeatCnt_player_stat() {
        return defeatCnt_player_stat;
    }

    public void setDefeatCnt_player_stat(int defeatCnt_player_stat) {
        this.defeatCnt_player_stat = defeatCnt_player_stat;
    }

    public String getCoordinates_player_stat() {
        return coordinates_player_stat;
    }

    public void setCoordinates_player_stat(String coordinates_player_stat) {
        this.coordinates_player_stat = coordinates_player_stat;
    }

    public List<PlayerHasBuilding> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<PlayerHasBuilding> buildings) {
        this.buildings = buildings;
    }

    public boolean isBuildInProgress() {
        return buildInProgress;
    }

    public void setBuildInProgress(boolean buildInProgress) {
        this.buildInProgress = buildInProgress;
    }

    public boolean isTechnoInProgress() {
        return technoInProgress;
    }

    public void setTechnoInProgress(boolean technoInProgress) {
        this.technoInProgress = technoInProgress;
    }

    public boolean isUnitsInProgress() {
        return unitsInProgress;
    }

    public void setUnitsInProgress(boolean unitsInProgress) {
        this.unitsInProgress = unitsInProgress;
    }

    public boolean isEventInProgress() {
        return eventInProgress;
    }

    public void setEventInProgress(boolean eventInProgress) {
        this.eventInProgress = eventInProgress;
    }

    public List<PlayerHasTechnology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<PlayerHasTechnology> technologies) {
        this.technologies = technologies;
    }
}
