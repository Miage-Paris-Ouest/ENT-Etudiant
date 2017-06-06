package com.paris10.ent.designPatterns;

/**
 * Created by Numerial on 06/06/2017.
 */
public class ChatMessage {
    private String id_user1;
    private String id_user2;
    private String message;

    public ChatMessage(){}

    public ChatMessage(String id_user1, String id_user2, String message){
        this.id_user1 = id_user1;
        this.id_user2 = id_user2;
        this.message= message;
    }

    public String getId_user1() {
        return id_user1;
    }

    public void setId_user1(String id_user1) {
        this.id_user1 = id_user1;
    }

    public String getId_user2() {
        return id_user2;
    }

    public void setId_user2(String id_user2) {
        this.id_user2 = id_user2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}