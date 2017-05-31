package com.paris10.ent.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "enseignant")
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enseignant_id_user")
    private long id;

    private String nom_enseignant;

    @OneToMany(mappedBy = "enseignant")
    private List<Matiere> matiere;

    public Enseignant() {
    }

    public Enseignant(String nom_enseignant) {
        this.nom_enseignant = nom_enseignant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_enseignant() {
        return nom_enseignant;
    }

    public void setNom_enseignant(String nom_enseignant) {
        this.nom_enseignant = nom_enseignant;
    }
}
