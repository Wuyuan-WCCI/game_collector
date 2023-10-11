package com.codename_vp.serverside.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codename_vp.serverside.Entity.Game;

public interface GameRepo extends JpaRepository<Game, Long> {
    Optional<Game> findByName(String name);
}
