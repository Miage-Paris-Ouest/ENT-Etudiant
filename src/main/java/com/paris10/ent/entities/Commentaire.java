package com.paris10.ent.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "commentaire")
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_commentaire")
    private long id;

    private String commentaire;
    private Date date_commentaire;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference(value = "commentaire-user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_fichier")
    @JsonBackReference(value = "commentaire-fichier")
    private Fichier fichier;

    public Commentaire() {
    }

    public Commentaire(String commentaire, Date date_commentaire, User user, Fichier fichier) {
        this.commentaire = commentaire;
        this.date_commentaire = date_commentaire;
        this.user = user;
        this.fichier = fichier;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDate_commentaire() {
        return date_commentaire;
    }

    public void setDate_commentaire(Date date_commentaire) {
        this.date_commentaire = date_commentaire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Fichier getFichier() {
        return fichier;
    }

    public void setFichier(Fichier fichier) {
        this.fichier = fichier;
    }
}
