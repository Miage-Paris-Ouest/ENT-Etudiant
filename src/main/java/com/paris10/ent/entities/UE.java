package com.paris10.ent.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ue")
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ue")
    private long id;

    @NotBlank
    @Column(name = "nom_ue")
    public String nom_ue;

    @ManyToOne
    @JoinColumn(name = "id_semestre")
    @JsonManagedReference
    private Semestre semestre;

    @ManyToOne
    @JoinColumn(name = "id_promotion")
    @JsonManagedReference
    private Promotion promotion;

    @OneToMany(mappedBy = "ue")
    @JsonBackReference
    private List<Matiere> matieres;

    public UE() {
    }

    public UE(String nom_ue, Semestre semestre, Promotion promotion) {
        this.nom_ue = nom_ue;
        this.semestre = semestre;
        this.promotion = promotion;
    }

    public UE(String nom_ue) {
        this.nom_ue = nom_ue;
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

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }
}
