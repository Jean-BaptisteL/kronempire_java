package com.kronempire.game.models;

import jakarta.persistence.*;

@Entity
@Table(name = "building_need_tech")
@IdClass(KeyBuildingTechnology.class)
public class BuildingNeedsTechnology {

    @Id
    private int buildingId;

    @Id
    private int technologyId;

    @MapsId("id_building")
    @ManyToOne
    @JoinColumn(name = "id_building")
    private Building building;

    @MapsId("id_technology")
    @ManyToOne
    @JoinColumn(name = "id_tech")
    private Technology technology;

    @Column(name = "level", length = 10)
    private int level;

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
