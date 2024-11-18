package models.creatures;

import models.services.Service;

public interface BestialCreature {
    /**
     * the creature contaminate another creature of the service
     * @param service
     */
    public void contaminate(Service service);
}
