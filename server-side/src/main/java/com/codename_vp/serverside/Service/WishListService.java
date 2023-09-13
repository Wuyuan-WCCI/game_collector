package com.codename_vp.serverside.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codename_vp.serverside.Entity.WishList;
import com.codename_vp.serverside.Repository.WishListRepo;

import jakarta.transaction.Transactional;

@Service
public class WishListService {

    @Autowired
    private WishListRepo wishListRepo;

    public void addToWishList(WishList wishList) {
        this.wishListRepo.save(wishList);
    }

    @Transactional
    public void removeFromWishList(Long id) {
        this.wishListRepo.deleteById(id);
    }

    public WishList getGameInfoByName(String name) {
        return wishListRepo.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found"));
    }

    public WishList getGameById(Long id) {
        return this.wishListRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game ID not found"));
    }

    public List<WishList> getWishList() {
        return this.wishListRepo.findAll();
    }

}
