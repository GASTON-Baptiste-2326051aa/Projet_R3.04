package hospital.race.behavior;

import hospital.services.Service;

/**
 * the Demoralize interface
 */
public interface Demoralize {
    /**
     * the creature demoralize some of the creatures inside the service
     * @param service the service to demoralize
     */
    void demoralize(Service service);
}
