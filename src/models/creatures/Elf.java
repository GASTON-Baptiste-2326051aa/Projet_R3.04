package models.creatures;
import models.Illness;
import models.services.Service;

public class Elf extends Creature {
    /**
     * Constructor for the class Elf
     * @param name the name of the elf
     * @param is_male the sexe of the elf
     * @param age the age of the elf
     * @param weight the weight of the elf
     * @param height the height of the elf
     * @param moral the moral of the elf
     * @param illnesses the illnesses of the elf
     */
    public Elf(String name, boolean is_male, int age, float weight, float height, int moral, Illness[] illnesses) {
        super(name, is_male, age, weight, height, moral, illnesses);
    }

    /**
     * the elf pass away and demoralize the creatures inside the service
     */
    @Override
    public boolean passAway(Service service) {
        boolean isDead = super.passAway(service);
        if (isDead) {
            service.removeCreature(this);
            demoralize(service);
        }
        return isDead;
    }
}
