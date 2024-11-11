package models.creatures;

import models.Illness;
import models.services.Service;

import java.util.Random;

public class Lycanthrope extends Creature {
    /**
     * Constructor of the class Lycanthrope
     * @param name the name of the lycanthrope
     * @param is_male the sexe of the lycanthrope
     * @param age the age of the lycanthrope
     * @param weight the weight of the lycanthrope
     * @param height the height of the lycanthrope
     * @param moral the moral of the lycanthrope
     * @param illnesses the illnesses of the lycanthrope
     */
    public Lycanthrope(String name, boolean is_male, int age, float weight, float height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**
     * get all the mortal illnesses of the lycanthrope
     *
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
    public void contaminate(Service service) {
        Random random = new Random();
        Illness illness = getMortalIllnesses()[random.nextInt(getMortalIllnesses().length)];
        for (Creature creature : service.getCreatures()) {
            if (random.nextBoolean()) {
                creature.addIllness(illness);
                break;
            }
        }
    }

    /**
     * the lycanthrope pass away and contaminate the creatures inside the service
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
