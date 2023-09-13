package com.codename_vp.serverside.Entity;

import jakarta.persistence.Entity;

@Entity
public class Game extends GameCollector {

    private String slug;

    private String status;

    public Game(String name, String description, String platform, String price, String imgUrl) {
        super(name, description, platform, price, imgUrl);
        this.status = "null";
    }

    public String getStatus() {
        return status;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Game() {

    }
}
