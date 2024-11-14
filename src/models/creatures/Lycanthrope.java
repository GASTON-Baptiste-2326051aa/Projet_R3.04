package models.creatures;

import models.Illness;
import models.creatures.lycanthropes.Meute;
import models.services.Service;

import java.util.Arrays;
import java.util.Random;

public class Lycanthrope extends Creature {

    private int rank;
    private String dominationFactor;
    private int strenght;
    private int level;
    private String impetuosityFactor;
    private boolean isAlone;
    private Meute meute;


    /**
     * Constructor of the class Lycanthrope
     * @param name the name of the lycanthrope
     * @param is_male the sexe of the lycanthrope
     * @param age the age of the lycanthrope
     * @param weight the weight of the lycanthrope
     * @param height the height of the lycanthrope
     * @param moral the moral of the lycanthrope
     * @param illnesses the illnesses of the lycanthrope
     */
    public Lycanthrope(String name, boolean is_male, int age, float weight, float height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**
     * Second constructor of the class Lycanthrope, mostly used if the lycanthrope is in a pack
     * @param name
     * @param is_male
     * @param age
     * @param weight
     * @param height
     * @param moral
     * @param illnesses
     * @param rank
     * @param dominationFactor
     */
    public Lycanthrope(String name, boolean is_male, int age, float weight, float height, int moral, Illness[] illnesses, int rank, String dominationFactor, int strenght, int level, String impetuosityFactor, boolean isAlone, Meute meute) {
        super(name, is_male, age, weight, height, moral, illnesses);
        this.rank = rank;
        this.dominationFactor = dominationFactor;
        this.strenght = strenght;
        this.level = level;
        this.impetuosityFactor = impetuosityFactor;
        this.meute = meute;
        this.isAlone = (meute == null || meute.isEmpty());


    }



    /**
     * the lycanthrope pass away and contaminate the creatures inside the service
     */
    @Override
    public boolean passAway(Service service) {
        boolean isDead = super.passAway(service);
        if (isDead) {
            service.removeCreature(this);
            contaminate(service);
        }
        return isDead;
    }

    /**
     * the lycanthrope transforms itself into a human
     */
    public void becomeHuman(){

    }

    /**
     *
     */
    @Override
    public void scream() {

    }

    /**
     *
     */
    public void separateFromPack(){

    }

    /**
     *
     * @return the caracteristics of a lycanthrope
     */
    @Override
    public String toString() {
        return super.toString() +
                "Lycanthrope{" +
                "strenght='" + strenght + '\'' +
                ", rank=" + rank +
                ", dominationFactor=" + dominationFactor +
                ", level=" + level +
                ", impetuosityFactor=" + impetuosityFactor +
                ", isAlone='" + isAlone +
                ", meute=" + meute.getNom() +
                "'}";
    }


}
