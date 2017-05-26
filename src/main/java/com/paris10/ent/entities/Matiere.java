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
    private int nb_etcs;
    private float coefficient, nb_heures;

    @ManyToOne
    @JoinColumn(name = "id_ue")
    private UE ue;

    public Matiere() {
    }

    public Matiere(String nom_matiere, String description, int nb_etcs, float coefficient, float nb_heures, UE ue) {
        this.nom_matiere = nom_matiere;
        this.description = description;
        this.nb_etcs = nb_etcs;
        this.coefficient = coefficient;
        this.nb_heures = nb_heures;
        this.ue = ue;
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

    public int getNb_etcs() {
        return nb_etcs;
    }

    public void setNb_etcs(int nb_ects) {
        this.nb_etcs = nb_ects;
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

    public UE getUe() {
        return ue;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public Long getUeId() {
        return ue.getId();
    }
}
