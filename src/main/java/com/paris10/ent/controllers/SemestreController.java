package com.paris10.ent.controllers;

import com.paris10.ent.entities.*;
import com.paris10.ent.repositories.SemestreRepository;
import com.paris10.ent.repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Youssef on 04/05/2017.
 */
@Controller
@RequestMapping("/semestre")
public class SemestreController {

    private SemestreRepository semestreRepository;


    @Autowired
    public SemestreController(SemestreRepository semestreRepository){
        this.semestreRepository=semestreRepository;
    }

    @GetMapping("/creer")
    public String createSemestre(@ModelAttribute Semestre semestre){
        return "createSemestre";
    }

    @PostMapping("/createSemestre")
    public String processFormSemestre(@Validated Semestre semestre, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "accueil";
        }
        semestreRepository.save(semestre);
        return "redirect:/ue/creer";
    }

    @PostMapping("/createSemestreWithCSV")
    public String processFormSemestreWithCSV(HttpServletRequest request){
        String csvFile= "src/main/resources/csv/" + request.getParameter("csv");
        String codeFonction = request.getParameter("codeFonction");

        System.out.println("chemin : "+csvFile);
        System.out.println("Semestre controller code Fonction : "+codeFonction);

        CSVReader csvReader=new CSVReader(csvFile);
        csvReader.readCSV(csvFile,codeFonction);
        return "redirect:/ue/creer";
    }

    @PostMapping("/exportTableSemestreToCSV")
    public String processFormCreateCSVWithSemestreTable(HttpServletRequest request,HttpServletResponse response){
        String csvFile= "src/main/resources/csv/" + request.getParameter("fileNameCSV");
        String codeFonction = request.getParameter("codeFonction");
        System.out.println("chemin : "+csvFile);
        CSVWriter csvWriter=new CSVWriter(csvFile);
        csvWriter.writeCsvFile(csvFile,codeFonction);
        return "redirect:/ue/creer";
    }
}
