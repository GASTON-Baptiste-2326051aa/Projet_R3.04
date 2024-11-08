package models.creatures;

import models.*;

public class Lycanthrope extends Creature {
    /**
     * Constructor of the class Lycanthrope
     * @param name the name of the lycanthrope
     * @param is_male the sexe of the lycanthrope
     * @param age the age of the lycanthrope
     * @param weight the weight of the lycanthrope
     * @param height the height of the lycanthrope
     * @param moral the moral of the lycanthrope
     * @param illnesses the illnesses of the lycanthrope
     */
    public Lycanthrope(String name, boolean is_male, int age, float weight, float height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**
     * Contaminates another creature
     */
    public void contaminate(){
        System.out.println(getName() + "infects a creature !");

    }
}
