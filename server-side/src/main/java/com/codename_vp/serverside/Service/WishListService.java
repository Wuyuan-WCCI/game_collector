package com.codename_vp.serverside.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codename_vp.serverside.Entity.Game;
import com.codename_vp.serverside.Entity.User;
import com.codename_vp.serverside.Entity.WishList;
import com.codename_vp.serverside.Repository.WishListRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class WishListService {

    @Autowired
    private WishListRepo wishListRepo;

    public List<WishList> getWishListByUserId(Long userId) {
        return wishListRepo.findByUser_Id(userId);
    }

    public WishList addToWishList(User user, Game game) {
        WishList wishList = new WishList();
        wishList.setUser(user); // Set the user in the WishList
        wishList.setGame(game);
        wishListRepo.save(wishList);
        user.getWishLists().add(wishList);

        return wishList;
    }

    @Transactional
    public void removeFromWishList(Long wishListId) {
        wishListRepo.deleteById(wishListId);
    }

    public boolean isGameInWishList(Long userId, Long gameId) {
        // Check if the game with the specified gameId exists in the user's WishList
        // You can implement this by querying your repository or data store
        // Return true if the game exists, otherwise return false
        return wishListRepo.existsByUserIdAndGameId(userId, gameId);
    }

    public Long getWishListIdByGame(Long userId, Long gameId) {
        // Query the wish list repository to find the wish list entry by userId and
        // gameId
        Optional<WishList> wishListEntry = wishListRepo.findByUserIdAndGameId(userId, gameId);

        if (wishListEntry.isPresent()) {
            // If a matching entry is found, return its ID
            return wishListEntry.get().getId();
        } else {
            // If no matching entry is found, return null
            return null;
        }
    }

}
