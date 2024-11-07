package models.creatures;

import models.Creature;
import models.Illness;

public class Orc extends Creature {
    /**
     * Constructor of the class Orc
     * @param name
     * @param is_male
     * @param age
     * @param weight
     * @param height
     * @param moral
     * @param illnesses
     */
    public Orc(String name, boolean is_male, int age, int weight, int height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**
     *
     */
    public void contaminate(){

    }
}
