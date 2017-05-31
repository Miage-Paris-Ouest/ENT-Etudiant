package com.paris10.ent.repositories;

import com.paris10.ent.entities.UE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Youssef on 30/05/2017.
 */
@Repository
public interface UeRepository extends JpaRepository<UE, Long> {
}
