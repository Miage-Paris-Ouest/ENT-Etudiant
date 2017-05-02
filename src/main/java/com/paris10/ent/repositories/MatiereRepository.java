package com.paris10.ent.repositories;

import com.paris10.ent.entities.Matiere;
import com.paris10.ent.entities.UE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatiereRepository extends JpaRepository<Matiere, Long>{
//    List<Matiere> findByUeId(Long ueId);
}
