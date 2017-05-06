package com.paris10.ent.controllers;

import com.paris10.ent.entities.Enseignant;
import com.paris10.ent.entities.User;
import com.paris10.ent.repositories.EnseignantRepository;
import com.paris10.ent.repositories.EtudiantRepository;
import com.paris10.ent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by ranox on 04/05/17.
 */

@RestController
@RequestMapping(value = "/validation")
public class ValidationController {

    private UserRepository userRepository;

    @Autowired
    public ValidationController(UserRepository etudiantRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/toto")
    public void test()
    {
        System.out.println("ok");
    }

    @RequestMapping(value = "/password/{id}")
    public boolean validatePassword(@PathVariable int id, @RequestParam String password)
    {
        User user = userRepository.findById(id);
        String passwordFromDb = user.getMdp();

        //TODO : comparer mdp cryptés
        return password.equals(passwordFromDb);
    }
}
