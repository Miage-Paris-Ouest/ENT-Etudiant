package com.paris10.ent.controllers;

import com.paris10.ent.entities.User;
import com.paris10.ent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ranox on 04/05/17.
 */

@Controller
@RequestMapping(value = "/users")
public class UserController
{
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/{id}")
    public String init(@PathVariable long id, Model model)
    {
        User user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "monCompte";
    }

    @PostMapping("/{id}/password")
    public boolean updatePassword(@PathVariable long id, @RequestParam("password") String password, @RequestParam("newPassword") String newPassword, Model model)
    {
//        User user = userRepository.findById(id);
//            TODO : maj BD
        return false;
    }

    @GetMapping("/{id}/password")
    public boolean checkPassword(@PathVariable long id, @RequestParam("password") String password, Model model)
    {
        User user = userRepository.findById(id);

        return password.equals(user.getMdp());
    }
}
