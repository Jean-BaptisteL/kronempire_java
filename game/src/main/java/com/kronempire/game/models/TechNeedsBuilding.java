package com.kronempire.game.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tech_needs_building")
@IdClass(KeyTechBuilding.class)
public class TechNeedsBuilding {

    @Id
    private int technologyId;

    @Id
    private int buildingId;

    @MapsId("id_tech")
    @ManyToOne
    @JoinColumn(name = "id_tech")
    private Technology technology;

    @MapsId("id_building")
    @ManyToOne
    @JoinColumn(name = "id_building")
    private Building building;

    @Column(name = "level", length = 10)
    private int level;
}
