package com.paris10.ent.controllers;

import com.paris10.ent.entities.Commentaire;
import com.paris10.ent.repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/commentaire")
public class CommentaireController {

    CommentaireRepository commentaireRepository;

    @Autowired
    public CommentaireController(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    @RequestMapping(value = "/get/{idFichier}")
    @ResponseBody
    public List<Commentaire> getCommentaires(@PathVariable long idFichier) {
        return commentaireRepository.findByFichierId(idFichier);
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public List<Commentaire> saveCommentaire(@RequestBody Commentaire commentaire) {
        commentaireRepository.save(commentaire);
        return commentaireRepository.findByFichierId(commentaire.getFichier().getId());
    }
}
