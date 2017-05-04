package com.paris10.ent.controllers;
import com.paris10.ent.entities.Etudiant;
import com.paris10.ent.entities.Promotion;
import com.paris10.ent.entities.RoleEtudiant;
import com.paris10.ent.entities.User;
import com.paris10.ent.repositories.EtudiantRepository;
import com.paris10.ent.repositories.PromotionRepository;
import com.paris10.ent.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/etudiant")
public class EtudiantController {

    private EtudiantRepository etudiantRepository;
    private UserRepository userRepository;
    private PromotionRepository promotionRepository;

    @Autowired
    public EtudiantController(EtudiantRepository etudiantRepository, UserRepository userRepository, PromotionRepository promotionRepository) {
        this.etudiantRepository = etudiantRepository;
        this.userRepository = userRepository;
        this.promotionRepository = promotionRepository;
    }

    @RequestMapping(value = "/index")
    public List<Etudiant> index() {
        saveStudent();
        return etudiantRepository.findAll();
    }

    private void saveStudent() {

        // Log les requêtes sql et affiche les valeur "bindées"
        Logger logger = LoggerFactory.getLogger(this.getClass());

        // Insert student in bdd
        User u = userRepository.findById(Long.valueOf(7));
        userRepository.flush();
        System.out.println(u.getId());
        Promotion promo = new Promotion("L3 MIAGE APP", "2016-2017");
        promotionRepository.save(promo);
        promotionRepository.flush();
        System.out.println(promo.getId());
        Etudiant etudiant = new Etudiant(1000, 3500000, promo, RoleEtudiant.Etudiant, u);
        etudiantRepository.save(etudiant);
    }
}
