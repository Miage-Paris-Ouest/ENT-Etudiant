package com.paris10.ent.repositories;

import com.paris10.ent.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

    @Query("SELECT '*' FROM Enseignant WHERE enseignant_id_user = ?1")
    Enseignant findByEnseignantIdUser(Long id);
}