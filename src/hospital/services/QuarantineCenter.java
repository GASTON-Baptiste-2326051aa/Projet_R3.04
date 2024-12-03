package hospital.services;

import hospital.Hospital;
import hospital.entity.Patient;
import hospital.race.behavior.Contaminate;

import java.util.Collection;

/**
 * The `QuarantineCenter` class represents a quarantine center service.
 */
public class QuarantineCenter extends Service {
    /**
     * Indicates if the center is in isolation.
     */
    private boolean isolation;

    /**
     * Constructs a `QuarantineCenter` with specified attributes.
     * @param name the name of the quarantine center
     * @param surface the surface of the center
     * @param creatureMax the max number of creatures
     * @param budget the budget of the center
     * @param hospital the hospital to which the center belongs
     */
    public QuarantineCenter(String name, float surface, int creatureMax, int budget, Hospital hospital) {
        super(name, surface, creatureMax, budget, hospital);
        this.isolation = false;
    }

    /**
     * Checks if the center is in isolation.
     * @return true if the center is isolated, false otherwise
     */
    public boolean isIsolate() {
        return isolation;
    }

    /**
     * Sets the isolation state of the center.
     * @param isolation the new isolation state
     */
    public void setIsolation(boolean isolation) {
        this.isolation = isolation;
    }

    /**
     * Adds a creature to the quarantine center, ensuring only contagious creatures can be added.
     * @param creature a creature to add
     * @throws IllegalArgumentException if the creature is not contagious
     */
    @Override
    public void addPatient(Patient creature) throws IllegalArgumentException {
        if (creature instanceof Contaminate) { //Il faut tester si c'est une créature bestiale
            super.addPatient(creature);
        } else {
            System.out.println("Only contagious creatures are allowed in a quarantine center.");
            throw new IllegalArgumentException("Only contagious creatures are allowed in a quarantine center");
        }
    }

    /**
     * Sets the creatures in the quarantine center, ensuring only contagious creatures can be added.
     * @param patients all the creatures inside the service
     * @throws IllegalArgumentException if any creature is not contagious
     */
    @Override
    public void setPatients(Collection<Patient> patients)
    {
        for (Patient patient : patients) {
            if (!(patient instanceof Contaminate)) {
                System.out.println("Only contagious creatures are allowed in a quarantine center.");
                throw new IllegalArgumentException("Only contagious creatures are allowed in a quarantine center");
            }
        }
        super.setPatients(patients);
    }


    /**
     * Sets the budget of the quarantine center, including the isolation factor.
     * @param budget the new budget
     */
    @Override
    public void setBudget(int budget) {
        if (isolation) {
            super.setBudget((int) (budget * 1.1));
        } else {
            super.setBudget(budget);
        }
    }

    /**
     * @return the string representation of the quarantine center
     */
    @Override
    public String toString() {
        return "QuarantineCenter{" +
                "name=" + getServiceName() +
                ", surface=" + getSurface() +
                ", patientMax=" + getPatientMax() +
                ", patientNow=" + getPatientNow() +
                ", budget=" + budgetToString(getBudget()) +
                ", isolation=" + isolation +
                "}";
    }
}