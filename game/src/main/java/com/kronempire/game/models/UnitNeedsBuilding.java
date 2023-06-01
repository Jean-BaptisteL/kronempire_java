package com.kronempire.game.models;

import jakarta.persistence.*;

@Entity
@Table(name = "unit_needs_building")
@IdClass(KeyUnitTechnology.class)
public class UnitNeedsBuilding {
    @Id
    private int unitId;

    @Id
    private int buildingId;

    @MapsId("id_unit")
    @ManyToOne
    @JoinColumn(name = "id_unit")
    private Unit unit;

    @MapsId("id_building")
    @ManyToOne
    @JoinColumn(name = "id_building")
    private Building building;

    @Column(name = "level", length = 10)
    private int level;
}
