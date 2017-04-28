/*
package com.paris10.ent.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "commentaire")
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_commentaire")
    private long id;

    private String commentaire;
    private Date date_commentaire;

    // TODO Relation ManyToOne à creer pour les deux ids
    private int id_etudiant, id_fichier;

    public Commentaire() {
    }

    public Commentaire(String commentaire, Date date_commentaire, int id_etudiant, int id_fichier) {
        this.commentaire = commentaire;
        this.date_commentaire = date_commentaire;
        this.id_etudiant = id_etudiant;
        this.id_fichier = id_fichier;
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

    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public int getId_fichier() {
        return id_fichier;
    }

    public void setId_fichier(int id_fichier) {
        this.id_fichier = id_fichier;
    }
}
*/
