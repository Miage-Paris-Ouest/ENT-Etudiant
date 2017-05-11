package com.paris10.ent.repositories;

import com.paris10.ent.entities.Etudiant;
import com.paris10.ent.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ranox on 04/05/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findById(long id);
}
