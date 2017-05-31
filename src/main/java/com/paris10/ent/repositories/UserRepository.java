package com.paris10.ent.repositories;

import com.paris10.ent.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);
    List<User> findAll();
}
