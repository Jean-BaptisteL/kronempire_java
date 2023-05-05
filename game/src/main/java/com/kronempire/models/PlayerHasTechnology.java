package com.kronempire.models;

import jakarta.persistence.*;

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
    private int level;
}
