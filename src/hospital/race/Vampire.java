package hospital.race;

import hospital.race.behavior.Contaminate;
import hospital.race.behavior.Demoralize;
import hospital.race.behavior.Revive;
import hospital.race.citizen.VIPCreature;

/**
 * Vampire
 */
public interface Vampire extends VIPCreature, Contaminate, Demoralize, Revive {
}
