package com.kronempire.game.models;

import jakarta.persistence.*;

@Entity
@Table(name = "unit_nedds_techn")
@IdClass(KeyUnitTechnology.class)
public class UnitNeedsTechnology {

    @Id
    private int unitId;

    @Id
    private int technologyId;


    @MapsId("id_unit")
    @ManyToOne
    @JoinColumn(name = "id_unit")
    private Unit unit;

    @MapsId("id_technology")
    @ManyToOne
    @JoinColumn(name = "id_technology")
    private Technology technology;

    @Column(name = "level", length = 10)
    private int level;

}
