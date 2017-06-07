package com.paris10.ent.controllers;

import com.paris10.ent.entities.*;
import com.paris10.ent.repositories.EtudiantRepository;
import com.paris10.ent.repositories.FichierRepository;
import com.paris10.ent.repositories.MatiereRepository;
import com.paris10.ent.repositories.UeRepository;
import com.sun.org.apache.xalan.internal.xsltc.dom.MatchingIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranox on 07/06/17.
 */
@Controller
@RequestMapping(value = "/fichiers")
public class FileController
{
    @Autowired
    FichierRepository fichierRepository;

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    UeRepository ueRepository;

    @Autowired
    MatiereRepository matiereRepository;

    @RequestMapping(value = "/classes")
    public List<Fichier> getFiles(HttpSession session)
    {
        //TODO : trouver promo etudiant + ses matieres + boucle sur findByIdMatiere
        User u = (User) session.getAttribute("student");
        Etudiant e = etudiantRepository.findById(u.getId());

        Promotion p = e.getPromotion();

        List<UE> uePromo = ueRepository.findByPromotionId(p.getId());

        List<Matiere> matieresPromo = new ArrayList<>();
        List<Fichier> fichiersPromo = new ArrayList<>();

        for(UE ue : uePromo)
            for(Matiere m : ue.getMatieres())
                matieresPromo.add(m);

        for(Matiere m : matieresPromo)
            for(Fichier f : fichierRepository.findByIdMatiere(m.getId()))
                fichiersPromo.add(f);

        return fichiersPromo;
    }
}
