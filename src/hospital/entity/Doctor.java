package hospital.entity;

import hospital.Hospital;
import hospital.services.Service;

/**
 * The Doctor interface
 */
public interface Doctor extends Entity {
    /**
     * cure a patient
     * @param patient the patient to cure
     */
    void treatPatient(Patient patient);

    /**
     * check a service
     * @param service the service to check
     */
    void checkService(Service service);

    /**
     * change the budget of a service
     * @param service the service to change the budget
     */
    void changeServiceBudget(Service service);

    /**
     * check a hospital
     * @param hospital the hospital to check
     */
    void checkHospital(Hospital hospital);
}
