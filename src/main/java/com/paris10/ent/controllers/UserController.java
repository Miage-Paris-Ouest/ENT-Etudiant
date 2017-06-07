package com.paris10.ent.controllers;

import com.paris10.ent.designPatterns.Validation;
import com.paris10.ent.entities.User;
import com.paris10.ent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by ranox on 04/05/17.
 */

@Controller
@RequestMapping(value = "/users")
public class UserController
{
    @Autowired
    UserRepository userRepository;

    Validation validation = new Validation();

    @RequestMapping("/")
    public String init(@PathVariable long id, Model model, HttpSession session)
    {
        model.addAttribute("user", session.getAttribute("user"));

        return validation.userType(session) =="na" ? "login" : "monCompte";
    }

    @RequestMapping(path = "/{id}/password", method = POST)
    @ResponseBody
    public boolean updatePassword(@PathVariable long id, @RequestParam("newPassword") String newPassword, Model model)
    {
        return userRepository.updateUserPasswordById(id, newPassword) == 1;
    }

    @RequestMapping(path = "/{id}/password", method = GET)
    @ResponseBody
    public boolean checkPassword(@PathVariable long id, @RequestParam("password") String password)
    {
        User user = userRepository.findById(id);
        return password.equals(user.getMdp());
    }

    @RequestMapping(path = "/{id}", method = POST)
    @ResponseBody
    public int updateUser(@PathVariable long id, @RequestParam("email") String email, @RequestParam("file") String file)
    {
        User user = userRepository.findByEmail(email);

        if(user!=null && user.getId()!=id)
            return -1;

        // TODO : ajouter champ filePath
//        return userRepository.updateUser(id, email, file) == 1 ? 0 : 1;
        return userRepository.updateUser(id, email);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public User create(@RequestBody User user) {
        // @todo see how we want to manage password on user's creation
        user.setMdp("mdptemporaire");
        userRepository.save(user);
        // return user because it now has an id
        return user;
    }
}
