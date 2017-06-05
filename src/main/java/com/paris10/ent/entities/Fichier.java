package com.paris10.ent.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "fichier")
public class Fichier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fichier")
    private long id;

    private String nom_fichier, chemin;
    private boolean visible;
    // TODO Relation ManyToOne pour les ids

    @ManyToOne
    @JoinColumn(name = "id_matiere")
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User user;

    public Fichier() {
    }

    public Fichier(String nom_fichier, String chemin, boolean visible, Matiere matiere, User user) {
        this.nom_fichier = nom_fichier;
        this.chemin = chemin;
        this.visible = visible;
        this.matiere = matiere;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_fichier() {
        return nom_fichier;
    }

    public void setNom_fichier(String nom_fichier) {
        this.nom_fichier = nom_fichier;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public Long getMatiereId() {
        return matiere.getId();
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
