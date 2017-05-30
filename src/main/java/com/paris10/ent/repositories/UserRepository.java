package com.paris10.ent.repositories;

import com.paris10.ent.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by ranox on 04/05/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findById(long id);
    User findByEmail(String email);

    @Transactional
    @Modifying
    @Query("Update User u set u.mdp=?2 where u.id=?1")
    int updateUserPasswordById(long id, String newPassword);

//    @Transactional
//    @Modifying
//    @Query("Update User u set u.email=?2, u.file=?3 where u.id=?1")
//    int updateUser(long id, String email, String file);

    @Transactional
    @Modifying
    @Query("Update User u set u.email=?2 where u.id=?1")
    int updateUser(long id, String email);
}
