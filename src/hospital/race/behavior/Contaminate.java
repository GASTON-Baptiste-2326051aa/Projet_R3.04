package hospital.race.behavior;

import hospital.entity.Patient;
import hospital.illness.Illness;
import hospital.services.Service;

/**
 * the Contaminate interface
 */
public interface Contaminate extends Patient {
    /**
     * the creature contaminate a part of the service
     */
    default void contaminate() throws IllegalStateException {
        Service service = getService();
        Patient patient = service.getPatients().toArray(new Patient[]{})[random.nextInt(service.getPatients().size())];
        while (patient == this) {
            patient = service.getPatients().toArray(new Patient[]{})[random.nextInt(service.getPatients().size())];
        }
        int nbIllnesses = getIllnesses().size();
        if(nbIllnesses > 0){
            patient.addIllness(getIllnesses().toArray(new Illness[]{})[random.nextInt(nbIllnesses)]);
            System.out.println(getName() + " contaminates " + patient.getName() + "...");
        }
        else {
            throw new IllegalStateException("The creature has no illness to contaminate");
        }

    }
}
