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
import com.codename_vp.serverside.Entity.User;
import com.codename_vp.serverside.Entity.WishList;
import com.codename_vp.serverside.Repository.OwnedListRepo;
import com.codename_vp.serverside.Repository.UserRepo;
import com.codename_vp.serverside.Repository.WishListRepo;

@Component
public class Populator implements CommandLineRunner {

    @Autowired
    private WishListRepo wishListRepo;

    @Autowired
    private OwnedListRepo ownedListRepo;

    @Autowired
    private UserRepo userRepo;

    public void run(String... args) throws Exception {

        Set<Platform> platforms = new HashSet<Platform>();
        List<User> users = new ArrayList<>();

        System.out.println("Hello Populator\n");

        User user1 = new User(" miketb12 ", " 1234", " miketb12@gmail.com ");
        userRepo.save(user1);
        users.add(0, user1);

        User user2 = new User(" miketb22 ", " 1234", " miketb12@gmail.com ");
        userRepo.save(user2);
        users.add(1, user2);

        User user3 = new User("miketb52 ", " 1234", " miketb12@gmail.com ");
        userRepo.save(user3);
        users.add(2, user3);

        System.out.println("\n================== Wish List ==================\n");

        WishList Danasty = new WishList("Warrior", null, null, null, platforms);
        Danasty.setId(2);
        wishListRepo.save(Danasty);
        user1.getWishLists().add(Danasty);

        WishList danasty1 = new WishList("Ninja", null, null, null, platforms);
        danasty1.setId(1);
        wishListRepo.save(danasty1);
        user1.getWishLists().add(danasty1);

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

        System.out.println("\n================== Owned List ==================\n");

        OwnedList newGame = new OwnedList("Mario", null, null,
                "https://i.etsystatic.com/17317138/r/il/517956/4880965373/il_794xN.4880965373_1l44.jpg", platforms);
        newGame.setId(3);
        ownedListRepo.save(newGame);
        user1.getOwnedLists().add(newGame);

        OwnedList newGame2 = new OwnedList("Final Fantasy", null, null,
                "https://cdn.akamai.steamstatic.com/steam/apps/1173770/header.jpg?t=1646929110", platforms);
        newGame2.setId(52);
        ownedListRepo.save(newGame2);
        List<OwnedList> ownedList = ownedListRepo.findAll();
        if (ownedList.isEmpty()) {
            System.out.println("The Wish List is empty");
        } else {
            for (OwnedList game : ownedList) {
                System.out.println(" ID: " + game.getId() +
                        " Game Name: " + game.getName() + " Status: " + game.getStatus()
                        + " Platforms: " + game.getPlatforms());
            }
        }

        System.out.println("\n================== Users ==================\n");

        for (User user : users) {
            System.out.println(" ID: " + user.getId() +
                    " Username: " + user.getUserName() + " Email: " + user.getEmail()
                    + "\nOwned List: " + user.getOwnedLists() + "\nWish List: "
                    + user.getWishLists());
        }

    }

}
