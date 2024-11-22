package hospital.entity;

import hospital.illness.Illness;

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
     * The morale of the patient
     */
    int getMorale();

    /**
     * Set the morale of the patient
     * @param morale the morale of the patient
     */
    void setMorale(int morale);

    /**
     * The illnesses of the patient
     * @return the illnesses of the patient
     */
    Illness[] getIllnesses();

    /**
     * Set the illnesses of the patient
     * @param illnesses the illnesses of the patient
     */
    void setIllnesses(Illness[] illnesses);

    /**
     * Add an illness to the patient
     * @param illness the illness to add
     */
    void addIllness(Illness illness);

    /**
     * Remove an illness from the patient
     * @param illness the illness to remove
     */
    void removeIllness(Illness illness);

    /**
     * The patient screams
     */
    void scream();

    /**
     * The patient waits
     */
    void waitATime();

    /**
     * The patient passes away
     */
    void passAway();

    /**
     * The patient is carried away
     */
    void carriedAway();
}
