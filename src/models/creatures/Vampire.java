package models.creatures;

import models.Illness;

public class Vampire extends Creature {
    /**
     * Constructor of the class Vampire
     * @param name the name of a vampire
     * @param is_male the sexe of a vampire
     * @param age the age of a vampire
     * @param weight the weight of a vampire
     * @param height the height of a vampire
     * @param moral the moral of a vampire
     * @param illnesses the illnesses of a vampire
     */
    public Vampire(String name, boolean is_male, int age, int weight, int height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses); }

    /**
     * While passing away, demoralizes a part of the creature inside the medical service
     */
    public void demoralize(){

    }

    /**
     * Contaminates another creature
     */
    public void contaminate(){
        System.out.println(getName() + "infects another creature !");

    }

    /**
     * Can regenearate itself, meaning that the moral is going back to default
     */
    public void regenerate(){
        System.out.println(getName() + "regenerates itself !");
        setMorale(100);
    }
}
