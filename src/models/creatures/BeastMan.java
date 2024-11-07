package models.creatures;

import models.Creature;
import models.Illness;

public class BeastMan extends Creature {
    /**
     * Constructor of the class BeastMan
     * @param name
     * @param is_male
     * @param age
     * @param weight
     * @param height
     * @param moral
     * @param illnesses
     */
    public BeastMan(String name, boolean is_male, int age, float weight, float height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**
     *
     */
    public void contaminate(){

    }
}
