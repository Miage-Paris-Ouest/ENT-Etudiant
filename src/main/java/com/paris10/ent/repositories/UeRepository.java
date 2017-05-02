package com.paris10.ent.repositories;

import com.paris10.ent.entities.UE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UeRepository extends JpaRepository<UE, Long>{
//    List<UE> findByPromotionId(Long promotionId);
}
