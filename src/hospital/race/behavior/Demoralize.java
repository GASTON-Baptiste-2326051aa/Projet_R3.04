package hospital.race.behavior;

import hospital.entity.Patient;
import hospital.services.Service;

import java.util.Random;

/**
 * the Demoralize interface
 */
public interface Demoralize extends Patient {
    /**
     * the creature demoralize some of the creatures inside the service
     */
    default void demoralize()
    {
        Service service = getService();
        for (Patient patient : service.getPatients()) {
            if (patient==this){
                continue;
            }
            int rand = random.nextInt(100);
            if(rand<30){
                System.out.println(getName() + " demoralize " + patient.getName());
                if (patient.getMorale()>=5){
                    patient.setMorale(patient.getMorale()-10);
                }
                else{
                    patient.setMorale(-5);
                }
            }

        }

    }
    //Needed to test with controlled random
    /**
     * the creature demoralize some of the creatures inside the service
     * @param randomGenerator the random generator to use
     */
    default void demoralize(Random randomGenerator){
        Service service = getService();
        for (Patient patient : service.getPatients()) {
            if (patient == this) {
                continue;
            }
            int rand = randomGenerator.nextInt(100); // Utilisation de l'aléatoire injecté
            if (rand < 30) {
                System.out.println(getName() + " demoralize " + patient.getName());
                if (patient.getMorale() >= 5) {
                    patient.setMorale(patient.getMorale() - 10);
                } else {
                    patient.setMorale(-5);
                }
            }
        }
    }
}
