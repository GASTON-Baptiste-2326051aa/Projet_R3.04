package models.creatures;

import models.Illness;
import models.services.Service;

public class Reptilian extends Creature {
    /**
     * Constructor of the class Reptilian
     * @param name the name of the reptilian
     * @param is_male the sexe of the reptilian
     * @param age the age of the reptilian
     * @param weight the weight of the reptilian
     * @param height the height of the reptilian
     * @param moral the moral of the reptilian
     * @param illnesses the illnesses of the reptilian
     */
    public Reptilian(String name, boolean is_male, int age, int weight, int height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**
     * the reptilian pass away
     */
    @Override
    public boolean passAway(Service service) {
        boolean isDead = super.passAway(service);
        if (isDead)
            service.removeCreature(this);
        return isDead;
    }
}
