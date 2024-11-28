package hospital.entity;

import hospital.Hospital;
import hospital.illness.Illness;
import hospital.services.Service;

import java.util.Scanner;

/**
 * The Doctor interface
 */
public interface Doctor extends Entity {
    Scanner input = new Scanner(System.in);

    /**
     * cure a patient
     * @param patient the patient to cure
     */
    default void treatPatient(Service service, Patient patient) {
        Illness toCure = chooseIllness(patient);
        for (int i = 0; i < service.getBudget(); i++) {
            toCure.decrease();
        }
    }

    default Illness chooseIllness(Patient patient) {
        System.out.println("Choose a illness :");
        for (int i = 0; i < patient.getIllnesses().size(); i++) {
            System.out.println((i + 1) + " : " + patient.getIllnesses().toArray()[i]);
        }
        int resp = Integer.parseInt(input.nextLine());
        return (Illness) patient.getIllnesses().toArray()[resp - 1];
    }

    default Patient choosePatient(Service service) {
        System.out.println("Choose a patient :");
        for (int i = 0; i < service.getCreatures().size(); i++) {
            System.out.println((i + 1) + " : " + service.getCreatures().toArray()[i]);
        }
        int resp = Integer.parseInt(input.nextLine());
        return (Patient) service.getCreatures().toArray()[resp - 1];
    }

    default Service chooseService(Hospital hospital) {
        System.out.println("Choose a service :");
        for (int i = 0; i < hospital.getServices().length; i++) {
            System.out.println((i + 1) + " : " + hospital.getServices()[i]);
        }
        int resp = Integer.parseInt(input.nextLine());
        return hospital.getServices()[resp - 1];
    }

    /**
     * check a service
     * @param service the service to check
     */
    default void checkService(Service service) {
        System.out.println(service);
    }

    /**
     * change the budget of a service
     * @param service the service to change the budget
     */
    default void changeServiceBudget(Service service) {
        System.out.println("Do you want to raise or reduce the budget of the service ? (Type 'raise' or 'reduce')");
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
     * check a hospital
     * @param hospital the hospital to check
     */
    default void checkHospital(Hospital hospital) {
        System.out.println(hospital);
    }

    /**
     * compare the age of two doctors
     *
     * @param doctor the doctor to compare
     * @return true if the age of the doctor is greater than the age of the other doctor
     */
    default boolean compareAge(Doctor doctor) {
        return this.getAge() > doctor.getAge();
    }
}
