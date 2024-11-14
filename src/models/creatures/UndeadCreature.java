package models.creatures;

import models.services.Service;


public interface UndeadCreature {
    /**
     * the creature revive
     * @param service
     */
    public void revive(Service service);
}
