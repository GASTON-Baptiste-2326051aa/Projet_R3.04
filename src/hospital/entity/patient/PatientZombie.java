package hospital.entity.patient;

import hospital.entity.Creature;
import hospital.entity.Patient;
import hospital.illness.Illness;
import hospital.race.Zombie;
import hospital.services.Service;

import java.util.HashSet;
import java.util.Set;


public class PatientZombie extends Creature implements Patient, Zombie {
    private int morale;
    private boolean isAlive;
    private Set<Illness> illnesses;
    private Service service;


    public PatientZombie(String name, boolean isMale, int age, float weight, float height, int morale, Set<Illness> illnesses) {
        super(name, isMale, age, weight, height);
        this.morale = morale;
        this.illnesses = illnesses;
    }

    public PatientZombie(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
        this.morale = MORALE_MAX;
        this.illnesses = new HashSet<>();
    }

    public PatientZombie(String name, boolean isMale, int age) {
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
    public void setService(Service service) {
        this.service = service;
    }
    @Override
    public boolean getIsAlive() {
        return this.isAlive;
    }

    /**
     * @param b the status of the patient
     */
    @Override
    public void setIsAlive(boolean b) {
        this.isAlive = b;
    }
    /**
     * The morale of the patient
     */
    @Override
    public int getMorale() {
        return this.morale;
    }

    /**
     * Set the morale of the patient
     *
     * @param morale the morale of the patient
     */
    @Override
    public void setMorale(int morale) {
        this.morale = morale;
    }

    /**
     * The illnesses of the patient
     *
     * @return the illnesses of the patient
     */
    @Override
    public Set<Illness> getIllnesses() {
        return this.illnesses;
    }

    /**
     * Set the illnesses of the patient
     *
     * @param illnesses the illnesses of the patient
     */
    @Override
    public void setIllnesses(Set<Illness> illnesses) {
        this.illnesses = illnesses;
    }
}
