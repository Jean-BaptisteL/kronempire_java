package com.kronempire.game.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyTechBuilding implements Serializable {

    @Column(name = "id_tech")
    private int technologyId;

    @Column(name = "id_building")
    private int buildingId;

    public int getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(int techId) {
        this.technologyId = techId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }
}
