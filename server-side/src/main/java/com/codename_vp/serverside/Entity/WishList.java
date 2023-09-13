package com.codename_vp.serverside.Entity;

import jakarta.persistence.Entity;

@Entity
public class WishList extends GameCollector {

    private String status;

    public WishList(String name, String description, String platform, String price, String imgUrl) {
        super(name, description, platform, price, imgUrl);
        this.status = "Wished";

    }

    public String getStatus() {
        return status;
    }

    public WishList() {

    }
}
