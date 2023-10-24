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

    @GetMapping("/game/detail/{gameId}")
    public ResponseEntity<String> getGameDetailById(@PathVariable Long gameId) {

        return rawgService.getGameDetailById(gameId);
    }

    @GetMapping("/game/search")
    public ResponseEntity<String> searchGameByName(@RequestParam String query) {
        return rawgService.searchGameByName(query);
    }

    @GetMapping("/game/top_games")
    public ResponseEntity<String> getTopGames() {
        return rawgService.getTop10Games();
    }

    @GetMapping("/game/new_games")
    public ResponseEntity<String> getNewReleaseGames() {
        return rawgService.getNewReleaseGames();
    }

    @GetMapping("/game/video/{gameId}")
    public ResponseEntity<String> getGameVideo(@PathVariable int gameId) {
        return rawgService.getTrailerVideo(gameId);
    }

}