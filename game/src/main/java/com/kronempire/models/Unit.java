package com.kronempire.models;


import jakarta.persistence.*;

@Entity
@Table(name = "unit")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_unit;

    @Column(name = "name_unit", nullable = false, length = 25)
    private String name_unit;

    @Column(name = "description_unit", nullable = false)
    private String description_unit;

    @Column(name = "image_unit", nullable = false)
    private String image_unit;

    @Column(name = "metalPrice_unit", nullable = false, length = 10)
    private int metalPrice_unit;

    @Column(name = "woodPrice_unit", nullable = false, length = 10)
    private int woodPrice_unit;

    @Column(name = "manaPrice_unit", nullable = false, length = 10)
    private int manaPrice_unit;

    @Column(name = "kronPrice_unit", nullable = false, length = 10)
    private int kronPrice_unit;

    @Column(name = "buildTime_unit", nullable = false, length = 10)
    private int buildTime_unit;

    @Column(name = "hp_unit", nullable = false, length = 10)
    private int hp_unit;

    @Column(name = "damage_unit", nullable = false, length = 10)
    private int damage_unit;

    @Column(name = "type_unit", nullable = false, length = 2)
    private int type_unit;

    public int getId_unit() {
        return id_unit;
    }

    public void setId_unit(int id_unit) {
        this.id_unit = id_unit;
    }

    public String getName_unit() {
        return name_unit;
    }

    public void setName_unit(String name_unit) {
        this.name_unit = name_unit;
    }

    public String getDescription_unit() {
        return description_unit;
    }

    public void setDescription_unit(String description_unit) {
        this.description_unit = description_unit;
    }

    public String getImage_unit() {
        return image_unit;
    }

    public void setImage_unit(String image_unit) {
        this.image_unit = image_unit;
    }

    public int getMetalPrice_unit() {
        return metalPrice_unit;
    }

    public void setMetalPrice_unit(int metalPrice_unit) {
        this.metalPrice_unit = metalPrice_unit;
    }

    public int getWoodPrice_unit() {
        return woodPrice_unit;
    }

    public void setWoodPrice_unit(int woodPrice_unit) {
        this.woodPrice_unit = woodPrice_unit;
    }

    public int getManaPrice_unit() {
        return manaPrice_unit;
    }

    public void setManaPrice_unit(int manaPrice_unit) {
        this.manaPrice_unit = manaPrice_unit;
    }

    public int getKronPrice_unit() {
        return kronPrice_unit;
    }

    public void setKronPrice_unit(int kronPrice_unit) {
        this.kronPrice_unit = kronPrice_unit;
    }

    public int getBuildTime_unit() {
        return buildTime_unit;
    }

    public void setBuildTime_unit(int buildTime_unit) {
        this.buildTime_unit = buildTime_unit;
    }

    public int getHp_unit() {
        return hp_unit;
    }

    public void setHp_unit(int hp_unit) {
        this.hp_unit = hp_unit;
    }

    public int getDamage_unit() {
        return damage_unit;
    }

    public void setDamage_unit(int damage_unit) {
        this.damage_unit = damage_unit;
    }

    public int getType_unit() {
        return type_unit;
    }

    public void setType_unit(int type_unit) {
        this.type_unit = type_unit;
    }
}
