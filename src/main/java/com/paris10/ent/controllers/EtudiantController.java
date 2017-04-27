package com.paris10.ent.controllers;

import com.paris10.ent.entities.Etudiant;
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

    EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantController(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @RequestMapping(value = "/index")
    public List<Etudiant> index() {
        return etudiantRepository.findByCreditLessThan(1000000);
    }
}
