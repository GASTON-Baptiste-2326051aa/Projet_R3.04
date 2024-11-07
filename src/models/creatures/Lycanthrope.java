package models.creatures;

import models.*;

public class Lycanthrope extends Creature {
    /**
     * Constructor of the class Lycanthrope
     * @param name
     * @param is_male
     * @param age
     * @param weight
     * @param height
     * @param moral
     * @param illnesses
     */
    public Lycanthrope(String name, boolean is_male, int age, float weight, float height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**
     *
     */
    public void contaminate(){

    }
}
