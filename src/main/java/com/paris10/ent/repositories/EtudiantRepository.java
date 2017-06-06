package com.paris10.ent.repositories;

import com.paris10.ent.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>
{
    Etudiant findById(long id);

    @Query("SELECT e FROM Etudiant e WHERE e.id = ?1")
    Etudiant findByEtudiantIdUser(long id);

    List<Etudiant> findByCreditLessThan(int credit);
}