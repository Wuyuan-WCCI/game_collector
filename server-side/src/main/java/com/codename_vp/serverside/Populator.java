package com.codename_vp.serverside;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.codename_vp.serverside.Entity.OwnedList;
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

        System.out.println("Hello Populator\n");

        WishList Danasty = new WishList("Warrior", null, "PS5", null, null);
        Danasty.setId(2);
        wishListRepo.save(Danasty);

        WishList danasty1 = new WishList("Ninja", null, "PS5", null, null);
        danasty1.setId(1);
        wishListRepo.save(danasty1);
        List<WishList> wishList = wishListRepo.findAll();
        if (wishList.isEmpty()) {
            System.out.println("The Wish List is empty");
        } else {
            for (WishList game : wishList) {
                System.out.println(
                        "Game Name: " + game.getName() + " ID: " + game.getId() + " Status: " + game.getStatus());
            }
        }

        OwnedList newGame = new OwnedList("Mario", null, "PS5", null, null);
        newGame.setId(3);
        ownedListRepo.save(newGame);

        OwnedList newGame2 = new OwnedList("Final Fantasy", null, "PS5", null, null);
        newGame2.setId(4);
        ownedListRepo.save(newGame2);
        List<OwnedList> ownedList = ownedListRepo.findAll();
        if (ownedList.isEmpty()) {
            System.out.println("The Wish List is empty");
        } else {
            for (OwnedList game : ownedList) {
                System.out.println(
                        "Game Name: " + game.getName() + " ID: " + game.getId() + " Status: " + game.getStatus());
            }
        }

    }

}
