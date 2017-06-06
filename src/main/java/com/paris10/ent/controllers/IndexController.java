package com.paris10.ent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ranox on 31/05/17.
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController
{

    @RequestMapping("/")
    public String welcomePage()
    {
        return "index";
    }
}
