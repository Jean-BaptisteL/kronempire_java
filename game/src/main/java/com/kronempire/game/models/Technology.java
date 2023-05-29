package com.kronempire.game.models;

import jakarta.persistence.*;

@Entity
@Table(name = "technology")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tech;

    @Column(name = "name_tech", nullable = false, length = 25)
    private String name_tech;

    @Column(name = "description_tech", nullable = false)
    private String description_tech;

    @Column(name = "image_tech", nullable = false)
    private String image_tech;

    @Column(name = "metal_price_tech", nullable = false, length = 10)
    private int metalPrice_tech;

    @Column(name = "wood_price_tech", nullable = false, length = 10)
    private int woodPrice_tech;

    @Column(name = "mana_price_tech", nullable = false, length = 10)
    private int manaPrice_tech;

    @Column(name = "kron_price_tech", nullable = false, length = 10)
    private int kronPrice_tech;

    @Column(name = "build-time_tech", nullable = false, length = 10)
    private int buildTime_tech;

    @Column(name = "level_factor_tech", nullable = false, length = 5)
    private int levelFactor_tech;

    @Column(name = "time_factor_tech", nullable = false, length = 5)
    private int timeFactor_tech;

    @Column(name = "price_factor_tech", nullable = false, length = 5)
    private int priceFactor_tech;

    public int getId_tech() {
        return id_tech;
    }

    public void setId_tech(int id_tech) {
        this.id_tech = id_tech;
    }

    public String getName_tech() {
        return name_tech;
    }

    public void setName_tech(String name_tech) {
        this.name_tech = name_tech;
    }

    public String getDescription_tech() {
        return description_tech;
    }

    public void setDescription_tech(String description_tech) {
        this.description_tech = description_tech;
    }

    public String getImage_tech() {
        return image_tech;
    }

    public void setImage_tech(String image_tech) {
        this.image_tech = image_tech;
    }

    public int getMetalPrice_tech() {
        return metalPrice_tech;
    }

    public void setMetalPrice_tech(int metalPrice_tech) {
        this.metalPrice_tech = metalPrice_tech;
    }

    public int getWoodPrice_tech() {
        return woodPrice_tech;
    }

    public void setWoodPrice_tech(int woodPrice_tech) {
        this.woodPrice_tech = woodPrice_tech;
    }

    public int getManaPrice_tech() {
        return manaPrice_tech;
    }

    public void setManaPrice_tech(int manaPrice_tech) {
        this.manaPrice_tech = manaPrice_tech;
    }

    public int getKronPrice_tech() {
        return kronPrice_tech;
    }

    public void setKronPrice_tech(int kronPrice_tech) {
        this.kronPrice_tech = kronPrice_tech;
    }

    public int getBuildTime_tech() {
        return buildTime_tech;
    }

    public void setBuildTime_tech(int buildTime_tech) {
        this.buildTime_tech = buildTime_tech;
    }

    public int getLevelFactor_tech() {
        return levelFactor_tech;
    }

    public void setLevelFactor_tech(int levelFactor_tech) {
        this.levelFactor_tech = levelFactor_tech;
    }

    public int getTimeFactor_tech() {
        return timeFactor_tech;
    }

    public void setTimeFactor_tech(int timeFactor_tech) {
        this.timeFactor_tech = timeFactor_tech;
    }

    public int getPriceFactor_tech() {
        return priceFactor_tech;
    }

    public void setPriceFactor_tech(int priceFactor_tech) {
        this.priceFactor_tech = priceFactor_tech;
    }
}
