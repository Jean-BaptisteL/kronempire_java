package com.kronempire.models;

import jakarta.persistence.*;

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
    private PlayerStat playerStat;

    @MapsId("id_buiding")
    @ManyToOne
    @JoinColumn(name = "id_buiding")
    private Building building;

    @Column(name = "level", length = 5)
    private int level;
}
