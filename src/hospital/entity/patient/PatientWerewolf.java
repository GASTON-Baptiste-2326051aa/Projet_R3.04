package hospital.entity.patient;

import hospital.entity.Creature;
import hospital.entity.Patient;
import hospital.illness.Illness;
import hospital.illness.SetIllness;
import hospital.race.Werewolf;
import hospital.services.Service;

public class PatientWerewolf extends Creature implements Patient, Werewolf {
    public int morale;
    public SetIllness illnesses;

    public PatientWerewolf(String name, boolean isMale, int age, float weight, float height, int morale, SetIllness illnesses) {
        super(name, isMale, age, weight, height);
        this.morale = morale;
        this.illnesses = illnesses;
    }

    public PatientWerewolf(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
        this.morale = MORALE_MAX;
        this.illnesses = new SetIllness();
    }

    public PatientWerewolf(String name, boolean isMale, int age) {
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
}
