package models.creatures;

import models.Illness;

public class BeastMan extends Creature {
    /**
     * Constructor of the class BeastMan
     * @param name the name of the beastman
     * @param is_male the sexe of the beastman
     * @param age the age of the beastman
     * @param weight the weight of the beastman
     * @param height the height of the beastman
     * @param moral the moral of the beastman
     * @param illnesses the illnesses of the beastman
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
