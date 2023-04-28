package models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "player_stat")
public class Player_Stat {

    @Id
    @Column(name = "id_player_stat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_player_stat;

    @Column(name = "score_player_stat", nullable = false, length = 10)
    private int score_player_stat;

    @Column(name = "metalQuantity_player_stat", nullable = false, length = 100)
    private int metalQuantity_player_stat;

    @Column(name = "woodQuantity_player_stat", nullable = false, length = 100)
    private int woodQuantity_player_stat;

    @Column(name = "manaQuantity_player_stat", nullable = false, length = 100)
    private int manaQuantity_player_stat;

    @Column(name = "kronQuantity_player_stat", nullable = false, length = 100)
    private int kronQuantity_player_stat;

    @Column(name = "popQuantity_player_stat", nullable = false, length = 100)
    private int popQuantity_player_stat;

    @Column(name = "moral_player_stat", nullable = false, length = 3)
    private int moral_player_stat;

    @Column(name = "devotion_player_stat", nullable = false, length = 3)
    private int devotion_player_stat;

    @Column(name = "victoryCnt_player_stat", nullable = false, length = 10)
    private int victoryCnt_player_stat;

    @Column(name = "defeatCnt_player_stat", nullable = false, length = 10)
    private int defeatCnt_player_stat;

    @Column(name = "coordinates_player_stat", nullable = false, length = 10)
    private String coordinates_player_stat;

    @ManyToOne
    @JoinColumn(name = "id_player")
    private Player player;

    @OneToMany(mappedBy = "playerStat")
    private Set<PlayerHasBuilding> buildings;

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

    public Set<PlayerHasBuilding> getBuildings() {
        return buildings;
    }

    public void setBuildings(Set<PlayerHasBuilding> buildings) {
        this.buildings = buildings;
    }
}
