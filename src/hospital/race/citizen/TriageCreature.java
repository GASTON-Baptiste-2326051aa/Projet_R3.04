package hospital.race.citizen;

import hospital.entity.Patient;
import hospital.race.Race;

/**
 * TriageCreature is an interface that represents a Triage creature.
 * TriageCreature is a marker interface.
 */
public interface TriageCreature extends Race, Patient {
    @Override
    default void waitATime(){
        // TODO
    }
}
