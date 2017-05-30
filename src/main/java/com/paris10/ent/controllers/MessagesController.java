package com.paris10.ent.controllers;

import com.paris10.ent.entities.*;
import com.paris10.ent.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/messagerie")
public class MessagesController {

    private EtudiantRepository etudiantRepository;
    private UserRepository userRepository;
    private MessageRepository messageRepository;


    @Autowired
    public MessagesController(EtudiantRepository etudiantRepository, UserRepository userRepository, MessageRepository messageRepository){
        this.etudiantRepository = etudiantRepository;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;

    }

    public List<Messages> getMessages() {
        List<Messages> msg = messageRepository.findAll();
        if(msg.isEmpty()){
            Messages vide = new Messages("Vous n'avez aucun message");
            msg.add(vide);
        }
        return  msg;
    }

    @RequestMapping(value = "/messagerie")
    public String messagerie(ModelMap model) {
        model.put("message", this.getMessages());
        return "messagerie";
    }

}
