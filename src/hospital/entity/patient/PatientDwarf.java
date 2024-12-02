package hospital.entity.patient;

import hospital.entity.Creature;
import hospital.entity.Patient;
import hospital.illness.Illness;
import hospital.illness.SetIllness;
import hospital.illness.Illnesses;
import hospital.race.Dwarf;

import java.util.Random;

import static java.lang.Thread.sleep;

public class PatientDwarf extends Creature implements Patient, Dwarf {
    private int morale;
    private SetIllness illnesses;

    public PatientDwarf(String name, boolean isMale, int age, float weight, float height, int morale, SetIllness illnesses) {
        super(name, isMale, age, weight, height);
        this.morale = morale;
        this.illnesses = illnesses;
    }

    public PatientDwarf(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
        this.morale = MORALE_MAX;
        this.illnesses = new SetIllness();
    }

    public PatientDwarf(String name, boolean isMale, int age) {
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
