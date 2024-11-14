package models.creatures.lycanthropes;

import models.creatures.Werewolf;

import java.util.List;

public class Meute {
    private String lieu;
    private String nom;
    private Werewolf maleAlpha;
    private Werewolf femaleAlpha;
    private List<Werewolf> meute;


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

    public Werewolf getMaleAlpha() {
        return maleAlpha;
    }

    public void setMaleAlpha(Werewolf maleAlpha) {
        this.maleAlpha = maleAlpha;
    }

    public Werewolf getFemaleAlpha() {
        return femaleAlpha;
    }

    public void setFemaleAlpha(Werewolf femaleAlpha) {
        this.femaleAlpha = femaleAlpha;
    }

    public List<Werewolf> getMeute() {
        return meute;
    }

    public void setMeute(List<Werewolf> meute) {
        this.meute = meute;
    }

    public void addLycanthrope(Werewolf werewolf) {
        this.meute.add(werewolf);
    }

    public void removeLycanthrope(Werewolf werewolf){
        this.meute.remove(werewolf);
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
