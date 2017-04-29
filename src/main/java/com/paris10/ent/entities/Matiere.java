package com.paris10.ent.entities;

import javax.persistence.*;

@Entity
@Table(name = "matiere")
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_matiere")
    private long id;

    private String nom_matiere, description;
    //TODO Relation ManyToOne et OneToOne
    private int nb_ects, id_ue, id_enseignant;
    private float coefficient, nb_heures;

    public Matiere() {
    }

    public Matiere(String nom_matiere, String description, int nb_ects, int id_ue, int id_enseignant, float coefficient, float nb_heures) {
        this.nom_matiere = nom_matiere;
        this.description = description;
        this.nb_ects = nb_ects;
        this.id_ue = id_ue;
        this.id_enseignant = id_enseignant;
        this.coefficient = coefficient;
        this.nb_heures = nb_heures;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNb_ects() {
        return nb_ects;
    }

    public void setNb_ects(int nb_ects) {
        this.nb_ects = nb_ects;
    }

    public int getId_ue() {
        return id_ue;
    }

    public void setId_ue(int id_ue) {
        this.id_ue = id_ue;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public float getNb_heures() {
        return nb_heures;
    }

    public void setNb_heures(float nb_heures) {
        this.nb_heures = nb_heures;
    }
}
