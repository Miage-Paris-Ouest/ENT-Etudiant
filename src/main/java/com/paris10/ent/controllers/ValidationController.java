package com.paris10.ent.controllers;

import com.paris10.ent.entities.*;
import com.paris10.ent.repositories.*;
import com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_sv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private UeRepository ueRepository;

    @Autowired
    private SemestreRepository semestreRepository;

    User user = null;

    @RequestMapping("/")
    public String authPage()
    {
        return "login";
    }

    @RequestMapping(value = "/authentication")
    public String authentication(@RequestParam String password, @RequestParam String id, Model model, HttpSession session)
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
        else {

            if (isAdmin)
                model.addAttribute("admin", user);
            else {
                Etudiant etudiant = etudiantRepository.findByEtudiantIdUser(user.getId());
                model.addAttribute("etudiant", etudiant);
                List<Etudiant> listeEtudiants = (etudiant.getPromotion()).getLes_etudiants();

                List<User> camarades = new ArrayList<>();

                for (Etudiant e : listeEtudiants)
                    camarades.add(userRepository.findById(e.getUserId()));

                Promotion studentPromo = etudiant.getPromotion();

                List<UE> ues = ueRepository.findByPromotionId(studentPromo.getId());
                List<Semestre> terms = semestreRepository.findAll();

                model.addAttribute("terms", terms);
                model.addAttribute("ues", ues);
                model.addAttribute("user", user);
                model.addAttribute("classe", camarades);
                model.addAttribute("promo", studentPromo);
            }
            session.setAttribute( isAdmin ? "admin" : "student", user);
        }
        return page;
    }
}
