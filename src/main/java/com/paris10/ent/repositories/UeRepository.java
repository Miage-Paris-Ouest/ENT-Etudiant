package com.paris10.ent.repositories;

import com.paris10.ent.entities.Matiere;
import com.paris10.ent.entities.UE;
import com.paris10.ent.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ranox on 04/05/17.
 */
@Repository
public interface UeRepository extends JpaRepository<UE, Long>
{
    UE findById(long id);
    List<UE> findAll();
}