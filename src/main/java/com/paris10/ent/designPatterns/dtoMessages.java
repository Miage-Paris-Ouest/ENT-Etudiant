package com.paris10.ent.designPatterns;

import com.paris10.ent.entities.Messages;
import com.paris10.ent.entities.User;

/**
 * Created by Numerial on 31/05/2017.
 */
public class dtoMessages {

    public  Messages m;
    public User u1,u2;

    public  dtoMessages(Messages m, User u1, User u2){
        this.m =m;
        this.u1=u1;
        this.u2=u2;
    }

    public  dtoMessages(){};

    public Messages getM() {
        return m;
    }

    public void setM(Messages m) {
        this.m = m;
    }

    public User getU1() {
        return u1;
    }

    public void setU1(User u1) {
        this.u1 = u1;
    }

    public User getU2() {
        return u2;
    }

    public void setU2(User u2) {
        this.u2 = u2;
    }

    public void clearObject(){
        this.m=null;
        this.u1=null;
        this.u2=null;
    }
}
