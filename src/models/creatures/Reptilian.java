package models.creatures;

import models.Creature;
import models.Illness;

public class Reptilian extends Creature {
    /**
     * Constructor of the class Reptilian
     * @param name :
     * @param is_male
     * @param age : age of the reptilian
     * @param weight : weight of the reptilian
     * @param height : height
     * @param moral
     * @param illnesses
     */
    public Reptilian(String name, boolean is_male, int age, int weight, int height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);}
}
