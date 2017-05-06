package com.paris10.ent.controllers;

import com.paris10.ent.entities.User;
import com.paris10.ent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ranox on 04/05/17.
 */

@RestController
@RequestMapping(value = "/user")
public class UserController
{
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/toto")
    public void test()
    {
        System.out.println("ok");
    }

    @RequestMapping(value = "/{id}")
    public User getUserById(@PathVariable int id)
    {
        return userRepository.findById(id);
    }

/*
    @RequestMapping(value = "/{id}")
    public void updateUserEmailById(@PathVariable int id, @RequestParam String email)
    {
        User user = userRepository.findById(id);
        System.out.println("ok");
    }
*/
    @RequestMapping(value = "/{user}", method = RequestMethod.PATCH)
    public boolean updateUser(@ModelAttribute User user)
    {

        return false;
    }
}
