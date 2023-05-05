package com.kronempire.models;

import jakarta.persistence.*;

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
    private int quantity;
}
