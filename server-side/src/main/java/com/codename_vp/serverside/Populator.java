package com.codename_vp.serverside;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.codename_vp.serverside.Entity.Game;
import com.codename_vp.serverside.Entity.OwnedList;
import com.codename_vp.serverside.Entity.Platform;
import com.codename_vp.serverside.Entity.User;
import com.codename_vp.serverside.Repository.GameRepo;
import com.codename_vp.serverside.Repository.UserRepo;

@Component
public class Populator implements CommandLineRunner {

    public void run(String... args) throws Exception {

        System.out.println("\n================== GAMES ==================\n");

        System.out.println("\n================== Wish List ==================\n");

    }
}
