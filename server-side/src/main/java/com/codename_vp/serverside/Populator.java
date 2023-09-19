package com.codename_vp.serverside;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.codename_vp.serverside.Entity.OwnedList;
import com.codename_vp.serverside.Entity.Platform;
import com.codename_vp.serverside.Entity.WishList;
import com.codename_vp.serverside.Repository.OwnedListRepo;
import com.codename_vp.serverside.Repository.WishListRepo;

@Component
public class Populator implements CommandLineRunner {

    @Autowired
    private WishListRepo wishListRepo;

    @Autowired
    private OwnedListRepo ownedListRepo;

    public void run(String... args) throws Exception {

        Set<Platform> platforms = new HashSet<Platform>();

        System.out.println("Hello Populator\n");

        WishList Danasty = new WishList("Warrior", null, null, null, platforms);
        Danasty.setId(2);
        wishListRepo.save(Danasty);

        WishList danasty1 = new WishList("Ninja", null, null, null, platforms);
        danasty1.setId(1);
        wishListRepo.save(danasty1);

        List<WishList> wishList = wishListRepo.findAll();
        if (wishList.isEmpty()) {
            System.out.println("The Wish List is empty");
        } else {
            for (WishList game : wishList) {
                System.out.println(
                        "Game Name: " + game.getName() + " ID: " + game.getId() + " Status: " + game.getStatus()
                                + "Platforms: " + game.getPlatforms());
            }
        }

        OwnedList newGame = new OwnedList("Mario", null, null, null, platforms);
        newGame.setId(3);
        ownedListRepo.save(newGame);

        OwnedList newGame2 = new OwnedList("Final Fantasy", null, null, null, platforms);
        newGame2.setId(52);
        ownedListRepo.save(newGame2);
        List<OwnedList> ownedList = ownedListRepo.findAll();
        if (ownedList.isEmpty()) {
            System.out.println("The Wish List is empty");
        } else {
            for (OwnedList game : ownedList) {
                System.out.println(
                        "Game Name: " + game.getName() + " ID: " + game.getId() + " Status: " + game.getStatus()
                                + "Platforms: " + game.getPlatforms());
            }
        }

    }

}
