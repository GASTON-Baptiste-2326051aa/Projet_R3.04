package hospital.entity.patient;

import hospital.entity.Creature;
import hospital.entity.Patient;
import hospital.illness.Illness;
import hospital.illness.SetIllness;
import hospital.race.BeastMan;
import hospital.services.Service;

public class PatientBeastMan extends Creature implements Patient, BeastMan {
    private int morale;
    private boolean isAlive;
    private SetIllness illnesses;
    private Service service;


    public PatientBeastMan(String name, boolean isMale, int age, float weight, float height, int morale, SetIllness illnesses) {
        super(name, isMale, age, weight, height);
        this.morale = morale;
        this.illnesses = illnesses;
    }

    public PatientBeastMan(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
        this.morale = MORALE_MAX;
        this.illnesses = new SetIllness();
    }


    public PatientBeastMan(String name, boolean isMale, int age) {
        super(name, isMale, age);
        this.morale = MORALE_MAX;
        this.illnesses = new SetIllness();
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
     * The morale of the patient
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
    public SetIllness getIllnesses() {
        return this.illnesses;
    }

    /**
     * Set the illnesses of the patient
     *
     * @param illnesses the illnesses of the patient
     */
    @Override
    public void setIllnesses(SetIllness illnesses) {
        this.illnesses = illnesses;
    }
}
