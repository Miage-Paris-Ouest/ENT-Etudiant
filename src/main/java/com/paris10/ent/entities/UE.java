//package com.paris10.ent.entities;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "ue")
//public class UE {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private long id;
//
//    private String nom_ue;
//
//    //TODO Relation ManyToOne à creer
//    private int id_semestre, id_promo;
//
//    public UE() {
//    }
//
//    public UE(String nom_ue, int id_semestre, int id_promo) {
//        this.nom_ue = nom_ue;
//        this.id_semestre = id_semestre;
//        this.id_promo = id_promo;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getNom_ue() {
//        return nom_ue;
//    }
//
//    public void setNom_ue(String nom_ue) {
//        this.nom_ue = nom_ue;
//    }
//
//    public int getId_semestre() {
//        return id_semestre;
//    }
//
//    public void setId_semestre(int id_semestre) {
//        this.id_semestre = id_semestre;
//    }
//
//    public int getId_promo() {
//        return id_promo;
//    }
//
//    public void setId_promo(int id_promo) {
//        this.id_promo = id_promo;
//    }
//}
