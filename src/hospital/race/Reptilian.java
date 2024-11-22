package hospital.race;

import hospital.illness.Illness;
import hospital.race.citizen.VIPCreature;
import hospital.services.Service;

public class Reptilian extends Creature implements VIPCreature {
    /**
     * Constructor of the class Reptilian
     * @param name the name of the reptilian
     * @param is_male the sexe of the reptilian
     * @param age the age of the reptilian
     * @param weight the weight of the reptilian
     * @param height the height of the reptilian
     * @param morale the morale of the reptilian
     * @param illnesses the illnesses of the reptilian
     */
    public Reptilian(String name, boolean is_male, int age, float weight, float height, int morale, Illness[] illnesses) {
        super(name, is_male, age, weight, height, morale, illnesses);
    }

    /**
     * Second constructor of the class Reptilian
     *
     * @param name      the name of the reptilian
     * @param is_male   the sexe of the reptilian
     * @param age       the age of the reptilian
     * @param weight    the weight of the reptilian
     * @param height    the height of the reptilian
     * @param illnesses the illnesses of the reptilian
     */
    /*public Reptilian(String name, boolean is_male, int age, float weight, float height, Illness[] illnesses) {
        super(name, is_male, age, weight, height, illnesses);
    }*/

    /**
     * the reptilian pass away
     */
    @Override
    public boolean passAway(Service service) {
        boolean isDead = super.passAway(service);
        if (isDead)
            service.removeCreature(this);
        return isDead;
    }

    @Override
    public void waitATime() {

    }
}
