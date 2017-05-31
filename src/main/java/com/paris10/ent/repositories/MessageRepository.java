package com.paris10.ent.repositories;

import com.paris10.ent.entities.Etudiant;
import com.paris10.ent.entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qlassalle on 27/04/2017.
 */
@Repository
public interface MessageRepository extends JpaRepository<Messages, Long> {

    List<Messages>  findAll();
}