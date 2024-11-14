package models.creatures;

import models.Illness;
import models.services.Service;

import java.util.Random;

public class BeastMan extends Creature implements BestialCreature, TriageCreature {
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
     * the creature contaminate another creature of the service
     * @param service
     */
    @Override
    public void contaminate(Service service) {
        Illness illness = getMortalIllnesses()[random.nextInt(getMortalIllnesses().length)];
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        for (Creature creature : service.getCreatures()) {
            if (random.nextInt() < 21) {
                creature.addIllness(illness);
                System.out.println(getName() + "infects another creature !");
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

    @Override
    public void waitATime() {

    }
}
