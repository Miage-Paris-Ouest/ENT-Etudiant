package com.paris10.ent.controllers;

import com.paris10.ent.entities.*;
import com.paris10.ent.repositories.PromotionRepository;
import com.paris10.ent.repositories.SemestreRepository;
import com.paris10.ent.repositories.UeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Youssef on 30/05/2017.
 */
@Controller
@RequestMapping("/ue")
public class UeController {

    private UeRepository ueRepository;
    private SemestreRepository semestreRepository;
    private PromotionRepository promotionRepository;

    @Autowired
    public UeController(UeRepository ueRepository, SemestreRepository semestreRepository,PromotionRepository promotionRepository){
        this.ueRepository=ueRepository;
        this.semestreRepository=semestreRepository;
        this.promotionRepository=promotionRepository;
    }

    public List<Semestre> getSemestres() {
        return semestreRepository.findAll();
    }

    public List<Promotion> getPromotions(){
        return promotionRepository.findAll();
    }

    @GetMapping("/creer")
    public String createUE(ModelMap model){
        model.addAttribute("ue",new UE());
        model.put("semestre",this.getSemestres());
        model.put("promotion",this.getPromotions());
        return "createUE";
    }

    @PostMapping("/createUE")
    public String processFormUe(@Validated UE ue, BindingResult bindingResult, HttpServletRequest request){

        final long semestreId= Long.valueOf(request.getParameter("semestre"));
        final long promotionId= Long.valueOf(request.getParameter("promotion"));

        Semestre semestre = semestreRepository.findOne(semestreId);
        Promotion promotion = promotionRepository.findOne(promotionId);

        System.out.println("nom semestre :" + semestre.getNom_semestre());
        System.out.println("nom promo :" + promotion.getNom_promo());

        ue.setSemestre(semestre);
        ue.setPromotion(promotion);

        System.out.println("id ue :" + ue.getId());
        System.out.println("nom semestre :" + ue.getNom_ue());
        System.out.println("id semestre :" + ue.getSemestre().getId());
        System.out.println("id promotion:" + ue.getPromotion().getId());

        if(bindingResult.hasErrors()) {
            return "accueil";
        }

        ueRepository.save(ue);
        return "redirect:/matiere/creer";
    }

    @PostMapping("/createUEWithCSV")
    public String processFormUEWithCSV(@Validated Fichier fichier, BindingResult bindingResult, HttpServletRequest request) {

        String csvFile = "src/main/resources/csv/" + request.getParameter("csv");
        String codeFonction = request.getParameter("codeFonction");
        System.out.println("chemin : " + csvFile);
        CSVReader csvReader = new CSVReader(csvFile);
        csvReader.readCSV(csvFile,codeFonction);
        return "redirect:/matiere/creer";
    }

    @PostMapping("/exportTableUeToCSV")
    public String processFormCreateCSVWithUeTable(HttpServletRequest request){
        String csvFile= "src/main/resources/csv/" + request.getParameter("fileNameCSV");
        String codeFonction = request.getParameter("codeFonction");
        System.out.println("chemin : "+csvFile);
        CSVWriter csvWriter=new CSVWriter(csvFile);
        csvWriter.writeCsvFile(csvFile,codeFonction);
        return "redirect:/matiere/creer";
    }
}