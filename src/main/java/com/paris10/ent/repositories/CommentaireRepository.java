package com.paris10.ent.repositories;

import com.paris10.ent.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    List<Commentaire> findByFichierId(long idFichier);
}
