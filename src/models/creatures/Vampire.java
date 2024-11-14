package models.creatures;

import models.Illness;
import models.services.Service;

public class Vampire extends Creature {
    /**
     * Constructor of the class Vampire
     * @param name the name of a vampire
     * @param is_male the sexe of a vampire
     * @param age the age of a vampire
     * @param weight the weight of a vampire
     * @param height the height of a vampire
     * @param morale the morale of a vampire
     * @param illnesses the illnesses of a vampire
     */
    public Vampire(String name, boolean is_male, int age, float weight, float height, int morale, Illness[] illnesses) {
        super(name, is_male, age, weight, height, morale, illnesses);
    }

    /**
     * Second constructor of the class Vampire
     *
     * @param name      the name of a vampire
     * @param is_male   the sexe of a vampire
     * @param age       the age of a vampire
     * @param weight    the weight of a vampire
     * @param height    the height of a vampire
     * @param illnesses the illnesses of a vampire
     */
    public Vampire(String name, boolean is_male, int age, float weight, float height, Illness[] illnesses) {
        super(name, is_male, age, weight, height, illnesses);
    }

    /**
     * the vampire pass away, contaminate a creature, demoralize the creatures inside the service and revive
     */
    @Override
    public boolean passAway(Service service) {
        boolean isDead = super.passAway(service);
        if (isDead) {
            service.removeCreature(this);
            contaminate(service);
            demoralize(service);
            revive(service);
        }
        return isDead;
    }
}
