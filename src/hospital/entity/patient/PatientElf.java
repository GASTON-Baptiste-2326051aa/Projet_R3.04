package hospital.entity.patient;

import hospital.entity.Creature;
import hospital.entity.Patient;
import hospital.illness.Illness;
import hospital.race.Elf;
import hospital.services.Service;

public class PatientElf extends Creature implements Patient, Elf {

    public int morale;
    public Illness[] illnesses;

    public PatientElf(String name, boolean isMale, int age, int weight, int height, int morale, Illness[] illnesses) {
        super(name, isMale, age, weight, height);
        this.morale = morale;
        this.illnesses = illnesses;
    }

    public PatientElf(String name, boolean isMale, int age, int weight, int height) {
        super(name, isMale, age, weight, height);
        this.morale = MORALE_MAX;
        this.illnesses = new Illness[Illness.AMOUNT];
    }

    public PatientElf(String name, boolean isMale, int age) {
        super(name, isMale, age);
        this.morale = MORALE_MAX;
        this.illnesses = new Illness[Illness.AMOUNT];
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
    public Illness[] getIllnesses() {
        return this.illnesses;
    }

    /**
     * Set the illnesses of the patient
     *
     * @param illnesses the illnesses of the patient
     */
    @Override
    public void setIllnesses(Illness[] illnesses) {
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
            this.illnesses = new Illness[]{illness};
        } else {
            Illness[] newIllnesses = new Illness[this.illnesses.length + 1];
            System.arraycopy(this.illnesses, 0, newIllnesses, 0, this.illnesses.length);
            newIllnesses[this.illnesses.length] = illness;
            this.illnesses = newIllnesses;
        }
    }

    /**
     * Remove an illness from the patient
     *
     * @param illness the illness to remove
     */
    @Override
    public void removeIllness(Illness illness) {
        if (this.illnesses != null) {
            Illness[] newIllnesses = new Illness[this.illnesses.length - 1];
            int j = 0;
            for (Illness i : this.illnesses) {
                if (i != illness) {
                    newIllnesses[j] = i;
                    j++;
                }
            }
            this.illnesses = newIllnesses;
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

    }
    /**
     * Thread of the patient
     */
    @Override
    public void run() {
    }
}
