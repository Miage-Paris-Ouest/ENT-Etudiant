package com.paris10.ent.designPatterns;

import com.paris10.ent.entities.User;

import javax.servlet.http.HttpSession;

/**
 * Created by ranox on 07/06/17.
 */
public class Validation
{
    public String userType(HttpSession session)
    {
        String type = session == null ? "na" : "tbd";

        if("tbd".equals(type))
        {
            User u = (User) session.getAttribute("admin");
            type = u == null ? "etudiant" : "admin";
        }
        return type;
    }
}
