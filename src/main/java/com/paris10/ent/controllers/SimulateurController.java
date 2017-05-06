package com.paris10.ent.controllers;

import com.paris10.ent.entities.Matiere;
import com.paris10.ent.entities.Semestre;
import com.paris10.ent.entities.UE;
import com.paris10.ent.entities.UeAsMatieresContainer;
import com.paris10.ent.repositories.MatiereRepository;
import com.paris10.ent.repositories.SemestreRepository;
import com.paris10.ent.repositories.UeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        UeAsMatieresContainer ueContainer = new UeAsMatieresContainer(ueById, matieres);

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
        UeAsMatieresContainer ueContainer = new UeAsMatieresContainer(ueById, matieres);

        model.addAttribute("ueContent",ueContainer);
//        return "simulation";
        return matiereRepository.findByUe(ue);
    }
}
