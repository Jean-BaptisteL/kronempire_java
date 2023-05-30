package com.kronempire.game.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyBuildingTechnology implements Serializable {

    @Column(name = "id_building")
    private int buildingId;

    @Column(name = "id_tech")
    private int technologyId;

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(int technologyId) {
        this.technologyId = technologyId;
    }
}
