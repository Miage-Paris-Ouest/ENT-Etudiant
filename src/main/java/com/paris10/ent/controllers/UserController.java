package com.paris10.ent.controllers;

import com.paris10.ent.entities.User;
import com.paris10.ent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
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
