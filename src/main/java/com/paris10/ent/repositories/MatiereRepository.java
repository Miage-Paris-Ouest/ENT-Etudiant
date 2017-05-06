package com.paris10.ent.repositories;

import com.paris10.ent.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ranox on 04/05/17.
 */
public interface MatiereRepository extends JpaRepository<Matiere, Long>
{
//    @Query("SELECT m FROM Matiere m where m.ue = :id")
//    List<Matiere> findByUe(@Param("id") int id);
    List<Matiere> findByUe(@Param("id") int id);

    List<Matiere> findAll();
}
