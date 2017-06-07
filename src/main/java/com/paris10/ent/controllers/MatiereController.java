package com.paris10.ent.controllers;

import com.paris10.ent.entities.*;
import com.paris10.ent.repositories.EnseignantRepository;
import com.paris10.ent.repositories.MatiereRepository;
import com.paris10.ent.repositories.UeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/matiere")
public class MatiereController {

    private MatiereRepository matiereRepository;
    private UeRepository ueRepository;
    private EnseignantRepository enseignantRepository;

    @Autowired
    public MatiereController(MatiereRepository matiereRepository, UeRepository ueRepository, EnseignantRepository enseignantRepository){
        this.matiereRepository=matiereRepository;
        this.ueRepository=ueRepository;
        this.enseignantRepository=enseignantRepository;
    }

    private List<UE> getUes(){return ueRepository.findAll();}
    private List<Enseignant> getEnseignants(){return enseignantRepository.findAll();}

    @GetMapping("/creer")
    public String createMatiere(ModelMap model){
        model.addAttribute("matiere",new Matiere());
        model.put("ue",this.getUes());
        model.put("enseignant",this.getEnseignants());
        List<Matiere> matieres=matiereRepository.findAll();
        model.addAttribute("matieres",matieres);
        return "createMatiere";
    }

    @PostMapping("/createMatiere")
    public String processFormMatiere(@Validated Matiere matiere, BindingResult bindingResult, HttpServletRequest request){

        Long idUe = Long.valueOf(request.getParameter("ue"));
        Long idEnseignant = Long.valueOf(request.getParameter("enseignant"));


        UE ue= ueRepository.findOne(idUe);
        Enseignant enseignant = enseignantRepository.findOne(idEnseignant);

        matiere.setUe(ue);
        matiere.setEnseignant(enseignant);

        if(bindingResult.hasErrors()) {
            return "accueil";
        }
        matiereRepository.save(matiere);
        return "redirect:/semestre/creer";
    }

    @PostMapping("/createMatiereWithCSV")
    public String processFormMatierreWithCSV(HttpServletRequest request){
        String csvFile= "src/main/resources/csv/" + request.getParameter("csv");
        String codeFonction = request.getParameter("codeFonction");

        System.out.println("chemin : "+csvFile);
        System.out.println("Semestre controller code Fonction : "+codeFonction);

        CSVReader csvReader=new CSVReader(csvFile);
        csvReader.readCSV(csvFile,codeFonction);
        return "redirect:/matiere/creer";
    }

    @PostMapping("/exportTableMatiereToCSV")
    public String processFormCreateCSVWithMatiereTable(HttpServletRequest request){
        String csvFile= "src/main/resources/csv/" + request.getParameter("fileNameCSV");
        String codeFonction = request.getParameter("codeFonction");
        System.out.println("chemin : "+csvFile);
        CSVWriter csvWriter=new CSVWriter(csvFile);
        csvWriter.writeCsvFile(csvFile,codeFonction);
        return "redirect:/semestre/creer";
    }

}
