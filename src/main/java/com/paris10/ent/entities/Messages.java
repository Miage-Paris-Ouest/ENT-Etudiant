package com.paris10.ent.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_message")
    private long id;

    private String message,titre;
    private Date date_message;

    private int id_user1, id_user2, lu1,lu2;

    public Messages() {
    }

    public Messages(String message, String titre, Date date_message, int id_user1, int id_user2) {
        this.message = message;
        this.date_message = date_message;
        this.id_user1 = id_user1;
        this.id_user2 = id_user2;
        this.titre=titre;
    }
    public Messages(String titre) {
        this.titre=titre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate_message() {
        return date_message;
    }

    public void setDate_message(Date date_commentaire) {
        this.date_message = date_commentaire;
    }

    public String getTitre() {return titre;}

    public void setTitre(String titre) {this.titre = titre;}

    public int getId_user1() {return id_user1;}

    public void setId_user1(int id_user1) {this.id_user1 = id_user1;}

    public int getId_user2() {return id_user2;}

    public void setId_user2(int id_user2) {this.id_user2 = id_user2;}

    public int getLu1() {return lu1;}

    public void setLu1(int lu1) {this.lu1 = lu1;}

    public int getLu2() {return lu2;}

    public void setLu2(int lu2) {this.lu2 = lu2;}
}
