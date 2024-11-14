package models.creatures;

import models.Illness;
import models.services.Service;

public class Orc extends Creature {
    /**
     * Constructor of the class Orc
     * @param name the name of the orc
     * @param is_male the sexe of the orc
     * @param age the age of the orc
     * @param weight the weight of the orc
     * @param height the height of the orc
     * @param morale the morale of the orc
     * @param illnesses the illnesses of the orc
     */
    public Orc(String name, boolean is_male, int age, float weight, float height, int morale, Illness[] illnesses) {
        super(name, is_male, age, weight, height, morale, illnesses);
    }

    /**
     * Second constructor of the class Orc
     *
     * @param name      the name of the orc
     * @param is_male   the sexe of the orc
     * @param age       the age of the orc
     * @param weight    the weight of the orc
     * @param height    the height of the orc
     * @param illnesses the illnesses of the orc
     */
    public Orc(String name, boolean is_male, int age, float weight, float height, Illness[] illnesses) {
        super(name, is_male, age, weight, height, illnesses);
    }

    /**
     * the orc pass away and contaminate the creatures inside the service
     */
    @Override
    public boolean passAway(Service service) {
        boolean isDead = super.passAway(service);
        if (isDead) {
            service.removeCreature(this);
            contaminate(service);
        }
        return isDead;
    }
}
