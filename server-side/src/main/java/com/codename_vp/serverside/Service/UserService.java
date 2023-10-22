package com.codename_vp.serverside.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.codename_vp.serverside.Entity.Game;
import com.codename_vp.serverside.Entity.User;
import com.codename_vp.serverside.Entity.WishList;
import com.codename_vp.serverside.Repository.GameRepo;
import com.codename_vp.serverside.Repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private OwnedListService ownedListService;

    @Autowired
    private WishListService wishListService;

    public UserService(UserRepo userRepo, GameRepo gameRepo) {
        this.userRepo = userRepo;
        this.gameRepo = gameRepo;
    }

    public void createUser(User user) {
        this.userRepo.save(user);
    }

    public User getUserById(Long id) {
        return this.userRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found" + id));
    }

    public User getUserByUserName(String userName) {
        return this.userRepo.findByUserName(userName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found" + userName));
    }

    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }

    public User addGameToWishList(Long userId, Long gameId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        Optional<Game> optionalGame = gameRepo.findById(gameId);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();
            Game game = optionalGame.get();

            WishList wishList = new WishList();
            wishList.setGame(game);
            wishList.setUser(user);
            user.getWishLists().add(wishList);
            return userRepo.save(user);
        } else {
            // Handle the case where the user doesn't exist
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
    }

    public User removeFromWishList(Long userId, Long wishListId) {
        Optional<User> optionalUser = userRepo.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println("remove from wishlist User Id: " + user);

            // Find and remove the specific WishList with the given wishListId
            user.getWishLists().removeIf(wishList -> wishList.getId().equals(wishListId));

            // Save the updated user
            return userRepo.save(user);
        } else {
            // Handle the case where the user doesn't exist
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }

    }

    public User removeFromOwnedList(Long userId, Long ownedListId) {
        Optional<User> optionalUser = userRepo.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println("Remove Owned list ID:" + " from User Id: " + user);

            // Find and remove the specific WishList with the given wishListId
            user.getOwnedLists().removeIf(ownedList -> ownedList.getId().equals(ownedListId));

            // Save the updated user
            return userRepo.save(user);
        } else {
            // Handle the case where the user doesn't exist
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }

    }

    public User moveFromWishListToOwnedList(Long userId, Long wishListId) {
        // Find the user by userId
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Find the wish list item by wishListId
            WishList wishListItem = user.getWishLists()
                    .stream()
                    .filter(wl -> wl.getId().equals(wishListId))
                    .findFirst()
                    .orElse(null);

            if (wishListItem == null) {
                throw new IllegalArgumentException("WishList item not found with ID: " + wishListId);
            }

            // Create a new owned list item with the same game
            Game game = wishListItem.getGame();
            ownedListService.addToOwnedList(user, game);

            // Remove the wish list item
            user.getWishLists().remove(wishListItem);

            // Save the updated user
            userRepo.save(user);

            return user;
        } else {
            // Handle the case where the user doesn't exist
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }

    }

    @GetMapping("/check-in-lists/{gameId}")
    public ResponseEntity<Map<String, Boolean>> checkGameInLists(
            @PathVariable Long gameId, @RequestParam Long userId) {
        boolean isInWishList = wishListService.isGameInWishList(userId, gameId);
        boolean isInOwnedList = ownedListService.isGameInOwnedList(userId, gameId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("isInWishList", isInWishList);
        response.put("isInOwnedList", isInOwnedList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
