package com.kronempire.game.models;

import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_event;

    @Column(name = "name_event", nullable = false, length = 25)
    private String name_event;

    @Column(name = "description_event", nullable = false)
    private String description_event;

    @Column(name = "image_event", nullable = false)
    private String image_event;

    @Column(name = "metal_price_event", nullable = false, length = 10)
    private int metalPrice_event;

    @Column(name = "wood_price_event", nullable = false, length = 10)
    private int woodPrice_event;

    @Column(name = "mana_price_event", nullable = false, length = 10)
    private int manaPrice_event;

    @Column(name = "kron_price_event", nullable = false, length = 10)
    private int kronPrice_event;

    @Column(name = "devotion_price_event", nullable = false, length = 10)
    private int devotionPrice_event;

    @Column(name = "moral_price_event", nullable = false, length = 10)
    private int moralPrice_event;

    @Column(name = "life_time_event", nullable = false, length = 10)
    private int lifeTime_event;

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getName_event() {
        return name_event;
    }

    public void setName_event(String name_event) {
        this.name_event = name_event;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public String getImage_event() {
        return image_event;
    }

    public void setImage_event(String image_event) {
        this.image_event = image_event;
    }

    public int getMetalPrice_event() {
        return metalPrice_event;
    }

    public void setMetalPrice_event(int metalPrice_event) {
        this.metalPrice_event = metalPrice_event;
    }

    public int getWoodPrice_event() {
        return woodPrice_event;
    }

    public void setWoodPrice_event(int woodPrice_event) {
        this.woodPrice_event = woodPrice_event;
    }

    public int getManaPrice_event() {
        return manaPrice_event;
    }

    public void setManaPrice_event(int manaPrice_event) {
        this.manaPrice_event = manaPrice_event;
    }

    public int getKronPrice_event() {
        return kronPrice_event;
    }

    public void setKronPrice_event(int kronPrice_event) {
        this.kronPrice_event = kronPrice_event;
    }

    public int getDevotionPrice_event() {
        return devotionPrice_event;
    }

    public void setDevotionPrice_event(int devotionPrice_event) {
        this.devotionPrice_event = devotionPrice_event;
    }

    public int getMoralPrice_event() {
        return moralPrice_event;
    }

    public void setMoralPrice_event(int moralPrice_event) {
        this.moralPrice_event = moralPrice_event;
    }

    public int getLifeTime_event() {
        return lifeTime_event;
    }

    public void setLifeTime_event(int lifeTime_event) {
        this.lifeTime_event = lifeTime_event;
    }
}
