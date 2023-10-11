package com.codename_vp.serverside.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Game {
    @Id
    private Long id;

    private String name;

    private String slug;

    private String genre;

    private String status;

    private String imgUrl;

    private String released;

    private String officialSite;

    private String platform;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "game_platform", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "platform_id"))
    private Set<Platform> platforms = new HashSet<>();

    public Game(Long id, String name, String imgUrl, String platform, String description) {

        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.platform = platform;
        this.id = id;

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game id(Long id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Set<Platform> platforms) {
        this.platforms = platforms;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Game() {
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", Name ='" + name + '\'' +
                ", Slug=" + slug +
                ", Genre='" + genre + '\'' +
                ", Platform='" + platform + '\'' +
                ", Description" + description +
                '}';
    }

}
