package com.codename_vp.serverside.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codename_vp.serverside.Entity.WishList;

public interface WishListRepo extends JpaRepository<WishList, Integer> {

    Optional<WishList> findByName(String name);

    Optional<WishList> removeByName(String name);
}
