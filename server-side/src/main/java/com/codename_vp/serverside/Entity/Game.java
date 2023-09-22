package com.codename_vp.serverside.Entity;

import jakarta.persistence.Column;

import jakarta.persistence.Id;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Game {
    @Id
    private int id;

    private String name;
    private String slug;

    private String price;
    private String imgUrl;

    private String released;
    private String officialSite;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Game(String name, String description, String price, String imgUrl) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game id(int id) {
        setId(id);
        return this;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game name(String name) {
        setName(name);
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Game description(String description) {
        setDescription(description);
        return this;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Game price(String price) {
        setPrice(price);
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getOfficialSite() {
        return officialSite;
    }

    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }

    public Game() {
    }

}
