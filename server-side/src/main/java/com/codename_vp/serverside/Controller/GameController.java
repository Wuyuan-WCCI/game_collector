package com.codename_vp.serverside.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codename_vp.serverside.Entity.Game;
import com.codename_vp.serverside.Service.GameService;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    // Endpoint to get game information by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Game> getGameInfoByName(@PathVariable String name) {
        Game game = gameService.getGameInfoByName(name);
        return ResponseEntity.ok(game);
    }

    // Endpoint to get game information by ID
    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        Game game = gameService.getGameById(id);
        return ResponseEntity.ok(game);
    }

    // Endpoint to list all games
    @GetMapping("/all")
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    // Add other endpoints as needed based on your application requirements
}
