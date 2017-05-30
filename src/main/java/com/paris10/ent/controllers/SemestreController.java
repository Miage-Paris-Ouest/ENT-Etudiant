package com.paris10.ent.controllers;

import com.paris10.ent.entities.Matiere;
import com.paris10.ent.entities.Semestre;
import com.paris10.ent.repositories.SemestreRepository;
import com.paris10.ent.repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Created by Youssef on 04/05/2017.
 */
@Controller
public class SemestreController {

    private SemestreRepository semestreRepository;


    @Autowired
    public SemestreController(SemestreRepository semestreRepository){
        this.semestreRepository=semestreRepository;
    }

    @GetMapping("/")
    public String createSemestre(@ModelAttribute Semestre semestre){
        return "createSemestre";
    }

    @PostMapping("/")
    public String processFormSemestre(@Validated Semestre semestre, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "accueil";
        }
        semestreRepository.save(semestre);
        return "redirect:/";
    }
}
