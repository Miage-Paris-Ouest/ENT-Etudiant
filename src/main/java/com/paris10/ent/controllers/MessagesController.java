package com.paris10.ent.controllers;

import com.paris10.ent.designPatterns.ChatMessage;
import com.paris10.ent.designPatterns.ResponseMapper;
import com.paris10.ent.designPatterns.dtoMessages;
import com.paris10.ent.entities.Messages;
import com.paris10.ent.entities.User;
import com.paris10.ent.repositories.EtudiantRepository;
import com.paris10.ent.repositories.MessageRepository;
import com.paris10.ent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    /*
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
    }*/

    public List<dtoMessages> getMessages() {
        List<Messages> msg = messageRepository.findAll();
        List<dtoMessages> dtoList=new ArrayList<dtoMessages>();
        for (Messages e : msg) {
            long id1, id2 = 0;
            User u1, u2 = new User();
            dtoMessages temp = new dtoMessages();
            System.out.println("-----------------------DEBUG : " + e.getTitre());
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
    @RequestMapping(value="/")
    public String homepage(){
        return "messagerie";
    }

    @RequestMapping(value = "/messagerie")
    public String messagerie(ModelMap model) {
        if(this.getMessages().isEmpty()){
            List<String> messageVide = new ArrayList<String>();
            messageVide.add("Vous n'avez aucun message");
            model.put("message", messageVide);
        }else{
            List<dtoMessages> dtolist = this.getMessages();
            model.put("message", dtolist);
        }

        model.put("users",this.getUsers());
        return "messagerie";
    }


    @RequestMapping(value = "/conversation")
    public String nouveauMessage(ModelMap model) {
        if(this.getMessages().isEmpty()){
            List<String> messageVide = new ArrayList<String>();
            messageVide.add("Vous n'avez aucun message");
            model.put("conversation", messageVide);
        }else {
            List<dtoMessages> dtolist = this.getMessages();
            model.put("conversation", dtolist);
        }
        return "conversation";
    }

    @RequestMapping(value = "/conversationReload")
    public String recharger(ModelMap model) {
        if(this.getMessages().isEmpty()){
            List<String> messageVide = new ArrayList<String>();
            messageVide.add("Vous n'avez aucun message");
            model.put("conversation", messageVide);
        }else {
            List<dtoMessages> dtolist = this.getMessages();
            model.put("conversation", dtolist);
        }
        System.out.println("----------Trace controleur message Reload triggered");
        return "reloadConversation :: convReload";
    }

    /*@RequestMapping(value = "/postcustomer", method = RequestMethod.POST)
    public ResponseMapper envoi(@RequestParam("message") String message, @RequestParam("u1") String user1Id, @RequestParam("u2") String user2Id,  @RequestParam("titre") String titre) {
        System.out.println("Message : "+message+" utilisateur : "+user1Id + " utilisateur 2 : "+user2Id);
        Messages msg = new Messages();
        msg.setMessage(message);
        msg.setId_user1(Integer.parseInt(user1Id));
        msg.setId_user2(Integer.parseInt(user2Id));

        ResponseMapper response = new ResponseMapper("Done", msg);
        return response;
    }*/

    @RequestMapping(value = "/postcustomer", method = RequestMethod.POST)
    @ResponseBody
    public String postCustomer(@RequestBody ChatMessage chatMessage) {
        //cust.add(chatMessage);
        // Create ResponseMapper Object
        System.out.println("----------Trace controleur message");
        System.out.println("\t Envoyeur : "+chatMessage.getId_user1());
        System.out.println("\t Destinataire :  "+chatMessage.getId_user2());
        System.out.println("\t Message : "+chatMessage.getMessage());

        Messages msg  = new Messages();
        msg.setId_user1(Integer.parseInt(chatMessage.getId_user1()));
        msg.setId_user2(Integer.parseInt(chatMessage.getId_user2()));
        msg.setMessage(chatMessage.getMessage());
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        msg.setDate_message(date);
        msg.setLu1(1);
        msg.setLu2(0);
        msg.setTitre("TEST AJOUT");
        System.out.println("\t Date now : "+date);
        messageRepository.save(msg);
        ResponseMapper responseMapper = new ResponseMapper("Done", chatMessage);
        return "Done";
    }
    /*@RequestMapping(value = "/postcustomer", method = RequestMethod.POST)
    @ResponseBody
    public String postCustomer(@RequestBody Messages message) {
        // Create ResponseMapper Object
        System.out.println("************************************TEST");
        System.out.println(message.getMessage());
       // ResponseMapper response = new ResponseMapper("Done", customer);
        return "Done";
    }*/



}
