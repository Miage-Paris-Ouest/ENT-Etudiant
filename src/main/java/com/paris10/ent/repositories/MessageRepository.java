package com.paris10.ent.repositories;

import com.paris10.ent.entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qlassalle on 27/04/2017.
 */
@Repository
public interface MessageRepository extends JpaRepository<Messages, Long> {

    List<Messages>  findAll();
    List<Messages> findById(long id);
    //List<Messages> findDistinctByTitre(String titre);

    @Query(" select DISTINCT(m.titre)  from Messages m  WHERE m.titre <> ''  ")
    List<String> findConvTitre();

    //@Query(" select m from Messages m where m.titre=?1")
    Messages findByTitre(String titre);

}