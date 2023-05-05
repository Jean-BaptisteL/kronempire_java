package com.kronempire.models;

import jakarta.persistence.*;

@Entity
@Table(name = "building_needs_techn")
@IdClass(KeyBuildingTechnology.class)
public class BuildingNeedsTechnology {

    @Id
    private int buildingId;

    @Id
    private int technologyId;

    @MapsId("id_building")
    @ManyToOne
    @JoinColumn(name = "id_buiding")
    private Building building;

    @MapsId("id_technology")
    @ManyToOne
    @JoinColumn(name = "id_technology")
    private Technology technology;

    @Column(name = "level", length = 10)
    private int level;
}
