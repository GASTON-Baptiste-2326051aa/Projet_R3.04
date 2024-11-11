package models.creatures;

import models.Illness;
import models.services.Service;

import java.util.Random;

public class Vampire extends Creature {
    /**
     * the decrease of the moral of the creatures inside the service
     */
    private static final int DEMORALIZE_DECREASE = 5;

    /**
     * Constructor of the class Vampire
     * @param name the name of a vampire
     * @param is_male the sexe of a vampire
     * @param age the age of a vampire
     * @param weight the weight of a vampire
     * @param height the height of a vampire
     * @param moral the moral of a vampire
     * @param illnesses the illnesses of a vampire
     */
    public Vampire(String name, boolean is_male, int age, int weight, int height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses); }

    /**
     * While passing away, demoralizes a part of the creature inside the medical service
     */
    private void demoralize(Service service) {
        for (Creature creature : service.getCreatures()) {
            creature.setMoral(creature.getMoral() - DEMORALIZE_DECREASE);
        }
    }

    /**
     * get all the mortal illnesses of the lycanthrope
     * @return an array of mortal illnesses
     */
    private Illness[] getMortalIllnesses() {
        Illness[] mortalIllnesses = new Illness[getIllnesses().length];
        int i = 0;
        for (Illness illness : this.getIllnesses()) {
            if (illness.is_mortal()) {
                mortalIllnesses[i++] = illness;
            }
        }
        return mortalIllnesses;
    }

    /**
     * the lycanthrope contaminate a creature of the service
     */
    private void contaminate(Service service) {
        Random random = new Random();
        Illness illness = getMortalIllnesses()[random.nextInt(getMortalIllnesses().length)];
        for (Creature creature : service.getCreatures()) {
            if (random.nextBoolean()) {
                creature.addIllness(illness);
                System.out.println(getName() + "infects another creature !");
                break;
            }
        }
    }

    /**
     * the vampire revive
     */
    private void revive(Service service) {
        service.addCreature(this);
        System.out.println(this.getName() + " revive");
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
