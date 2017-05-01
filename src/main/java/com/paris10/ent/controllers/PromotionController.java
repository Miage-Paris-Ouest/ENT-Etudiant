package com.paris10.ent.controllers;


import com.paris10.ent.entities.Promotion;
import com.paris10.ent.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/promotion")
public class PromotionController {

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionController(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @RequestMapping(value = "/index")
    @CrossOrigin
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }
}
