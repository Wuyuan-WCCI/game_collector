package com.codename_vp.serverside.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codename_vp.serverside.Entity.OwnedList;

public interface OwnedListRepo extends JpaRepository<OwnedList, Integer> {
    Optional<OwnedList> findByName(String name);

    Optional<OwnedList> removeByName(String name);
}
