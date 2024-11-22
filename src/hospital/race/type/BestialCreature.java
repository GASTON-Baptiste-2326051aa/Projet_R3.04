package hospital.race.type;

import hospital.services.Service;

public interface BestialCreature {
    /**
     * the creature contaminate another creature of the service
     * @param service
     */
    public void contaminate(Service service);
}
