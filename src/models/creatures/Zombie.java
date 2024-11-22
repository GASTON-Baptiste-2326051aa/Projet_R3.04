package models.creatures;

import models.Illness;
import models.services.Service;

public class Zombie extends Creature implements TriageCreature{
    /**
     * Constructor of the class Zombie
     * @param name the name of a zombie
     * @param is_male the gender of a zombie
     * @param age the age of a Zombie
     * @param weight the weight of a Zomboe
     * @param height the height of a zombie
     * @param morale the morale of a zombie
     * @param illnesses the illnesses of a zombie
     */
    public Zombie(String name, boolean is_male, int age, float weight, float height, int morale, Illness[] illnesses) {
        super(name, is_male, age, weight, height, morale, illnesses);
    }

    /**
     * Second constructor of the class Zombie
     *
     * @param name      the name of a zombie
     * @param is_male   the sexe of a zombie
     * @param age       the age of a zombie
     * @param weight    the weight of a zombie
     * @param height    the height of a zombie
     * @param illnesses the illnesses of a zombie
     */
    public Zombie(String name, boolean is_male, int age, float weight, float height, Illness[] illnesses) {
        super(name, is_male, age, weight, height, illnesses);
    }

    /**
     * the zombie pass away and revive
     */
    @Override
    public boolean passAway(Service service) {
        boolean isDead = super.passAway(service);
        if (isDead) {
            service.removeCreature(this);
            revive(service);
        }
        return isDead;
    }

    @Override
    public void waitATime() {

    }
}
