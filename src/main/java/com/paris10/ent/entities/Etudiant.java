package com.paris10.ent.entities;

import javax.persistence.*;

/**
 * Created by qlassalle on 27/04/2017.
 */
@Entity(name = "etudiant")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long idEtudiant;

    // @todo remove mdpEtudiant
    private String nomEtudiant, prenomEtudiant, emailEtudiant, mdpEtudiant;

    //@todo manage enum here
    private String roleEtudiant;

    // @todo create ManyToOne association
    private int credit, idPromo, numEtudiant;

    public Etudiant() { }

    public Etudiant(String nomEtudiant, String prenomEtudiant, String emailEtudiant, String mdpEtudiant, String roleEtudiant, int credit, int idPromo, int numEtudiant) {
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.emailEtudiant = emailEtudiant;
        this.mdpEtudiant = mdpEtudiant;
        this.roleEtudiant = roleEtudiant;
        this.credit = credit;
        this.idPromo = idPromo;
        this.numEtudiant = numEtudiant;
    }

    public long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public String getEmailEtudiant() {
        return emailEtudiant;
    }

    public void setEmailEtudiant(String emailEtudiant) {
        this.emailEtudiant = emailEtudiant;
    }

    public String getMdpEtudiant() {
        return mdpEtudiant;
    }

    public void setMdpEtudiant(String mdpEtudiant) {
        this.mdpEtudiant = mdpEtudiant;
    }

    public String getRoleEtudiant() {
        return roleEtudiant;
    }

    public void setRoleEtudiant(String roleEtudiant) {
        this.roleEtudiant = roleEtudiant;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    public int getNumEtudiant() {
        return numEtudiant;
    }

    public void setNumEtudiant(int numEtudiant) {
        this.numEtudiant = numEtudiant;
    }
}
