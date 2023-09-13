package com.codename_vp.serverside.Entity;

import jakarta.persistence.Entity;

@Entity
public class OwnedList extends GameCollector {

    private String status;

    public OwnedList(String name, String description, String platform, String price, String imgUrl) {
        super(name, description, platform, price, imgUrl);
        this.status = "Owned";
    }

    public String getStatus() {
        return status;
    }

    public OwnedList() {

    }
}
