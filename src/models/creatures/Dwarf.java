package models.creatures;

import models.Illness;

public class Dwarf extends Creature {
    /**
     * Constructor of the class Dwarf
     * @param name the name of the dwarf
     * @param is_male the sexe of the dwarf
     * @param age the age of the dwarf
     * @param weight the weight of the dwarf
     * @param height the height of the dwarf
     * @param moral the moral of the dwarf
     * @param illnesses the illnesses of the dwarf
     */
    public Dwarf(String name, boolean is_male, int age, int weight, int height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }
}
