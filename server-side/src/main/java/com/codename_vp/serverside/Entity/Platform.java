package com.codename_vp.serverside.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.transaction.Transactional;

@Entity
@Transactional
public class Platform {
    @Id
    @Column(name = "platform_id")
    private int platformId;

    private String platformName;
    private String slug;
    private String releasedDate;

    public Platform(String slug, String platformName, String releasedDate) {
        this.slug = slug;
        this.platformName = platformName;
        this.releasedDate = releasedDate;

    }

    public Platform() {

    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

}
