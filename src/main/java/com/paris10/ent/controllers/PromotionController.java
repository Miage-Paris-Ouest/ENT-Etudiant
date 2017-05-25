package com.paris10.ent.controllers;

import com.paris10.ent.entities.Promotion;
import com.paris10.ent.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/promotion")
public class PromotionController {

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionController(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @RequestMapping(value = "/all")
    @ResponseBody
    public List<Promotion> getAll() {
        List<Promotion> lesPromotions = promotionRepository.findAll();
        return lesPromotions;
    }

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public Promotion getPromotion(@PathVariable long id) {
        return promotionRepository.findOne(id);
    }
}
