package com.paris10.ent.controllers;

import com.paris10.ent.entities.*;
import com.paris10.ent.helpers.HttpDownloadUtility;
import com.paris10.ent.repositories.*;
import com.paris10.ent.storage.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/Admin")
public class CalendrierController {

    private PromotionRepository promotionRepository;

    @Autowired
    public CalendrierController(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    /**
     * Mapping vers la page gestionCalendrier.html
     * @param model
     * @return String
     */
    @RequestMapping(value = "/Calendrier")
    public String pageCalendrier(ModelMap model) {
        model.put("promotion", this.getAllPromotions());
        return "gestionCalendrier";
    }

    /**
     * Gestion de la requête Ajax lors du changement de promotion
     * @param model
     * @return String
     */
    @RequestMapping(value = "/Calendrier/AjaxRequest")
    public @ResponseBody String selectAjax(ModelMap model, @RequestParam("idPromotion") Long idPromotion) {
        Promotion promo = promotionRepository.findById(idPromotion);
        return promo.getCalendrier();
    }

    /**
     * Mise à jour d'une promotion
     * @param model
     * @return String
     */
    @RequestMapping(value = "/Calendrier/UpdatePromotion")
    public @ResponseBody Boolean updatePromotion(ModelMap model, HttpServletRequest request) {
        Long idPromo = Long.valueOf(request.getParameter("selectPromo"));
        String ical = request.getParameter("calendrierIcal");
        Boolean success = false;
        //Mise à jour de l'objet Promotion
        Promotion promo = promotionRepository.findById(idPromo);
        promo.setCalendrier(ical);
        promotionRepository.save(promo);
        model.put("save", true);
        //Enregistrement du calendrier
        String fileURL = promo.getCalendrier();
        String saveDir = new StorageProperties().getLocation();
        try {
            success = HttpDownloadUtility.downloadFile(fileURL, saveDir, promo);
        } catch (IOException ex) {
            ex.printStackTrace();
            success = false;
        }
        return success;
    }

    /**
     * List de promotions
     * @return une liste de promotion
     */
    List<Promotion> getAllPromotions(){
        return promotionRepository.findAll();
    }

}
