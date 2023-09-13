package com.codename_vp.serverside;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.codename_vp.serverside.Entity.WishList;
import com.codename_vp.serverside.Repository.WishListRepo;

@Component
public class Populator implements CommandLineRunner {

    @Autowired
    private WishListRepo wishListRepo;

    public void run(String... args) throws Exception {
        System.out.println("Hello Populator");
        WishList Danasty = new WishList("Warrior", null, "PS5", null, null);
        wishListRepo.save(Danasty);
        List<WishList> wishList = wishListRepo.findAll();
        if (wishList.isEmpty()) {
            System.out.println("The Wish List is empty");
        } else {
            for (WishList game : wishList) {
                System.out.println(game.getName() + " ID: " + game.getId() + "Status: " + game.getStatus());
            }
        }

    }

}
