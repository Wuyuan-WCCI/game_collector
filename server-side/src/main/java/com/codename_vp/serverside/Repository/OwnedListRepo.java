package com.codename_vp.serverside.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codename_vp.serverside.Entity.OwnedList;

public interface OwnedListRepo extends JpaRepository<OwnedList, Integer> {

}
