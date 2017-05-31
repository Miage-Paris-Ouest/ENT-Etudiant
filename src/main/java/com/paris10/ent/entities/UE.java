package com.paris10.ent.entities;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "ue")
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ue")
    private long id;

    @NotBlank
    private String nom_ue;

    //TODO Relation ManyToOne à creer
    private int id_semestre, id_promotion;

    public UE() {
    }

    public UE(String nom_ue, int id_semestre, int id_promotion) {
        this.nom_ue = nom_ue;
        this.id_semestre = id_semestre;
        this.id_promotion = id_promotion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_ue() {
        return nom_ue;
    }

    public void setNom_ue(String nom_ue) {
        this.nom_ue = nom_ue;
    }

    public int getId_semestre() {
        return id_semestre;
    }

    public void setId_semestre(int id_semestre) {
        this.id_semestre = id_semestre;
    }

    public int getid_promotion() {
        return id_promotion;
    }

    public void setid_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }
}
