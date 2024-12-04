package hospital.entity.patient;

import hospital.entity.Creature;
import hospital.entity.Patient;
import hospital.illness.Illness;
import hospital.race.BeastMan;
import hospital.services.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * The `PatientBeastMan` class represents a patient of the BeastMan race.
 */
public class PatientBeastMan extends Creature implements Patient, BeastMan {
    /**
     * The morale of the patient.
     */
    private int morale;
    /**
     * The status of the patient.
     */
    private boolean isAlive;
    /**
     * The illnesses of the patient.
     */
    private Set<Illness> illnesses;
    /**
     * The service where the patient is.
     */
    private Service service;


    /**
     * Constructs a `PatientBeastMan` with specified attributes.
     * @param name the name of the patient
     * @param isMale the sex of the patient
     * @param age the age of the patient
     * @param weight the weight of the patient
     * @param height the height of the patient
     * @param morale the morale of the patient
     * @param illnesses the illnesses of the patient
     */
    public PatientBeastMan(String name, boolean isMale, int age, float weight, float height, int morale, Set<Illness> illnesses) {
        super(name, isMale, age, weight, height);
        this.morale = morale;
        this.illnesses = illnesses;
    }

    /**
     * Constructs a `PatientBeastMan` with specified attributes and default morale and illnesses.
     * @param name the name of the patient
     * @param isMale the sex of the patient
     * @param age the age of the patient
     * @param weight the weight of the patient
     * @param height the height of the patient
     */
    public PatientBeastMan(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
        this.morale = MORALE_MAX;
        this.illnesses = new HashSet<>();
    }

    /**
     * Constructs a `PatientBeastMan` with specified attributes and default weight, height, morale, and illnesses.
     * @param name the name of the patient
     * @param isMale the sex of the patient
     * @param age the age of the patient
     */
    public PatientBeastMan(String name, boolean isMale, int age) {
        super(name, isMale, age);
        this.morale = MORALE_MAX;
        this.illnesses = new HashSet<>();
    }
    /**
     * @return Service where the patient is .
     */
    @Override
    public Service getService() {
        return this.service;
    }
    /**
     * @param service where the patient is added
     */
    @Override
    public void setService(Service service){
        this.service = service;
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
     * @return if the patient is alive
     */
    @Override
    public boolean getIsAlive() {
        return this.isAlive;
    }

    /**
     *
     * @param b the status of the patient
     */
    @Override
    public void setIsAlive(boolean b) {
        this.isAlive = b;
    }


    /**
     * Set the morale of the patient
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
    public Set<Illness> getIllnesses() {
        return this.illnesses;
    }

    /**
     * Sets the illnesses of the patient.
     * @param illnesses the illnesses of the patient
     */
    @Override
    public void setIllnesses(Set<Illness> illnesses) {
        this.illnesses = illnesses;
    }
}