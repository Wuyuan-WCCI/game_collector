package com.codename_vp.serverside.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codename_vp.serverside.Entity.Platform;
import com.codename_vp.serverside.Repository.PlatformRepo;

import jakarta.transaction.Transactional;

@Service
public class PlatformService {

    @Autowired
    private PlatformRepo platformRepo;

    public void addPlatform(Platform platform) {
        this.platformRepo.save(platform);
    }

    @Transactional
    public void removePlatform(int id) {
        this.platformRepo.deleteById(id);
    }

    public Platform getPlatformById(int id) {
        return this.platformRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game ID not found"));
    }

    public List<Platform> getPlatforms() {
        return this.platformRepo.findAll();
    }

}
