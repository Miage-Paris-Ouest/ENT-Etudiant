package com.paris10.ent.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "note_fichier")
@IdClass(NoteFichierId.class)
public class NoteFichier implements Serializable {

    @Id
    @Column(name = "id_user")
    private long id_etudiant;

    @Id
    @Column(name = "id_fichier")
    private long id_fichier;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    @JsonBackReference(value = "etudiant-notes-fichier")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "id_fichier", insertable = false, updatable = false)
    @JsonBackReference(value = "fichier-notes")
    private Fichier fichier;

    private float evaluation_fichier;

    public NoteFichier() {
    }


    public NoteFichier(Etudiant etudiant, Fichier fichier, float evaluation_fichier) {
        this.etudiant = etudiant;
        this.fichier = fichier;
        this.evaluation_fichier = evaluation_fichier;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Fichier getFichier() {
        return fichier;
    }

    public void setFichier(Fichier fichier) {
        this.fichier = fichier;
    }

    public float getEvaluation_fichier() {
        return evaluation_fichier;
    }

    public void setEvaluation_fichier(float evaluation_fichier) {
        this.evaluation_fichier = evaluation_fichier;
    }

    public long getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(long id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public long getId_fichier() {
        return id_fichier;
    }

    public void setId_fichier(long id_fichier) {
        this.id_fichier = id_fichier;
    }
}
