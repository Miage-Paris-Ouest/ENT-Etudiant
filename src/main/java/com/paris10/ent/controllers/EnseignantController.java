package com.paris10.ent.controllers;

import com.paris10.ent.entities.Enseignant;
import com.paris10.ent.repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value = "/enseignant")
public class EnseignantController {

    @Autowired
    private EnseignantRepository enseignantRepository;


    public EnseignantController(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    @RequestMapping(value = "/index")
    public List<Enseignant> index() {
        return enseignantRepository.findAll();
    }
}
