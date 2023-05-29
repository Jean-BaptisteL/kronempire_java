package com.kronempire.game.models;

import jakarta.persistence.*;

@Entity
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_building;

    @Column(name = "name_building", nullable = false, length = 25)
    private String name_building;

    @Column(name = "description_building", nullable = false)
    private String description_building;

    @Column(name = "image_building", nullable = false)
    private String image_building;

    @Column(name = "metal_price_building", nullable = false, length = 10)
    private int metalPrice_building;

    @Column(name = "wood_price_building", nullable = false, length = 10)
    private int woodPrice_building;

    @Column(name = "mana_price_building", nullable = false, length = 10)
    private int manaPrice_building;

    @Column(name = "kron_price_building", nullable = false, length = 10)
    private int kronPrice_building;

    @Column(name = "build_time_building", nullable = false, length = 10)
    private int buildTime_building;

    @Column(name = "level_factor_building", nullable = false, length = 5)
    private int levelFactor_building;

    @Column(name = "time_factor_building", nullable = false, length = 5)
    private int timeFactor_building;

    @Column(name = "price_factor_building", nullable = false, length = 5)
    private int priceFactor_building;

    @Column(name = "minimum_pop_building", nullable = false, length = 10)
    private int minimumPop_building;

    public int getId_building() {
        return id_building;
    }

    public void setId_building(int id_building) {
        this.id_building = id_building;
    }

    public String getName_building() {
        return name_building;
    }

    public void setName_building(String name_building) {
        this.name_building = name_building;
    }

    public String getDescription_building() {
        return description_building;
    }

    public void setDescription_building(String description_building) {
        this.description_building = description_building;
    }

    public String getImage_building() {
        return image_building;
    }

    public void setImage_building(String image_building) {
        this.image_building = image_building;
    }

    public int getMetalPrice_building() {
        return metalPrice_building;
    }

    public void setMetalPrice_building(int metalPrice_building) {
        this.metalPrice_building = metalPrice_building;
    }

    public int getWoodPrice_building() {
        return woodPrice_building;
    }

    public void setWoodPrice_building(int woodPrice_building) {
        this.woodPrice_building = woodPrice_building;
    }

    public int getManaPrice_building() {
        return manaPrice_building;
    }

    public void setManaPrice_building(int manaPrice_building) {
        this.manaPrice_building = manaPrice_building;
    }

    public int getKronPrice_building() {
        return kronPrice_building;
    }

    public void setKronPrice_building(int kronPrice_building) {
        this.kronPrice_building = kronPrice_building;
    }

    public int getBuildTime_building() {
        return buildTime_building;
    }

    public void setBuildTime_building(int buildTime_building) {
        this.buildTime_building = buildTime_building;
    }

    public int getLevelFactor_building() {
        return levelFactor_building;
    }

    public void setLevelFactor_building(int levelFactor_building) {
        this.levelFactor_building = levelFactor_building;
    }

    public int getTimeFactor_building() {
        return timeFactor_building;
    }

    public void setTimeFactor_building(int timeFactor_building) {
        this.timeFactor_building = timeFactor_building;
    }

    public int getPriceFactor_building() {
        return priceFactor_building;
    }

    public void setPriceFactor_building(int priceFactor_building) {
        this.priceFactor_building = priceFactor_building;
    }

    public int getMinimumPop_building() {
        return minimumPop_building;
    }

    public void setMinimumPop_building(int minimumPop_building) {
        this.minimumPop_building = minimumPop_building;
    }
}
