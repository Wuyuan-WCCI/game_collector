package com.codename_vp.serverside.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codename_vp.serverside.Entity.OwnedList;

public interface OwnedListRepo extends JpaRepository<OwnedList, Integer> {
    List<OwnedList> findByUser_Id(Long id);
}
