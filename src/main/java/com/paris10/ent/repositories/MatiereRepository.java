package com.paris10.ent.repositories;

import com.paris10.ent.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatiereRepository extends JpaRepository<Matiere, Long>{
//    List<Matiere> findByUeId(Long ueId);

    Matiere findById(Long id);

    @Query("SELECT m FROM Matiere  m, UE u WHERE m.ue.id = u.id AND u.id = ?1")
    List<Matiere> findByUeId(long id);
}
