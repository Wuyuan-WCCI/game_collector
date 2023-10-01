package com.codename_vp.serverside.Entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class WishList extends Game {

    private String status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_wish_list_id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "wishlist_platform", joinColumns = @JoinColumn(name = "wishlist_id"), inverseJoinColumns = @JoinColumn(name = "platform_id"))
    private Set<Platform> platforms = new HashSet<>();

    public WishList(String name, String description, String price, String imgUrl,
            Set<Platform> platforms) {
        super(name, description, price, imgUrl);
        this.status = "Wished";
        this.platforms = platforms;

    }

    public WishList() {

    }

    public String getStatus() {
        return status;
    }

    public Set<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Set<Platform> platforms) {
        this.platforms = platforms;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nName = " + this.getName() + "\nSlug: " + this.getSlug() + "\nReleaseDate: " + this.getReleased()
                + "\nStatus: "
                + status + "\nDescription: " + this.getDescription() + "\n Image: " + this.getImgUrl();
    }

}
