package com.paris10.ent.repositories;

import com.paris10.ent.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    List<Etudiant> findByCreditLessThan(int credit);

    /**
     * Quentin : None of the method below work .. Could be interesting if anyone could see how to fix it, even by googling it
     * I didn't find anything
     */

//    List<Etudiant> findByPromotion_Id(Long id_promotion);

//    List<Etudiant> findByPromotionId(Long id_promotion);

    Etudiant findById(Long id);

    @Query("SELECT e FROM Etudiant e, Promotion p WHERE e.promotion.id = p.id AND p.id = ?1")
    List<Etudiant> findByPromotionId(Long id);
}