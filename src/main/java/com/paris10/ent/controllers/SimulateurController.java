package com.paris10.ent.controllers;

import com.paris10.ent.entities.*;
import com.paris10.ent.repositories.MatiereRepository;
import com.paris10.ent.repositories.SemestreRepository;
import com.paris10.ent.repositories.UeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranox on 04/05/17.
 */
@Controller
@RequestMapping("/simulateur")
public class SimulateurController
{
    @Autowired
    MatiereRepository matiereRepository;

    @Autowired
    UeRepository ueRepository;

    @Autowired
    SemestreRepository semestreRepository;

    @RequestMapping("/")
    public String init(Model model)
    {
        List<Semestre> semestres = semestreRepository.findAll();
        model.addAttribute("terms", semestres);
        return "simulateur";
    }

    @RequestMapping(value = "/matieres")
    public List<Matiere> getMatieresByUe(@PathVariable int ue, Model model)
    {
        model.addAttribute("matieres",matiereRepository.findAll());
        return matiereRepository.findAll();
    }

    @RequestMapping(value = "/ue")
    public List<UE> getAllUE(Model model)
    {
        model.addAttribute("ues",ueRepository.findAll());
        return ueRepository.findAll();
    }

    @RequestMapping(value = "/ue/{ue}")
    public String getUeById(@PathVariable int ue, Model model)
    {
        UE ueById = ueRepository.findById(ue);
        List<Matiere> matieres = matiereRepository.findByUe(ue);
        UeContent ueContainer = new UeContent(ueById, matieres);

        List<Semestre> semestres = semestreRepository.findAll();
        model.addAttribute("terms", semestres);
        model.addAttribute("ueContent",ueContainer);

        return "simulateur";
    }

    @RequestMapping(value = "/ue/{ue}/matieres")
    public List<Matiere> getMatieresById(@PathVariable int ue, Model model)
    {
        UE ueById = ueRepository.findById(ue);
        List<Matiere> matieres = matiereRepository.findByUe(ue);
        UeContent ueContainer = new UeContent(ueById, matieres);

        model.addAttribute("ueContent",ueContainer);
//        return "simulation";
        return matiereRepository.findByUe(ue);
    }

    @RequestMapping(value = "/semestres/{id}")
    public String getSemestre(@PathVariable int id, Model model)
    {
        Semestre semestre = semestreRepository.findById(id);
        List<UE> ues = ueRepository.findBySemestre(id);

//        SemestreContent semestreContent = new SemestreContent(semestre);
//        for(UE ue : ues)
//            semestreContent.addUe(new UeContent(ue, matiereRepository.findByUe((int) ue.getId())));

        List<UeContent> ueContents = new ArrayList<UeContent>();

        for(UE ue : ues)
            ueContents.add(new UeContent(ue, matiereRepository.findByUe((int) ue.getId())));

        List<Semestre> semestres = semestreRepository.findAll();
        model.addAttribute("terms", semestres);
        model.addAttribute("semestre",semestre);
        model.addAttribute("ues",ueContents);
        return "simulateur";
    }
}
