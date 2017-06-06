package com.paris10.ent.repositories;

import com.paris10.ent.entities.Fichier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichierRepository extends JpaRepository<Fichier, Long> {

    @Query("SELECT f FROM Fichier f, Matiere m WHERE f.matiere.id = m.id AND m.id = ?1")
    List<Fichier> findByMatiereId(Long id);
}
