package com.paris10.ent.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "enseignant")
public class Enseignant {

    @Id
    @Column(name = "enseignant_id_user")
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "enseignant_id_user", referencedColumnName = "id_user")
    private User user;

    private String nom_enseignant;

    @OneToMany(mappedBy = "enseignant")
    @JsonManagedReference(value = "enseignant-matiere")
    private List<Matiere> matiere;

    public Enseignant() {
    }

    public Enseignant(User user, String nom_enseignant) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Matiere> getMatiere() {
        return matiere;
    }

    public void setMatiere(List<Matiere> matiere) {
        this.matiere = matiere;
    }
}
