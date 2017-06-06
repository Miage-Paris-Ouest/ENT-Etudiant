package com.paris10.ent.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "semestre")
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_semestre")
    private long id;

    @OneToMany
    @MapsId
    @JoinColumn(name = "id_semestre", referencedColumnName = "id_semestre")
    @JsonBackReference
    private List<UE> ue;

    @NotBlank
    private String nom_semestre;

    public Semestre() {
    }

    public Semestre(String nom_semestre) {
        this.nom_semestre = nom_semestre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_semestre() {
        return nom_semestre;
    }

    public void setNom_semestre(String nom_semestre) {
        this.nom_semestre = nom_semestre;
    }

    public List<UE> getUe() {
        return ue;
    }

    public void addUe(UE ue)
    {
        this.getUe().add(ue);
    }
}
