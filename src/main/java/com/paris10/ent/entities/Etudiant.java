package com.paris10.ent.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

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
    @JsonBackReference(value = "etudiant-promotion")
    private Promotion promotion;

    @OneToMany(mappedBy = "etudiant")
    @JsonManagedReference(value = "etudiant-notes-fichier")
    private List<NoteFichier> notes;

    @Enumerated(EnumType.STRING)
    private RoleEtudiant role_etudiant;

    private int credit = 10;
    private String num_etudiant;


    public Etudiant() { }

    public Etudiant(String num_etudiant, RoleEtudiant role_etudiant, User user, Promotion promo) {
        this.role_etudiant = role_etudiant != null ? role_etudiant : RoleEtudiant.Etudiant;
        this.num_etudiant = num_etudiant;
        this.promotion = promo;
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

    public String getNum_etudiant() {
        return num_etudiant;
    }

    public void setNum_etudiant(String num_etudiant) {
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

    public List<NoteFichier> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteFichier> notes) {
        this.notes = notes;
    }
}
