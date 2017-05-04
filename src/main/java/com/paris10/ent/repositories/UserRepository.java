package com.paris10.ent.repositories;

import com.paris10.ent.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by qlassalle on 04/05/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);
}
