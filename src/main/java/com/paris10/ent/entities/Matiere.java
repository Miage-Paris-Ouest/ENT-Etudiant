package com.paris10.ent.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "matiere")
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_matiere")
    private long id;

    @NotBlank
    private String nom_matiere, description;
    private int nb_ects;
    private float coefficient, nb_heures;

    @ManyToOne
    @JoinColumn(name = "id_ue")
    @JsonManagedReference
    private UE ue;

    @ManyToOne
    @JoinColumn(name = "id_enseignant")
    @JsonBackReference
    private Enseignant enseignant;

    public Matiere() {
    }

    public Matiere(String nom_matiere, String description, int nb_ects, float coefficient, float nb_heures, UE ue, Enseignant enseignant) {
        this.nom_matiere = nom_matiere;
        this.description = description;
        this.nb_ects = nb_ects;
        this.coefficient = coefficient;
        this.nb_heures = nb_heures;
        this.ue = ue;
        this.enseignant = enseignant;
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

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Long getEnseignantId() {
        return enseignant.getId();
    }

    public long getId() {
        return id;
    }
}
