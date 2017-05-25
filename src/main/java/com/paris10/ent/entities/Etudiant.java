package com.paris10.ent.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "etudiant")
public class Etudiant {

    @Id
    @Column(name = "etudiant_id_user")
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "etudiant_id_user", referencedColumnName = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_promotion")
    @JsonBackReference
    private Promotion promotion;

    @Enumerated(EnumType.STRING)
    private RoleEtudiant role_etudiant;

    private int credit, num_etudiant;



    public Etudiant() { }

    /**
     * @todo test to init the int to 0. The app doesn't crash for String which takes null but crashes for int fields
     * getting a 0
     **/
    public Etudiant(int credit, int num_etudiant, Promotion promo, RoleEtudiant role_etudiant, User user) {
        this.role_etudiant = role_etudiant;
        this.credit = credit;
        this.promotion = promo;
        this.num_etudiant = num_etudiant;
        this.user = user;
    }

    public RoleEtudiant getRole_etudiant() {
        return role_etudiant;
    }

    public void setRole_etudiant(RoleEtudiant role_etudiant) {
        this.role_etudiant = role_etudiant;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getNum_etudiant() {
        return num_etudiant;
    }

    public void setNum_etudiant(int num_etudiant) {
        this.num_etudiant = num_etudiant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
