package com.paris10.ent.repositories;

import com.paris10.ent.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by qlassalle on 27/04/2017.
 */
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

//    List<Etudiant> findByPromotionId(Long id);
}