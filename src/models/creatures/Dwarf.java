package models.creatures;

import models.Creature;
import models.Illness;

public class Dwarf extends Creature {
    /**
     * Constructor of the class Dwarf
     * @param name
     * @param is_male
     * @param age
     * @param weight
     * @param height
     * @param moral
     * @param illnesses
     */
    public Dwarf(String name, boolean is_male, int age, int weight, int height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }
}
