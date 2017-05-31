package com.paris10.ent.repositories;

import com.paris10.ent.entities.UE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UeRepository extends JpaRepository<UE, Long>{

    UE findById(int id);

    @Query("SELECT u FROM UE u, Promotion p WHERE u.promotion.id = p.id AND p.id = ?1")
    List<UE> findByPromotionId(Long id);

    List<UE> findBySemestre(int id);
}
