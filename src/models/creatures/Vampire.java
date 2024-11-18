package models.creatures;

import models.Illness;
import models.services.Service;

import java.util.Random;

public class Vampire extends Creature implements UndeadCreature, BestialCreature {
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
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**
     * the creature revive
     */
    @Override
    public void revive(Service service){
        service.addCreature(this);
        System.out.println(this.getName() + " revive !");
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
}
