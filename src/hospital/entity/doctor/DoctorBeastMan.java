package hospital.entity.doctor;

import hospital.Hospital;
import hospital.entity.Creature;
import hospital.entity.Doctor;
import hospital.entity.Patient;
import hospital.race.BeastMan;
import hospital.services.Service;

public class DoctorBeastMan extends Creature implements Doctor, BeastMan {

    public DoctorBeastMan(String name, boolean isMale, int age, float weight, float height) {
        super(name, isMale, age, weight, height);
    }

    public DoctorBeastMan(String name, boolean isMale, int age) {
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