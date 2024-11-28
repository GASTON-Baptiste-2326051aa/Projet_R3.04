package hospital.entity.patient;

import hospital.entity.Creature;
import hospital.entity.Patient;
import hospital.illness.Illness;
import hospital.illness.SetIllness;
import hospital.race.Elf;
import hospital.services.Service;

public class PatientElf extends Creature implements Patient, Elf {

    public int morale;
    public SetIllness illnesses;

    public PatientElf(String name, boolean isMale, int age, float weight, float height, int morale, SetIllness illnesses) {
        super(name, isMale, age, weight, height);
        this.morale = morale;
        this.illnesses = illnesses;
    }

    public PatientElf(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
        this.morale = MORALE_MAX;
        this.illnesses = new SetIllness();
    }

    public PatientElf(String name, boolean isMale, int age) {
        super(name, isMale, age);
        this.morale = MORALE_MAX;
        this.illnesses = new SetIllness();
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

    /**
     * Add an illness to the patient
     *
     * @param illness the illness to add
     */
    @Override
    public void addIllness(Illness illness) {
        if (this.illnesses == null) {
            this.illnesses = new SetIllness();
        }
        this.illnesses.add(illness);
    }

    /**
     * Remove an illness from the patient
     *
     * @param illness the illness to remove
     */
    @Override
    public void removeIllness(Illness illness) {
        if (this.illnesses != null) {
            this.illnesses.remove(illness);
        }
    }

    /**
     * The patient screams
     */
    @Override
    public void scream() {

    }

    /**
     * The patient waits
     */
    @Override
    public void waitATime() {

    }

    /**
     * The patient passes away
     */
    @Override
    public void passAway() {

    }

    /**
     * The patient is carried away
     */
    @Override
    public void carriedAway() {

    }

    /**
     * the creature contaminate a part of the service
     *
     * @param service the service to contaminate
     */
    @Override
    public void contaminate(Service service) {
        service.contaminate(this);
    }
    /**
     * Thread of the patient
     */
    @Override
    public void run() {
    }
}
