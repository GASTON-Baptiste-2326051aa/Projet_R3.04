package models.creatures;

import models.Illness;
import models.services.Service;

public class Dwarf extends Creature {
    /**
     * Constructor of the class Dwarf
     * @param name the name of the dwarf
     * @param is_male the sexe of the dwarf
     * @param age the age of the dwarf
     * @param weight the weight of the dwarf
     * @param height the height of the dwarf
     * @param moral the moral of the dwarf
     * @param illnesses the illnesses of the dwarf
     */
    public Dwarf(String name, boolean is_male, int age, float weight, float height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**
     * Second constructor of the class Dwarf
     *
     * @param name      the name of the dwarf
     * @param is_male   the sexe of the dwarf
     * @param age       the age of the dwarf
     * @param weight    the weight of the dwarf
     * @param height    the height of the dwarf
     * @param illnesses the illnesses of the dwarf
     */
    public Dwarf(String name, boolean is_male, int age, float weight, float height, Illness[] illnesses) {
        super(name, is_male, age, weight, height, illnesses);
    }

    /**
     * the dwarf pass away
     */
    @Override
    public boolean passAway(Service service) {
        boolean isDead = super.passAway(service);
        if (isDead)
            service.removeCreature(this);
        return isDead;
    }
}
