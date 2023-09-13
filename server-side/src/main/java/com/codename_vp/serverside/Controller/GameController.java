package com.codename_vp.serverside.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codename_vp.serverside.Entity.Game;
import com.codename_vp.serverside.Service.GameService;

import java.io.IOException;

import java.util.List;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    private List<Game> games;

    @GetMapping("/games")
    public ResponseEntity<String> getAllGames() throws IOException {
        ResponseEntity<String> response = gameService.getAllGamesFromApi();
        String responseBody = response.getBody();
        games = gameService.parseGamesFromJsonString(responseBody);

        return response;
    }
}
