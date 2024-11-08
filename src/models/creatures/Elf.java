package models.creatures;
import models.Illness;

public class Elf extends Creature {


    /**
     * Constructor for the class Elf
     * @param name the name of the elf
     * @param is_male the sexe of the elf
     * @param age the age of the elf
     * @param weight the weight of the elf
     * @param height the height of the elf
     * @param moral the moral of the elf
     * @param illnesses the illnesses of the elf
     */
    public Elf(String name, boolean is_male, int age, float weight, float height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**

     */
    public void demoralize(){

    }
}
