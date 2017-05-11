package com.paris10.ent.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranox on 09/05/17.
 */
public class SemestreContent
{
    Semestre semestre;
    List<UeContent> listeUe;

    public SemestreContent(Semestre semestre, List<UeContent> listeUe) {
        this.semestre = semestre;
        this.listeUe = listeUe;
    }

    public SemestreContent(Semestre semestre) {
        this.semestre = semestre;
        this.listeUe = new ArrayList<UeContent>();
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public List<UeContent> getListeUe() {
        return listeUe;
    }

    public void setListeUe(List<UeContent> listeUe) {
        this.listeUe = listeUe;
    }

    public void addUe(UeContent ue)
    {
        this.listeUe.add(ue);
    }
}
