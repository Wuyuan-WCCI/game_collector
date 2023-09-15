package com.codename_vp.serverside.Controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codename_vp.serverside.Entity.Game;
import com.codename_vp.serverside.Service.RawgApiService;

@RestController
public class RawgApiController {

    private final RawgApiService rawgService;

    @Autowired
    public RawgApiController(RawgApiService rawgApiService) {
        this.rawgService = rawgApiService;
    }

    @GetMapping("/game-detail/{game_id}")
    public ResponseEntity<String> getGameDetail(@PathVariable String game_id) {

        return rawgService.getGameDetail(game_id);
    }

    @GetMapping("/rawg/search")
    public ResponseEntity<String> searchGame(@RequestParam String query) {
        return rawgService.searchGame(query);
    }

}
