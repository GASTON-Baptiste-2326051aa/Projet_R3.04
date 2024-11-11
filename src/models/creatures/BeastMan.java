package models.creatures;

import models.Illness;
import models.services.Service;

import java.util.Random;

public class BeastMan extends Creature {
    /**
     * Constructor of the class BeastMan
     * @param name the name of the beastman
     * @param is_male the sexe of the beastman
     * @param age the age of the beastman
     * @param weight the weight of the beastman
     * @param height the height of the beastman
     * @param moral the moral of the beastman
     * @param illnesses the illnesses of the beastman
     */
    public BeastMan(String name, boolean is_male, int age, float weight, float height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**
     * get all the mortal illnesses of the beastman
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
     * the beastman contaminate a creature of the service
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
     * the beastman pass away and contaminate the creatures inside the service
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
