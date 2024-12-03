package hospital.entity.patient;

import hospital.entity.Creature;
import hospital.entity.Patient;
import hospital.illness.Illness;
import hospital.illness.SetIllness;
import hospital.race.Werewolf;

/**
 * The `PatientWerewolf` class represents a patient of the Werewolf race.
 */
public class PatientWerewolf extends Creature implements Patient, Werewolf {
    /**
     * The morale of the patient.
     */
    private int morale;

    /**
     * The illnesses of the patient.
     */
    private SetIllness illnesses;

    /**
     * Constructs a `PatientWerewolf` with specified attributes.
     * @param name the name of the patient
     * @param isMale the sex of the patient
     * @param age the age of the patient
     * @param weight the weight of the patient
     * @param height the height of the patient
     * @param morale the morale of the patient
     * @param illnesses the illnesses of the patient
     */
    public PatientWerewolf(String name, boolean isMale, int age, float weight, float height, int morale, SetIllness illnesses) {
        super(name, isMale, age, weight, height);
        this.morale = morale;
        this.illnesses = illnesses;
    }

    /**
     * Constructs a `PatientWerewolf` with specified attributes and default morale and illnesses.
     * @param name the name of the patient
     * @param isMale the sex of the patient
     * @param age the age of the patient
     * @param weight the weight of the patient
     * @param height the height of the patient
     */
    public PatientWerewolf(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
        this.morale = MORALE_MAX;
        this.illnesses = new SetIllness();
    }

    /**
     * Constructs a `PatientWerewolf` with specified attributes and default weight, height, morale, and illnesses.
     * @param name the name of the patient
     * @param isMale the sex of the patient
     * @param age the age of the patient
     */
    public PatientWerewolf(String name, boolean isMale, int age) {
        super(name, isMale, age);
        this.morale = MORALE_MAX;
        this.illnesses = new SetIllness();
    }

    /**
     * Gets the morale of the patient.
     * @return the morale of the patient
     */
    @Override
    public int getMorale() {
        return this.morale;
    }

    /**
     * Sets the morale of the patient.
     * @param morale the morale of the patient
     */
    @Override
    public void setMorale(int morale) {
        this.morale = morale;
    }

    /**
     * Gets the illnesses of the patient.
     * @return the illnesses of the patient
     */
    @Override
    public SetIllness getIllnesses() {
        return this.illnesses;
    }

    /**
     * Sets the illnesses of the patient.
     * @param illnesses the illnesses of the patient
     */
    @Override
    public void setIllnesses(SetIllness illnesses) {
        this.illnesses = illnesses;
    }
}