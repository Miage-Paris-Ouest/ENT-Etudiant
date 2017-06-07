package com.paris10.ent.repositories;

import com.paris10.ent.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    /**
     * List de promotion
     * @return une liste de promotion
     */
    List<Promotion> findAll();

    /**
     * Promotion par un identifiant passé en paramètre
     * @param id Integer identifiant d'une promotion
     * @return Promotion
     */
    Promotion findById(Long id);

}
