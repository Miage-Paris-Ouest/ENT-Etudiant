package com.paris10.ent.repositories;

import com.paris10.ent.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

//    List<Etudiant> findByPromotionId(Long id);
}