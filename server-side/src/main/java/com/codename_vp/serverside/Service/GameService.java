package com.codename_vp.serverside.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codename_vp.serverside.Entity.Game;
import com.codename_vp.serverside.Entity.User;
import com.codename_vp.serverside.Repository.GameRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GameService {

    @Autowired
    private GameRepo gameRepo;

    public Game getGameInfoByName(String name) {
        return gameRepo.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found"));
    }

    public Game getGameById(Long id) {
        return this.gameRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game ID not found"));
    }

    public List<Game> getAllGames() {
        return this.gameRepo.findAll();
    }

}
