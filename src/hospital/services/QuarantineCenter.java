package hospital.services;

import hospital.Hospital;
import hospital.entity.Patient;
import hospital.entity.PatientCollection;
import hospital.race.behavior.Contaminate;

/**
 * QuarantineCenter
 */
public class QuarantineCenter extends Service {
    private boolean isolation;

    /**
     * Constructor of a quarantine center
     * @param name the name of the quarantine center
     * @param surface the surface of the center
     * @param creatureMax the max number of creatures
     * @param budget the budget of the center
     */
    public QuarantineCenter(String name, float surface, int creatureMax, int budget, Hospital hospital) {
        super(name, surface, creatureMax, budget, hospital);
        this.isolation = false;
    }

    /**
     * Check if the center is in isolation
     *
     * @return true if the center is isolated, false otherwise
     */
    public boolean isIsolate() {
        return isolation;
    }

    /**
     * Set the isolation state of the center
     * @param isolation the new isolation state
     */
    public void setIsolation(boolean isolation) {
        this.isolation = isolation;
    }

    /**
     * Override the addCreature method to ensure only contagious creatures can be added
     * @param creature a creature to add
     */
    @Override
    public void addCreature(Patient creature) throws IllegalArgumentException {
        if (creature instanceof Contaminate) { //Il faut tester si c'est une créature bestiale
            super.addCreature(creature);
        } else {
            System.out.println("Only contagious creatures are allowed in a quarantine center.");
            throw new IllegalArgumentException("Only contagious creatures are allowed in a quarantine center");
        }
    }

    /**
     * Override the setCreatures method to ensure only contagious creatures can be added
     * @param creatures all the creature inside a service
     */
    @Override
    public void setCreatures(PatientCollection creatures) {
        for (Patient creature : creatures) {
            if (!(creature instanceof Contaminate)) {
                System.out.println("Only contagious creatures are allowed in a quarantine center.");
                throw new IllegalArgumentException("Only contagious creatures are allowed in a quarantine center");
            }
        }
        super.setCreatures(creatures);
    }

    /**
     * Override the budget revision to include the isolation factor
     */
    @Override
    public void setBudget(int budget) {
        if(isolation) {
            super.setBudget((int) (budget * 1.1));
        }
        else {
            super.setBudget(budget);
        }
    }

    /**
     * Return the string representation of the quarantine center
     * @return the string representation of the quarantine center
     */
    @Override
    public String toString() {
        return "QuarantineCenter{" +
                "name=" + getName() +
                ", surface=" + getSurface() +
                ", creatureMax=" + getCreatureMax() +
                ", creatureNow=" + getCreatureNow() +
                ", budget=" + budgetToString(getBudget()) +
                ", isolation=" + isolation +
                "}";
    }
}
