package hospital.entity;

import hospital.illness.Illness;
import hospital.illness.Illnesses;
import hospital.services.Service;

import java.util.Set;

/**
 * The Patient interface
 */
public interface Patient extends Entity {
    /**
     * The maximum morale
     */
    int MORALE_MAX = 100;
    /**
     * The scream morale
     */
    int MORALE_SCREAM = 0;
    /**
     * The minimum morale
     */
    int MORALE_MIN = -5;
    /**
     * The ammount of morale than the creature lose while waiting
     */
    int WAIT_MORALE = 2;

    /**
     * The morale of the patient
     */
    int getMorale();

    boolean getIsAlive();
    void setIsAlive(boolean b);
    Service getService();
    void setService(Service service);
    /**
     * Set the morale of the patient
     * @param morale the morale of the patient
     */
    void setMorale(int morale);

    /**
     * The illnesses of the patient
     *
     * @return the illnesses of the patient
     */
    Set<Illness> getIllnesses();

    /**
     * Set the illnesses of the patient
     *
     * @param illnesses the illnesses of the patient
     */
    void setIllnesses(Set<Illness> illnesses);

    /**
     * Add an illness to the patient
     *
     * @param illness the illness to add
     */
    default void addIllness(Illness illness) {
        getIllnesses().add(illness);
    }

    /**
     * Remove an illness from the patient
     *
     * @param illness the illness to remove
     */
    default void removeIllness(Illness illness) {
        getIllnesses().remove(illness);
    }

    /**
     * The patient screams
     */
    default void scream() {
        System.out.println(this.getName() + " screams...");
    }

    /**
     * The patient waits
     */
    default void waitATime() {
        if (getMorale() <= MORALE_SCREAM)
            scream();
        else if (getMorale() == MORALE_MIN) {
            agonise();
        } else
            System.out.println(this + " wait a time...");
        this.setMorale(getMorale() - WAIT_MORALE);
    }

    /**
     * The patient passes away
     */
    default void passAway() {
        System.out.println(this.getName() + " pass away");
        getService().removePatient(this);
        setIsAlive(false);
    }

    /**
     * The patient is getting carried away
     */
    default void agonise() {
        int screamCount = 0;
        System.out.println(this.getName() + " is agonising");
        while (getMorale() == MORALE_MIN && screamCount < 5) {
            scream();
            screamCount++;
        }

    }

    /**
     * The Patient do things
     */
    default void run() {
        waitATime();
        if (random.nextBoolean())
            getIllnesses().toArray(new Illness[Illnesses.values().length])[random.nextInt(getIllnesses().size())].increase();
        for (Illness illness : getIllnesses()) {
            if (illness.is_mortal() && random.nextInt(illness.getLvlMax()) == 0) {
                passAway();
            }
        }
    }

    /**
     * Compare two patients according to their morale
     *
     * @param patient the other patient
     * @return true if this patient has a lower morale than the other patient
     */
    default boolean compareMorale(Patient patient) {
        return this.getMorale() > patient.getMorale();
    }
    /**
     * return the sum of the levels of the illnesses
     * @return the sum of the levels of the illnesses
     */
    default int getIllnessesLvlSum() {
        int sum = 0;
        for (Illness illness : getIllnesses()) {
            sum += illness.getLvl();
        }
        return sum;
    }


    /**
     * Compare two patients according to their illness level
     *
     * @param patient the other patient
     * @return true if this patient has a higher illness level than the other patient
     */
    default boolean compareIllnessLevel(Patient patient) {
        return getIllnessesLvlSum() > patient.getIllnessesLvlSum();
    }

    /**
     * Compare two patients according to their morale and illness level
     *
     * @param patient the other patient
     * @return true if this patient has a lower morale and a higher illness level than the other patient
     */
    default boolean compareMoraleAndIllnessLevel(Patient patient) {
        return this.compareIllnessLevel(patient) & this.compareMorale(patient);
    }
}
