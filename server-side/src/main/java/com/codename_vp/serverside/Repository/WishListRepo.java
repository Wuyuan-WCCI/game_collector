package com.codename_vp.serverside.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codename_vp.serverside.Entity.WishList;
import java.util.List;

public interface WishListRepo extends JpaRepository<WishList, Long> {
    List<WishList> findByUser_Id(Long id);

}
