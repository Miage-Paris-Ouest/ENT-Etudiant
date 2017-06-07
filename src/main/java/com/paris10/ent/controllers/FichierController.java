package com.paris10.ent.controllers;

import com.paris10.ent.entities.Etudiant;
import com.paris10.ent.entities.Fichier;
import com.paris10.ent.entities.NoteFichier;
import com.paris10.ent.repositories.EtudiantRepository;
import com.paris10.ent.repositories.FichierRepository;
import com.paris10.ent.repositories.NoteFichierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/fichier")
public class FichierController {

    private FichierRepository fichierRepository;
    private NoteFichierRepository noteFichierRepository;
    private EtudiantRepository etudiantRepository;

    @Autowired
    public FichierController(FichierRepository fichierRepository, NoteFichierRepository noteFichierRepository, EtudiantRepository etudiantRepository) {
        this.fichierRepository = fichierRepository;
        this.noteFichierRepository = noteFichierRepository;
        this.etudiantRepository = etudiantRepository;
    }

    @RequestMapping(value = "/all")
    @ResponseBody
    public List<Fichier> getAllFichiers() {
        return fichierRepository.findAll();
    }

    @RequestMapping(value = "/voter", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void voteForFile(@RequestBody NoteFichier noteFichier) {
        long idUser = noteFichier.getEtudiant().getUser().getId();
        long idFichier = noteFichier.getFichier().getId();
        float evaluationFichier = noteFichier.getEvaluation_fichier();
        Fichier f = fichierRepository.findOne(idFichier);
        Etudiant e = etudiantRepository.findOne(idUser);
        NoteFichier nf = new NoteFichier(e, f, evaluationFichier);
        nf.setId_etudiant(nf.getEtudiant().getUser().getId());
        nf.setId_fichier(nf.getFichier().getId());
        noteFichierRepository.save(nf);
    }
}
