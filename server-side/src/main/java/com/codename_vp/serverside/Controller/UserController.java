package com.codename_vp.serverside.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codename_vp.serverside.Entity.OwnedList;
import com.codename_vp.serverside.Entity.User;
import com.codename_vp.serverside.Entity.WishList;
import com.codename_vp.serverside.Service.OwnedListService;
import com.codename_vp.serverside.Service.RawgApiService;
import com.codename_vp.serverside.Service.UserService;
import com.codename_vp.serverside.Service.WishListService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    WishListService wishListService;

    @Autowired
    OwnedListService ownedListService;

    @Autowired
    private RawgApiService rawgService;

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = this.userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username/{username}")
    public User getUserByUserName(@PathVariable String username) {
        return this.userService.getUserByUserName(username);
    }

    @GetMapping("/users")
    public List<User> findUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping("/id/{userId}/add-game-to-wish-list/{gameId}")
    public User addGameToWishList(@PathVariable Long userId, @PathVariable Long gameId) {
        return userService.addGameToWishList(userId, gameId);
    }

    @DeleteMapping("/{userId}/wishlist/remove/{wishListId}")
    public User removeFromWishList(@PathVariable Long userId, @PathVariable Long wishListId) {
        return userService.removeFromWishList(userId, wishListId);
    }

    @DeleteMapping("/{userId}/ownedlist/remove/{ownedListId}")
    public User removeFromOwnedList(@PathVariable Long userId, @PathVariable Long ownedListId) {
        return userService.removeFromOwnedList(userId, ownedListId);
    }

    @PostMapping("/{userId}/moveToOwnedList/{wishListId}")
    public User moveFromWishListToOwnedList(@PathVariable Long userId, @PathVariable Long wishListId) {
        return userService.moveFromWishListToOwnedList(userId, wishListId);
    }

    @GetMapping("/check-in-lists/{userId}/{gameId}")
    public ResponseEntity<Map<String, Boolean>> checkGameInLists(
            @PathVariable Long gameId, @PathVariable Long userId) {
        boolean isInWishList = wishListService.isGameInWishList(userId, gameId);
        boolean isInOwnedList = ownedListService.isGameInOwnedList(userId, gameId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("isInWishList", isInWishList);
        response.put("isInOwnedList", isInOwnedList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add-to-wish-list/{gameId}")
    public ResponseEntity<WishList> addToWishList(@PathVariable Long gameId, @RequestParam Long userId) {
        WishList wishList = rawgService.addToWishList(gameId, userId);
        if (wishList != null) {
            System.out.println("Added game to Wish List");
            return ResponseEntity.ok(wishList);

        } else {
            return ResponseEntity.notFound().build(); // Return a 404 Not Found response
        }

    }

    @PostMapping("/add-to-owned-list/{gameId}")
    public ResponseEntity<OwnedList> addToOwnList(@PathVariable Long gameId, @RequestParam Long userId) {
        OwnedList ownedList = rawgService.addToOwnedList(gameId, userId);
        if (ownedList != null) {
            System.out.println("Added game to Owned List");
            return ResponseEntity.ok(ownedList);

        } else {
            return ResponseEntity.notFound().build(); // Return a 404 Not Found response
        }

    }

}
