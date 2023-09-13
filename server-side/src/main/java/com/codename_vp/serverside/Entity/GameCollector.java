package com.codename_vp.serverside.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class GameCollector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String platform;
    private String price;
    private String imgUrl;

    public GameCollector(String name, String description, String platform, String price, String imgUrl) {

        this.name = name;
        this.description = description;
        this.platform = platform;
        this.price = price;
        this.imgUrl = imgUrl;

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameCollector id(Long id) {
        setId(id);
        return this;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameCollector name(String name) {
        setName(name);
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GameCollector description(String description) {
        setDescription(description);
        return this;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public GameCollector platform(String platform) {
        setPlatform(platform);
        return this;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public GameCollector price(String price) {
        setPrice(price);
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public GameCollector() {
    }
}
