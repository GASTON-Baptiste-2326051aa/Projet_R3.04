package models.creatures;

import models.Creature;
import models.Illness;

public class Vampire extends Creature {
    /**
     * Constructor of the class Vampire
     * @param name
     * @param is_male
     * @param age
     * @param weight
     * @param height
     * @param moral
     * @param illnesses
     */
    public Vampire(String name, boolean is_male, int age, int weight, int height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses); }

    /**
     *
     */
    public void demoralize(){

    }

    /**
     *
     */
    public void contaminate(){

    }

    /**
     *
     */
    public void regenerer(){

    }
}
