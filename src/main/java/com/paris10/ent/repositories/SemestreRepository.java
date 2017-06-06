package com.paris10.ent.repositories;

import com.paris10.ent.entities.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Youssef on 04/05/2017.
 */
@Repository
public interface SemestreRepository  extends JpaRepository<Semestre, Long>{

}
