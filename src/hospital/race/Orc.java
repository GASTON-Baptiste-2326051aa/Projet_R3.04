package hospital.race;

import hospital.illness.Illness;
import hospital.race.citizen.TriageCreature;
import hospital.race.type.BestialCreature;
import hospital.services.Service;

import java.util.Random;

public class Orc extends Creature implements BestialCreature, TriageCreature {
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

    @Override
    public void waitATime() {

    }
}
