package com.codename_vp.serverside.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codename_vp.serverside.Entity.Game;
import com.codename_vp.serverside.Entity.OwnedList;
import com.codename_vp.serverside.Entity.User;
import com.codename_vp.serverside.Repository.OwnedListRepo;

import jakarta.transaction.Transactional;

@Service
public class OwnedListService {

    @Autowired
    private OwnedListRepo ownedListRepo;

    public void addToOwnedList(OwnedList ownedList) {
        this.ownedListRepo.save(ownedList);
    }

    public OwnedList addToOwnedList(User user, Game game) {
        OwnedList ownedList = new OwnedList();
        ownedList.setUser(user); // Set the user in the WishList
        ownedList.setGame(game);
        ownedListRepo.save(ownedList);
        user.getOwnedLists().add(ownedList);

        return ownedList;
    }

    @Transactional
    public void removeFromOwnedList(int id) {
        this.ownedListRepo.deleteById(id);
    }

    public List<OwnedList> getOwnedList() {
        return this.ownedListRepo.findAll();
    }

    public List<OwnedList> getOwnedListByUserId(Long userId) {
        return ownedListRepo.findByUser_Id(userId);
    }

}
