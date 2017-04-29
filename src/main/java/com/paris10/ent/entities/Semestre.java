package com.paris10.ent.entities;

import javax.persistence.*;

@Entity
@Table(name = "semestre")
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_semestre")
    private long id;

    private String nom_semestre;

    public Semestre() {
    }

    public Semestre(String nom_semestre) {
        this.nom_semestre = nom_semestre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_semestre() {
        return nom_semestre;
    }

    public void setNom_semestre(String nom_semestre) {
        this.nom_semestre = nom_semestre;
    }
}
