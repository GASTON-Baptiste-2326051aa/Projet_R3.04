package hospital.entity.doctor;

import hospital.Hospital;
import hospital.entity.Creature;
import hospital.entity.Doctor;
import hospital.entity.Patient;
import hospital.race.Zombie;
import hospital.services.Service;

public class DoctorZombie extends Creature implements Doctor, Zombie, Runnable {

    public DoctorZombie(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
    }

    public DoctorZombie(String name, boolean isMale, int age) {
        super(name, isMale, age);
    }

    /**
     * cure a patient
     *
     * @param patient the patient to cure
     */
    @Override
    public void treatPatient(Patient patient) {

    }

    /**
     * check a service
     *
     * @param service the service to check
     */
    @Override
    public void checkService(Service service) {

    }

    /**
     * change the budget of a service
     *
     * @param service the service to change the budget
     */
    @Override
    public void changeServiceBudget(Service service) {

    }

    /**
     * check a hospital
     *
     * @param hospital the hospital to check
     */
    @Override
    public void checkHospital(Hospital hospital) {

    }

    /**
     * the creature revive
     *
     * @param service the service where the creature revive
     */
    @Override
    public void revive(Service service) {

    }
    /**
     * Thread of the patient
     */
    @Override
    public void run() {
    }
}
