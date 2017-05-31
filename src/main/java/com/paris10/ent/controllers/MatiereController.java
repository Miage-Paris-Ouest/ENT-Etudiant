package com.paris10.ent.controllers;

import com.paris10.ent.entities.Matiere;
import com.paris10.ent.repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Youssef on 30/05/2017.
 */
@Controller
@RequestMapping("/matiere")
public class MatiereController {

    private MatiereRepository matiereRepository;

    @Autowired
    public MatiereController(MatiereRepository matiereRepository){
        this.matiereRepository=matiereRepository;
    }

    @GetMapping("/creer")
    public String createMatiere(@ModelAttribute Matiere matiere){
        return "createMatiere";
    }

    @PostMapping("/createMatiere")
    public String processFormMatiere(@Validated Matiere matiere, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "accueil";
        }
        matiereRepository.save(matiere);
        return "redirect:/creer";
    }
}
