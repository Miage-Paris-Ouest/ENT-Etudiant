package com.paris10.ent.controllers;

import com.paris10.ent.entities.Etudiant;
import com.paris10.ent.entities.Promotion;
import com.paris10.ent.entities.RoleEtudiant;
import com.paris10.ent.entities.User;
import com.paris10.ent.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by qlassalle on 27/04/2017.
 */
@RestController
@RequestMapping(value = "/etudiant")
public class EtudiantController {

    private EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantController(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
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

    @RequestMapping(value = "/mescours")
    public String mesCours(ModelMap model) {
        model.put("cours", matiereRepository.findAll());

        return "mesCours";
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
