package models.creatures.lycanthropes;

import models.creatures.Lycanthrope;

import java.util.List;

public class Meute {
    private String lieu;
    private String nom;
    private Lycanthrope maleAlpha;
    private Lycanthrope femaleAlpha;
    private List<Lycanthrope> meute;


    public Meute(String lieu, String nom) {
        this.lieu = lieu;
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Lycanthrope getMaleAlpha() {
        return maleAlpha;
    }

    public void setMaleAlpha(Lycanthrope maleAlpha) {
        this.maleAlpha = maleAlpha;
    }

    public Lycanthrope getFemaleAlpha() {
        return femaleAlpha;
    }

    public void setFemaleAlpha(Lycanthrope femaleAlpha) {
        this.femaleAlpha = femaleAlpha;
    }

    public List<Lycanthrope> getMeute() {
        return meute;
    }

    public void setMeute(List<Lycanthrope> meute) {
        this.meute = meute;
    }

    public void addLycanthrope(Lycanthrope lycanthrope) {
        this.meute.add(lycanthrope);
    }

    public void removeLycanthrope(Lycanthrope lycanthrope){
        this.meute.remove(lycanthrope);
    }

    public boolean isEmpty(){
        return meute.isEmpty();
    }

    /**
     *
     * @return
     */
    public String sortRank(){

        return "";
    }
}
