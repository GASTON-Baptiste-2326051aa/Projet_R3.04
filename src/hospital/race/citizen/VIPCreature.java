package hospital.race.citizen;

import hospital.entity.Patient;
import hospital.race.Race;

/**
 * VIPCreature is an interface that represents a VIP creature.
 * VIPCreature is a marker interface.
 */
public interface VIPCreature extends Race, Patient {
    @Override
    default void waitATime(){
        // TODO
    }
}
