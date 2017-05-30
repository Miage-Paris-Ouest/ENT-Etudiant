package com.paris10.ent.controllers;

import com.paris10.ent.entities.Enseignant;
import com.paris10.ent.entities.User;
import com.paris10.ent.repositories.EnseignantRepository;
import com.paris10.ent.repositories.EtudiantRepository;
import com.paris10.ent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by ranox on 04/05/17.
 */

@Controller
@RequestMapping(value = "/validation")
public class ValidationController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String authPage()
    {
        return "login";
    }

    @RequestMapping(value = "/authentication")
    public String authentication(@RequestParam String password, @RequestParam String id, Model model)
    {
        User user = userRepository.findById(Long.valueOf(id));
        String passwordFromDb = user.getMdp();

        //TODO : Changer page de redirection
        String page = "index";
        //TODO : comparer mdp cryptés

        if(!password.equals(passwordFromDb))
        {
            model.addAttribute("message", "L'authentification a échoué !");
            page = "login";
        }

        return page;
    }
}
