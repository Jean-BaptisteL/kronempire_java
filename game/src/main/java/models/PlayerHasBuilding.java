package models;

import jakarta.persistence.*;

@Entity
@Table(name = "player_has_building")
public class PlayerHasBuilding {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_player_stat")
    private Player_Stat playerStat;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_buiding")
    private Building building;

    @Column(name = "level", length = 5)
    private int level;

    public Player_Stat getPlayerStat() {
        return playerStat;
    }

    public void setPlayerStat(Player_Stat playerStat) {
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
