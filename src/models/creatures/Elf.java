package models.creatures;
import models.Creature;
import models.Illness;

public class Elf extends Creature {


    /**
     * Constructor for the class Elf
     * @param name
     * @param is_male
     * @param age
     * @param weight
     * @param height
     * @param moral
     * @param illnesses
     */
    public Elf(String name, boolean is_male, int age, float weight, float height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**

     */
    public void demoralize(){

    }
}
