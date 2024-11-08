package models.creatures;

import models.Illness;

public class Orc extends Creature {
    /**
     * Constructor of the class Orc
     * @param name the name of the orc
     * @param is_male the sexe of the orc
     * @param age the age of the orc
     * @param weight the weight of the orc
     * @param height the height of the orc
     * @param moral the moral of the orc
     * @param illnesses the illnesses of the orc
     */
    public Orc(String name, boolean is_male, int age, int weight, int height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**
     * Contaminates another creature
     */
    public void contaminate(){
        System.out.println(getName() + "infects another creature !");
    }
}
