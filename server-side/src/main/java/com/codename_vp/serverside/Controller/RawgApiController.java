package com.codename_vp.serverside.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codename_vp.serverside.Entity.OwnedList;
import com.codename_vp.serverside.Entity.WishList;
import com.codename_vp.serverside.Service.RawgApiService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class RawgApiController {

    @Autowired
    private final RawgApiService rawgService;

    public RawgApiController(RawgApiService rawgApiService) {
        this.rawgService = rawgApiService;
    }

    @GetMapping("/game-detail/{gameId}")
    public ResponseEntity<String> getGameDetailById(@PathVariable int gameId) {

        return rawgService.getGameDetailById(gameId);
    }

    @GetMapping("/rawg/search")
    public ResponseEntity<String> searchGameByName(@RequestParam String query) {
        return rawgService.searchGameByName(query);
    }

    @GetMapping("/top_games")
    public ResponseEntity<String> getTopGames() {
        return rawgService.getTop10Games();
    }

    @PostMapping("add-to-wish-list/{gameId}")
    public ResponseEntity<WishList> addToWishList(@PathVariable int gameId) {
        WishList wishList = rawgService.addToWishList(gameId);
        if (wishList != null) {
            System.out.println("Add game to Wish List");
            return ResponseEntity.ok(wishList);
            // Return a ResponseEntity with the WishList object
        } else {
            return ResponseEntity.notFound().build(); // Return a 404 Not Found response
        }

    }

    @PostMapping("add-to-owned-list/{gameId}")
    public ResponseEntity<OwnedList> addToOwnList(@PathVariable int gameId) {
        OwnedList ownedList = rawgService.addToOwnedList(gameId);
        return ResponseEntity.ok(ownedList);

    }

}
