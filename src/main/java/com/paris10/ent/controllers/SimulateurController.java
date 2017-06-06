package com.paris10.ent.controllers;

import com.paris10.ent.entities.*;
import com.paris10.ent.repositories.EtudiantRepository;
import com.paris10.ent.repositories.MatiereRepository;
import com.paris10.ent.repositories.SemestreRepository;
import com.paris10.ent.repositories.UeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @Autowired
    EtudiantRepository etudiantRepository;

    @RequestMapping("/")
    public String init(Model model)
    {
        List<Semestre> semestres = semestreRepository.findAll();
        model.addAttribute("terms", semestres);
        return "simulateur";
    }

    @RequestMapping(value = "/matieres/{ue}")
    @ResponseBody
    public List<Matiere> getMatieresByUe(@PathVariable long ue, Model model)
    {
//        model.addAttribute("matieres",matiereRepository.findAll());
        return matiereRepository.findByUeId(ue);
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
        model.addAttribute("ue",ue);
        return "simulateur";
    }

    @RequestMapping(value = "/ue/{ue}/matieres")
    public List<Matiere> getMatieresById(@PathVariable int ue, Model model)
    {
        UE ueById = ueRepository.findById(ue);
        List<Matiere> matieres = matiereRepository.findByUeId(ue);
        UeContent ueContainer = new UeContent(ueById, matieres);

        model.addAttribute("ueContent",ueContainer);
//        return "simulation";
        return matiereRepository.findByUeId(ue);
    }

    @RequestMapping(value = "/semestres/{id}")
    @ResponseBody
    public List<UE> getSemestre(@PathVariable long id, HttpSession session)
    {
        User user = (User)session.getAttribute("student");

        Etudiant etudiant = etudiantRepository.findById(user.getId());

        Promotion p = etudiant.getPromotion();
        List<UE> ues = ueRepository.findByPromotionIdAndSemestreId(id, p.getId());
        return ues;
    }
}
