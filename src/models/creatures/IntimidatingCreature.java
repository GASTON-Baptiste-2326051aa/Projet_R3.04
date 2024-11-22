package models.creatures;

import models.services.Service;

public interface IntimidatingCreature {
    /**
     * the creature demoralize some of the creatures inside the service
     * @param service
     */
    void demoralize(Service service);
}
