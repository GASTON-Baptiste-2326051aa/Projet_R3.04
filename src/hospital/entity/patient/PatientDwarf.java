package hospital.entity.patient;

import hospital.entity.Creature;
import hospital.entity.Patient;
import hospital.illness.Illness;
import hospital.illness.Illnesses;
import hospital.race.Dwarf;

import java.util.Random;

import static java.lang.Thread.sleep;

public class PatientDwarf extends Creature implements Patient, Dwarf {
    private int morale;
    private Illness[] illnesses;

    public PatientDwarf(String name, boolean isMale, int age, int weight, int height, int morale, Illness[] illnesses) {
        super(name, isMale, age, weight, height);
        this.morale = morale;
        this.illnesses = illnesses;
    }

    public PatientDwarf(String name, boolean isMale, int age, int weight, int height) {
        super(name, isMale, age, weight, height);
        this.morale = MORALE_MAX;
        this.illnesses = new Illness[1];
        this.illnesses[0] = Illnesses.getRandomIllness();
    }

    public PatientDwarf(String name, boolean isMale, int age) {
        super(name, isMale, age);
        this.morale = MORALE_MAX;
        this.illnesses = new Illness[1];
        this.illnesses[0] = Illnesses.getRandomIllness();
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
        System.out.println("The patient " + this.getName() + " is screaming.");
    }

    /**
     * The patient waits
     */
    @Override
    public void waitATime() {
        this.morale--;
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The patient passes away
     */
    @Override
    public void passAway() {
        System.out.println("The patient " + this.getName() + " has passed away.");
    }

    /**
     * The patient is carried away
     */
    @Override
    public void carriedAway() {
        System.out.println("The patient " + this.getName() + " has been carried away.");
    }
    /**
     * Thread of the patient
     */
    @Override
    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            waitATime();
            if(this.morale <= MORALE_SCREAM) {
                scream();
            }
            if(this.morale <= MORALE_MIN) {
                carriedAway();
            }
            for (Illness illness : this.illnesses) {
                if (illness.is_mortal()) {
                    passAway();
                    isRunning = false;
                }
            }
            Random random = new Random();
            if (random.nextInt(100) < 10) {
                Illness illness = this.illnesses[random.nextInt(illnesses.length)];
                illness.setLvl(illness.getLvl() + 1);
                System.out.println("The patient " + this.getName() + " has an illness " + illness.getName() + " at level " + illness.getLvl());
            }
        }

    }
}
