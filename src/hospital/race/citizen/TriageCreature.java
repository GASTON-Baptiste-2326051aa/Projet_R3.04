package hospital.race.citizen;

import hospital.entity.Patient;
import hospital.race.Race;
import hospital.services.Service;

/**
 * TriageCreature is an interface that represents a Triage creature.
 * TriageCreature is a marker interface.
 */
public interface TriageCreature extends Race, Patient {

    /**
     * The Patient wait a time
     */
    @Override
    default void waitATime(Service service) {
        boolean containsTriageCreature = false;
        for (Patient patient : service.getPatients()) {
            if (patient instanceof TriageCreature) {
                containsTriageCreature = true;
                break;
            }
        }
        if (containsTriageCreature) {
            setMorale(getMorale() - WAIT_MORALE/2);
        } else {
            setMorale(getMorale() - WAIT_MORALE);
        }
    }
}
