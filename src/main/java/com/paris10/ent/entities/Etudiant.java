package com.paris10.ent.entities;

import javax.persistence.*;

/**
 * Created by qlassalle on 27/04/2017.
 */
@Entity
@Table(name= "etudiant")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_etudiant")
    long id;

    // @todo remove mdp_etudiant
    private String nom_etudiant;
    private String prenom_etudiant, email_etudiant, mdp_etudiant;

    //@todo manage enum here
    private String role_etudiant;

    // @todo create ManyToOne association
    private int credit, id_promo, num_etudiant;

    public Etudiant() { }

    /** @todo  test to init the int to 0. The app doesn't crash for String which takes null but crashes for int fields
        getting a 0 **/
    public Etudiant(String nom_etudiant, String prenom_etudiant, String email_etudiant, String mdp_etudiant, String role_etudiant, int credit, int id_promo, int num_etudiant) {
        this.nom_etudiant = nom_etudiant;
        this.prenom_etudiant = prenom_etudiant;
        this.email_etudiant = email_etudiant;
        this.mdp_etudiant = mdp_etudiant;
        this.role_etudiant = role_etudiant;
        this.credit = credit;
        this.id_promo = id_promo;
        this.num_etudiant = num_etudiant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_etudiant() {
        return nom_etudiant;
    }

    public void setNom_etudiant(String nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }

    public String getPrenom_etudiant() {
        return prenom_etudiant;
    }

    public void setPrenom_etudiant(String prenom_etudiant) {
        this.prenom_etudiant = prenom_etudiant;
    }

    public String getEmail_etudiant() {
        return email_etudiant;
    }

    public void setEmail_etudiant(String email_etudiant) {
        this.email_etudiant = email_etudiant;
    }

    public String getMdp_etudiant() {
        return mdp_etudiant;
    }

    public void setMdp_etudiant(String mdp_etudiant) {
        this.mdp_etudiant = mdp_etudiant;
    }

    public String getRole_etudiant() {
        return role_etudiant;
    }

    public void setRole_etudiant(String role_etudiant) {
        this.role_etudiant = role_etudiant;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getId_promo() {
        return id_promo;
    }

    public void setId_promo(int id_promo) {
        this.id_promo = id_promo;
    }

    public int getNum_etudiant() {
        return num_etudiant;
    }

    public void setNum_etudiant(int num_etudiant) {
        this.num_etudiant = num_etudiant;
    }
}
