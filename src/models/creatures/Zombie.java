package models.creatures;

import models.Illness;

public class Zombie extends Creature {
    /**
     * Constructor of the class Zombie
     * @param name name of a zombie
     * @param is_male gender of a zombie
     * @param age age of a Zombie
     * @param weight poids of a Zomboe
     * @param height height of a zombie
     * @param morale morale of a zombie
     * @param illnesses list of illnesses of a zombie
     */
    public Zombie(String name, boolean is_male, int age, int weight, int height, int morale, Illness[] illnesses) {
        super(name, is_male, age, weight, height, morale, illnesses); }

    /**
     *
     */
    public void regenerate(){

    }
}