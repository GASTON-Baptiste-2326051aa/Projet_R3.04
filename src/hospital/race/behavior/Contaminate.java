package hospital.race.behavior;

import hospital.services.Service;

/**
 * the Contaminate interface
 */
public interface Contaminate {
    /**
     * the creature contaminate a part of the service
     * @param service the service to contaminate
     */
    default void contaminate(Service service){
        service.contaminate(this);
    }
}
