package com.paris10.ent.controllers;

import com.paris10.ent.designPatterns.dtoMessages;
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

    /*public List<Messages> getMessages() {
        List<Messages> msg = messageRepository.findAll();
        if(msg.isEmpty()){
            Messages vide = new Messages("Vous n'avez aucun message");
            msg.add(vide);
        }
        return  msg;
    }*/

    /*public List<User> getUsersFromMessages() {
        List<Messages> msg = messageRepository.findAll();
        List<User>users = new ArrayList<User>();
        long id1,id2=0;
        User u1,u2 = new User();
        for(Messages m : msg){
            //recuperer pour chaque message les utilisateurs associés
            id1 = m.getId_user1();
            id2 = m.getId_user2();
            u1=userRepository.findById(id1);
            u2=userRepository.findById(id2);
            users.add(u1);
            users.add(u2);
        }
        if(msg.isEmpty()){
            User noUser = new User();
            noUser.setNom("Aucun message");
            users.add(noUser);
        }
        return  users;
    }*/

    public List<User> getUsersFromMessages(Messages e) {
        List<Messages> msg = messageRepository.findById(e.getId());
        List<User>users = new ArrayList<User>();
        long id1,id2=0;
        User u1,u2 = new User();
        id1 = e.getId_user1();
        id2 = e.getId_user2();
        u1=userRepository.findById(id1);
        u2=userRepository.findById(id2);
        users.add(u1);
        users.add(u2);
        if(msg.isEmpty()){
            User noUser = new User();
            noUser.setNom("Aucun message");
            users.add(noUser);
        }
        return  users;
    }

    public List<dtoMessages> getMessages() {
        List<Messages> msg = messageRepository.findAll();
        List<dtoMessages> dtoList=new ArrayList<dtoMessages>();

        long id1,id2=0;
        User u1,u2 = new User();
        dtoMessages temp = new dtoMessages();
        for(Messages e : msg){
            id1 = e.getId_user1();
            id2 = e.getId_user2();
            u1=userRepository.findById(id1);
            u2=userRepository.findById(id2);
            temp.setM(e);
            temp.setU1(u1);
            temp.setU2(u2);
            dtoList.add(temp);
        }
        return  dtoList;
    }

    public List<User> getUsers() {
        List<User> usr = userRepository.findAll();
        if(usr.isEmpty()){
            User noUser = new User();
            noUser.setNom("Aucun utilisateur");
            usr.add(noUser);
        }
        return  usr;
    }

    @RequestMapping(value = "/messagerie")
    public String messagerie(ModelMap model) {
        if(this.getMessages().isEmpty()){
            List<String> messageVide = new ArrayList<String>();
            messageVide.add("Vous n'avez aucun message");
            model.put("message", messageVide);
        }else{
            model.put("message", this.getMessages());
        }
        model.put("users",this.getUsers());
        return "messagerie";
    }

}
