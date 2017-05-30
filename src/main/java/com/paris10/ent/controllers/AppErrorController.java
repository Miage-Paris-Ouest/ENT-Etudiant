package com.paris10.ent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ranox on 27/04/17.
 */

@Controller
@RequestMapping("/error")
public class AppErrorController {

    public String errorRedirect()
    {
        return "error";
    }
}
