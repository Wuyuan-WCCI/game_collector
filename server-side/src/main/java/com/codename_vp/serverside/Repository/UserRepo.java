package com.codename_vp.serverside.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codename_vp.serverside.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);

}
