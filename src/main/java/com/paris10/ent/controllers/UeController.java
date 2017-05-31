package com.paris10.ent.controllers;

import com.paris10.ent.entities.UE;
import com.paris10.ent.repositories.UeRepository;
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
@RequestMapping("/ue")
public class UeController {

    private UeRepository ueRepository;

    @Autowired
    public UeController(UeRepository ueRepository){
        this.ueRepository=ueRepository;
    }

    @GetMapping("/creer")
    public String createUE(@ModelAttribute UE ue){
        return "createUE";
    }

    @PostMapping("/createUE")
    public String processFormUe(@Validated UE ue, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "accueil";
        }
        ueRepository.save(ue);
        return "redirect:/creer";
    }
}