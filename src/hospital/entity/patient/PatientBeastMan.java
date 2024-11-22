package hospital.entity.patient;

import hospital.entity.Creature;
import hospital.entity.Patient;
import hospital.illness.Illness;
import hospital.race.BeastMan;
import hospital.services.Service;

public class PatientBeastMan extends Creature implements Patient, BeastMan {

    private int morale;
    private Illness[] illnesses;

    public PatientBeastMan(String name, boolean isMale,  int age, int weight, int height, int morale, Illness[] illnesses) {
        super(name, isMale, age, weight, height);
        this.morale = morale;
        this.illnesses = illnesses;
    }

    public PatientBeastMan(String name, boolean isMale, int age, int weight, int height) {
        super(name, isMale, age, weight, height);
        this.morale = MORALE_MAX;
        this.illnesses = new Illness[Illness.AMOUNT];
    }

    public PatientBeastMan(String name, boolean isMale, int age) {
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
            Illness[] tmp = new Illness[this.illnesses.length + 1];
            System.arraycopy(this.illnesses, 0, tmp, 0, this.illnesses.length);
            tmp[tmp.length - 1] = illness;
            this.illnesses = tmp;
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
            for (int i = 0; i < this.illnesses.length; i++) {
                if (this.illnesses[i].equals(illness)) {
                    Illness[] tmp = new Illness[this.illnesses.length - 1];
                    System.arraycopy(this.illnesses, 0, tmp, 0, i);
                    System.arraycopy(this.illnesses, i + 1, tmp, i, this.illnesses.length - i - 1);
                    this.illnesses = tmp;
                    break;
                }
            }
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
}
