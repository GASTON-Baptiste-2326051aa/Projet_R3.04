package hospital.entity;

import hospital.illness.Illness;
import hospital.illness.Illnesses;
import hospital.illness.SetIllness;
import hospital.services.Service;

import java.util.ArrayList;
import java.util.List;

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
    SetIllness getIllnesses();

    /**
     * Set the illnesses of the patient
     * @param illnesses the illnesses of the patient
     */
    void setIllnesses(SetIllness illnesses);

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
        else
            System.out.println(this + " wait a time...");
        this.setMorale(getMorale() - WAIT_MORALE);
    }

    /**
     * The patient passes away
     */
    default void passAway() {
        System.out.println(this.getName() + " pass away");
        getService().removePatient((Patient) this);
    }

    /**
     * The patient is getting carried away
     */
    default void carriedAway(Service from, Service to) {
        System.out.println(this + " is getting carried away...");
        from.removePatient((Patient) this);
        to.addPatient((Patient) this);
    }

    /**
     * return true if the patient is dead, false otherwise
     * @return true if the patient is dead, false otherwise
     */
    default boolean is_dead() {
        for (Illness illness : getIllnesses()) {
            if (illness.is_mortal() && random.nextInt(illness.getLvlMax()) == 0) {
                return true;
            }
        } return false;
    }

    /**
     * The Patient do things
     */
    default void run() {
        waitATime();
        if (random.nextBoolean())
            getIllnesses().toArray(new Illness[Illnesses.values().length])[random.nextInt(getIllnesses().size())].increase();
        if (is_dead()) {
            passAway();
        }
    }

    /**
     * Compare two patients according to their morale
     *
     * @param patient the other patient
     * @return true if this patient has a lower morale than the other patient
     */
    default boolean compareMorale(Patient patient) {
        return this.getMorale() < patient.getMorale();
    }

    /**
     * Compare two patients according to their illness level
     *
     * @param patient the other patient
     * @return true if this patient has a higher illness level than the other patient
     */
    default boolean compareIllnessLevel(Patient patient) {
        return this.getIllnesses().getIllnessesLvlSum() > patient.getIllnesses().getIllnessesLvlSum();
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
