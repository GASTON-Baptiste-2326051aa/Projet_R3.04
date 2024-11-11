package models.creatures;

import models.Illness;
import models.services.Service;

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
     * the zombie revive
     */
    private void revive(Service service) {
        service.addCreature(this);
        System.out.println(this.getName() + " revive");
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
}
