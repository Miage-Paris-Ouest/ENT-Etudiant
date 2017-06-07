package com.paris10.ent.repositories;

import com.paris10.ent.entities.Etudiant;
import com.paris10.ent.entities.Fichier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ranox on 07/06/17.
 */
public interface FichierRepository extends JpaRepository<Fichier, Long>
{
    @Query("SELECT f FROM Fichier f WHERE f.id_matiere = ?1")
    List<Fichier> findByIdMatiere(long id);
}
