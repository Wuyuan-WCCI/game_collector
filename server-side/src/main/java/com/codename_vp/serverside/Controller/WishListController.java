package com.codename_vp.serverside.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codename_vp.serverside.Entity.WishList;
import com.codename_vp.serverside.Service.WishListService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class WishListController {

    @Autowired
    WishListService wishListService;

    @PostMapping("/wish-list/new")
    public void addGameList(@RequestBody WishList wishList) {
        this.wishListService.addToWishList(wishList);
    }

    @GetMapping("/wish-list")
    public List<WishList> getWishList() {
        return this.wishListService.getWishList();
    }

    @DeleteMapping("Wish-list/delete/{id}")
    public void removeFromWishList(@PathVariable int id) {
        this.wishListService.removeFromWishList(id);
    }

}
