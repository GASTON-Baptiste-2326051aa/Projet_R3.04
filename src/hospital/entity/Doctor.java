package hospital.entity;

import hospital.Hospital;
import hospital.illness.Illness;
import hospital.services.Service;

import java.util.Scanner;

/**
 * The `Doctor` interface represents a doctor in the hospital.
 */
public interface Doctor extends Entity {
    /**
     * The `Scanner` object for user input.
     */
    Scanner input = new Scanner(System.in);

    /**
     * Treat a patient by curing an illness.
     * @param service the service where the patient is treated
     * @param patient the patient to cure
     */
    default void treatPatient(Service service, Patient patient) {
        Illness toCure = chooseIllness(patient);
        for (int i = 0; i < service.getBudget() + 1; i++) {
            toCure.decrease();
        }
    }

    /**
     * Choose an illness from the patient's illnesses.
     * @param patient the patient whose illness is to be chosen
     * @return the chosen illness
     */
    default Illness chooseIllness(Patient patient) {
        System.out.println("Choose an illness:");
        for (int i = 0; i < patient.getIllnesses().size(); i++) {
            System.out.println((i + 1) + " : " + patient.getIllnesses().toArray()[i]);
        }
        int resp = Integer.parseInt(input.nextLine());
        return (Illness) patient.getIllnesses().toArray()[resp - 1];
    }

    /**
     * Choose a patient from the service.
     * @param service the service where the patient is to be chosen
     * @return the chosen patient
     */
    default Patient choosePatient(Service service) {
        System.out.println("Choose a patient :");
        for (int i = 0; i < service.getPatients().size(); i++) {
            System.out.println((i + 1) + " : " + service.getPatients().toArray()[i]);
        }
        int resp = Integer.parseInt(input.nextLine());
        return (Patient) service.getPatients().toArray()[resp - 1];
    }

    /**
     * Choose a service from the hospital.
     * @param hospital the hospital where the service is to be chosen
     * @return the chosen service
     */
    default Service chooseService(Hospital hospital) {
        System.out.println("Choose a service:");
        for (int i = 0; i < hospital.getServices().length; i++) {
            System.out.println((i + 1) + " : " + hospital.getServices()[i]);
        }
        int resp = Integer.parseInt(input.nextLine());
        return hospital.getServices()[resp - 1];
    }

    /**
     * Check the services of a hospital.
     * @param hospital hospital to check
     */
    default void checkServices(Hospital hospital) {
        for (Service service : hospital.getServices()) {
            System.out.println(service);
        }
    }

    /**
     * Change the budget of a service.
     * @param service the service whose budget is to be changed
     */
    default void changeServiceBudget(Service service) {
        System.out.println("Do you want to raise or reduce the budget of the service? (Type 'raise' or 'reduce')");
        String resp = input.nextLine();
        switch (resp) {
            case "raise":
                service.setBudget(service.getBudget() + 1);
                break;
            case "reduce":
                service.setBudget(service.getBudget() - 1);
                break;
            default:
                System.out.println("Invalid Command!");
                changeServiceBudget(service);
                break;
        }
    }

    /**
     * Check the details of a hospital.
     * @param hospital the hospital to check
     */
    default void checkHospital(Hospital hospital) {
        System.out.println(hospital);
    }

    /**
     * Compare the age of two doctors.
     * @param doctor the doctor to compare with
     * @return true if this doctor is older than the other doctor
     */
    default boolean compareAge(Doctor doctor) {
        return this.getAge() > doctor.getAge();
    }
}