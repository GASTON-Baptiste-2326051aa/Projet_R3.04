package models.creatures;

import models.Illness;

/**
 * Class Vampire
 */
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
     * Demoralizes the service
     */
    public void demoralize(){

    }

    /**
     * Contaminates the service
     */
    public void contaminate(){

    }

    /**
     * Regenerates the service
     */
    public void regenerer(){

    }
}
