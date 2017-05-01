package com.paris10.ent.controllers;

import com.paris10.ent.entities.Etudiant;
import com.paris10.ent.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/etudiant")
public class EtudiantController {

    private EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantController(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @RequestMapping(value = "/index")
    @CrossOrigin // autorise les appels http depuis Angular
    public List<Etudiant> index() {
        // Insert student in bdd
//        User u = new User("Rabeony", "Quentin", "arabeony@gmail.com", "mdp", TypeUser.Etudiant);
//        Promotion promo = new Promotion("L3 MIAGE CLA");
//        Etudiant etudiant = new Etudiant(RoleEtudiant.Etudiant, 1000, promo, 35000001, u);
//        etudiantRepository.save(etudiant);
        return etudiantRepository.findAll();
    }

    @RequestMapping(value = "/{id}")
    @CrossOrigin
    public Etudiant getEtudiant(@PathVariable Long id) {
        return etudiantRepository.findById(id);
    }

    @RequestMapping(value = "/byPromoId/{id_promotion}")
    @CrossOrigin
    public List<Etudiant> findByPromotion(@PathVariable Long id_promotion) {
        return etudiantRepository.findByPromotionId(id_promotion);
    }
}
