package com.paris10.ent.entities;

import javax.persistence.*;

@Entity
@Table(name = "ue")
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ue")
    private long id;

    private String nom_ue;

    @ManyToOne
    @JoinColumn(name = "id_semestre")
    private Semestre semestre;

    @ManyToOne
    @JoinColumn(name = "id_promotion")
    private Promotion promotion;

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

    public long getPromotionId() {
        return promotion.getId();
    }

    public long getSemestreId() {
        return semestre.getId();
    }
}
