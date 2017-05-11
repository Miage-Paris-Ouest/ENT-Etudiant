package com.paris10.ent.entities;

import java.util.List;

/**
 * Created by ranox on 04/05/17.
 */
public class UeContent
{
    UE ue;
    List<Matiere> matieres;

    public UeContent(UE ue, List<Matiere> matieres) {
        this.ue = ue;
        this.matieres = matieres;
    }

    public UE getUe() {
        return ue;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    public void addMatiere(Matiere matiere)
    {
        this.matieres.add(matiere);
    }
}
