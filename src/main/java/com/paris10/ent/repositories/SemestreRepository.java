package com.paris10.ent.repositories;

import com.paris10.ent.entities.Semestre;
import com.paris10.ent.entities.UE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ranox on 05/05/17.
 */
public interface SemestreRepository extends JpaRepository<Semestre, Long>
{
    Semestre findById(long id);
    List<Semestre> findAll();
}