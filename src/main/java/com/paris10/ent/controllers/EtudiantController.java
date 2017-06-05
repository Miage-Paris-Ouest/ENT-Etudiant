package com.paris10.ent.controllers;

import com.paris10.ent.entities.*;
import com.paris10.ent.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/etudiant")
public class EtudiantController {

    private EtudiantRepository etudiantRepository;
    private UserRepository userRepository;
    private PromotionRepository promotionRepository;
    private UeRepository ueRepository;
    private MatiereRepository matiereRepository;
    private FichierRepository fichierRepository;

    @Autowired
    public EtudiantController(EtudiantRepository etudiantRepository, UserRepository userRepository, PromotionRepository promotionRepository, UeRepository ueRepository, MatiereRepository matiereRepository, FichierRepository fichierRepository) {
        this.etudiantRepository = etudiantRepository;
        this.userRepository = userRepository;
        this.promotionRepository = promotionRepository;
        this.ueRepository = ueRepository;
        this.matiereRepository = matiereRepository;
        this.fichierRepository = fichierRepository;
    }

    @RequestMapping(value = "/all")
    public List<Etudiant> index() {
        return etudiantRepository.findAll();
    }

    public List<UE> getUes() {
        Long idPromotion = new Long(3);
        List<UE> ues = ueRepository.findByPromotionId(idPromotion);

        return ues;
    }

    @RequestMapping(value = "/getmatieres")
    @ResponseBody
    public List<Matiere> getMatieres() {
        List<UE> ues = this.getUes();
        List<Matiere> matieres = new ArrayList<Matiere>();

        for (UE ue:ues) {
            if(matiereRepository.findByUeId(ue.getId()) != null)
                matieres.addAll(matiereRepository.findByUeId(ue.getId()));
        }

        return matieres;
    }

    @RequestMapping(value = "/getcours/{id_matiere}")
    @ResponseBody
    public List<Fichier> getCoursOfMatiere(@PathVariable Long id_matiere) {
        List<Fichier> fichiers = fichierRepository.findByMatiereId(id_matiere);

        return fichiers;
    }

    @RequestMapping(value = "/mescours")
    public String mesCours() {
        return "mesCours";
    }

    @RequestMapping(value = "/maclasse")
    public String maClasse(Model model) {
        model.addAttribute("etudiants", etudiantRepository.findAll());
        model.addAttribute("promotions", promotionRepository.findAll());
        return "gestionClasses";
    }

//    private void saveStudent() {
//
//        // Log les requêtes sql et affiche les valeur "bindées"
//        //Logger logger = LoggerFactory.getLogger(this.getClass());
//
//        // Insert student in bdd
//        User u = userRepository.findById(Long.valueOf(7));
//        userRepository.flush();
//        System.out.println(u.getId());
//        Promotion promo = new Promotion("L3 MIAGE APP", "2016-2017");
//        promotionRepository.save(promo);
//        promotionRepository.flush();
//        System.out.println(promo.getId());
//        Etudiant etudiant = new Etudiant(1000, 3500000, promo, RoleEtudiant.Etudiant, u);
//        etudiantRepository.save(etudiant);
//    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public List<Etudiant> create(@RequestBody Etudiant etudiant) {
        User user = userRepository.findOne(etudiant.getUser().getId());
        Promotion promotion = promotionRepository.findOne(etudiant.getPromotion().getId());
        Etudiant etudiant1 = new Etudiant(etudiant.getNum_etudiant(), etudiant.getRole_etudiant(), user, promotion);
        etudiantRepository.save(etudiant1);
        return etudiantRepository.findAll();
    }
}
