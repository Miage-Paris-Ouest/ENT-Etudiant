package com.paris10.ent.controllers;

import com.paris10.ent.entities.Etudiant;
import com.paris10.ent.entities.TypeUser;
import com.paris10.ent.entities.User;
import com.paris10.ent.repositories.EtudiantRepository;
import com.paris10.ent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranox on 04/05/17.
 */

@Controller
@RequestMapping(value = "/validation")
public class ValidationController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private UserRepository userRepository;

    User user = null;

    @RequestMapping("/")
    public String authPage()
    {
        return "login";
    }

    @RequestMapping(value = "/authentication")
    public String authentication(@RequestParam String password, @RequestParam String id, Model model)
    {
        user = userRepository.findById(Long.valueOf(id));
        String passwordFromDb = user.getMdp();

        boolean isAdmin = user.getType() == TypeUser.Administrateur;
        //TODO : Changer page de redirection
        String page =  isAdmin ? "admin" : "index";
        //TODO : comparer mdp cryptés

        if(!password.equals(passwordFromDb))
        {
            model.addAttribute("message", "L'authentification a échoué !");
            page = "login";
        }

        if(isAdmin)
            model.addAttribute("admin", user);
        else
        {
            Etudiant etudiant = etudiantRepository.findByEtudiantIdUser(user.getId());
            model.addAttribute("etudiant", etudiant);
            List<Etudiant> listeEtudiants = (etudiant.getPromotion()).getLes_etudiants();

            List<User> camarades = new ArrayList<>();

            for (Etudiant e : listeEtudiants) {
                camarades.add(userRepository.findById(e.getUser().getId()));
            }

            model.addAttribute("user", user);
            model.addAttribute("classe", camarades);
            model.addAttribute("promo", etudiant.getPromotion());
        }
        return page;
    }
}
