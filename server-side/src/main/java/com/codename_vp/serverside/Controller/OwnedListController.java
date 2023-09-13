package com.codename_vp.serverside.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codename_vp.serverside.Entity.OwnedList;
import com.codename_vp.serverside.Service.OwnedListService;

@RestController
public class OwnedListController {

    @Autowired
    OwnedListService ownedListService;

    @PostMapping("/owned-list/new")
    public void addGameList(@RequestBody OwnedList ownedList) {
        this.ownedListService.addToOwnedList(ownedList);
    }

    @GetMapping("/owned-list")
    public List<OwnedList> getOwnedList() {
        return this.ownedListService.getOwnedList();
    }

    @DeleteMapping("owned-list/delete/{id}")
    public void removeFromOwnedList(@PathVariable Long id) {
        this.ownedListService.removeFromOwnedList(id);
    }

}
