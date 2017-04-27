package com.paris10.ent.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "note_fichier")
public class NoteFichier {
    private int id_etudiant, id_fichier;
    private float evaluation_fichier;

    public NoteFichier() {

    }

    public NoteFichier(int id_etudiant, int id_fichier, float evaluation_fichier) {
        this.id_etudiant = id_etudiant;
        this.id_fichier = id_fichier;
        this.evaluation_fichier = evaluation_fichier;
    }

    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public int getId_fichier() {
        return id_fichier;
    }

    public void setId_fichier(int id_fichier) {
        this.id_fichier = id_fichier;
    }

    public float getEvaluation_fichier() {
        return evaluation_fichier;
    }

    public void setEvaluation_fichier(float evaluation_fichier) {
        this.evaluation_fichier = evaluation_fichier;
    }
}
