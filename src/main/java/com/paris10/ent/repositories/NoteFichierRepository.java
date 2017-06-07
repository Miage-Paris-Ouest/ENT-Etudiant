package com.paris10.ent.repositories;

import com.paris10.ent.entities.NoteFichier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteFichierRepository extends JpaRepository<NoteFichier, Long> {


//    @Query("INSERT INTO notes_fichier(id_user, id_fichier, evaluation_fichier) VALUES (?, ?, ?)")
//    public void saveSQL(int id_user, int id_fichier, float evaluation_fichier);
}
