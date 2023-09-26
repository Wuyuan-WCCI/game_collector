package com.codename_vp.serverside.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;
    private String password;

    private List<Integer> ownedGames = new ArrayList<Integer>();
    private List<Integer> wishedGames = new ArrayList<Integer>();

    // Constructors
    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public User() {

    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public List<Integer> getOwned() {
        return this.ownedGames;
    }

    public List<Integer> getWished() {
        return this.wishedGames;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOwned(List<Integer> list) {
        this.ownedGames = list;
    }

    public void setWished(List<Integer> list) {
        this.wishedGames = list;
    }
}
