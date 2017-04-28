//package com.paris10.ent.entities;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "fichier")
//public class Fichier {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private long id;
//
//    private String nom_fichier, chemin;
//    private boolean visible;
//    // TODO Relation ManyToOne pour les ids
//    private int id_etudiant, id_matiere;
//
//    public Fichier() {
//    }
//
//    public Fichier(String nom_fichier, String chemin, boolean visible, int id_etudiant, int id_matiere) {
//        this.nom_fichier = nom_fichier;
//        this.chemin = chemin;
//        this.visible = visible;
//        this.id_etudiant = id_etudiant;
//        this.id_matiere = id_matiere;
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
//    public String getNom_fichier() {
//        return nom_fichier;
//    }
//
//    public void setNom_fichier(String nom_fichier) {
//        this.nom_fichier = nom_fichier;
//    }
//
//    public String getChemin() {
//        return chemin;
//    }
//
//    public void setChemin(String chemin) {
//        this.chemin = chemin;
//    }
//
//    public boolean isVisible() {
//        return visible;
//    }
//
//    public void setVisible(boolean visible) {
//        this.visible = visible;
//    }
//
//    public int getId_etudiant() {
//        return id_etudiant;
//    }
//
//    public void setId_etudiant(int id_etudiant) {
//        this.id_etudiant = id_etudiant;
//    }
//
//    public int getId_matiere() {
//        return id_matiere;
//    }
//
//    public void setId_matiere(int id_matiere) {
//        this.id_matiere = id_matiere;
//    }
//}
