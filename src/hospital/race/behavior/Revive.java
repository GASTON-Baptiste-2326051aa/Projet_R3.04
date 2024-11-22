package hospital.race.behavior;

import hospital.services.Service;

/**
 * the Revive interface
 */
public interface Revive {
    /**
     * the creature revive
     * @param service the service where the creature revive
     */
    void revive(Service service);
}
