package hospital.race.behavior;

import hospital.entity.Patient;

/**
 * the Revive interface
 */
public interface Revive extends Patient {
    /**
     * the creature revive
     */
    default void revive() {
        System.out.println(getName() + " revives...");
        getService().addPatient(this);
        this.setIsAlive(true);
    }
}
