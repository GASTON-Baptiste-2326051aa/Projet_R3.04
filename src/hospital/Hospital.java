package hospital;

import hospital.entity.Doctor;
import hospital.entity.Patient;
import hospital.entity.doctor._DoctorGenerator;
import hospital.services.Service;

import java.util.Random;
import java.util.Scanner;

/**
 *
 */
public class Hospital {
    private final static int SERVICE_MAX = 10;
    private static final int ACTION_MAX = 10;

    private static final int CHECK_ACTION = 0;
    private static final int CHOOSE_ACTION = 1;
    private static final int TREAT_ACTION = 1;
    private static final int CHANGE_ACTION = 2;

    private static final int BUDGET_DEFAULT = 2;

    private String name;
    private final int serviceMax;
    private Service[] services;
    private Doctor[] doctors;

    private int totalBudget = 0;
    private int maxBudget = 0;

    boolean isRunning = true;

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Constructor of the class Hospital
     * @param name the name of the hospital
     * @param serviceMax the maximum number of services in the hospital
     * @param services the list of services in the hospital
     * @param doctors the list of doctors in the hospital
     */
    public Hospital(String name, int serviceMax, Service[] services, Doctor[] doctors) {
        this.name = name;
        this.serviceMax = serviceMax;
        this.services = services;
        this.doctors = doctors;
        this.maxBudget = BUDGET_DEFAULT;
        setTotalBudget();
    }

    /**
     * Constructor of the class Hospital
     */
    public Hospital() {
        this.name = null;
        this.serviceMax = Hospital.SERVICE_MAX;
        this.services = new Service[]{};
        this.doctors = new Doctor[]{};
        this.maxBudget = BUDGET_DEFAULT;
        setTotalBudget();
    }

    /**
     * Return the name of the hospital
     * @return the name of the hospital
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the hospital
     * @param name the new name of the hospital
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the maximum number of services in the hospital
     * @return the maximum number of services in the hospital
     */
    public int getServiceMax() {
        return serviceMax;
    }

    /**
     * Return the list of services in the hospital
     * @return the services in the hospital
     */
    public Service[] getServices() {
        return services;
    }

    /**
     * Set the list of services in the hospital
     * @param services the new list of services in the hospital
     */
    public void setServices(Service[] services) {
        this.services = services;
    }

    /**
     * Return the list of doctors in the hospital
     * @return the doctors in the hospital
     */
    public Doctor[] getDoctors() {
        return doctors;
    }

    /**
     * Set the list of doctors in the hospital
     * @param doctors the new list of doctors in the hospital
     */
    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

    /**
     * Return the current number of creatures in the hospital
     * @return the current number of creatures in the hospital
     */
    public int getCreatureNow() {
        int creatureNow = 0;
        for (Service service : services) {
            creatureNow += service.getCreatureNow();
        }
        return creatureNow;
    }

    /**
     * Return the list of creatures in the hospital
     * @return the creatures in the hospital
     */
    public Patient[] getCreatures() {
        Patient[] creatures = new Patient[getCreatureNow()];
        int i = 0;
        for (Service service : services) {
            for (Patient creature : service.getCreatures()) {
                creatures[i++] = creature;
            }
        }
        return creatures;
    }

    public int getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget() {
        this.totalBudget = 0;
        for (Service service : services) {
            this.totalBudget += service.getBudget();
        }
    }

    public int getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(int maxBudget) {
        this.maxBudget = maxBudget;
    }

    /**
     * start the hospital
     */
    public void run() {
        Service actualService = null;
        Doctor actualDoctor = null;
        int action = ACTION_MAX;
        for (Service service : services) {
            service.start();
        } actualDoctor =  chooseDoctor();
        while (isRunning) {
            System.out.println("What do you want to do ?");
            System.out.println("1 - Check a service");
            System.out.println("2 - Choose a service");
            System.out.println("3 - Check a patient");
            System.out.println("4 - Treat a patient");
            System.out.println("5 - Change the Service Budget");
            System.out.println("6 - Exit the Hospital");
            int resp = Integer.parseInt(scanner.nextLine());
            switch (resp) {
                case 1:
                    actualDoctor.checkService(actualDoctor.chooseService(this));
                    action = action - CHECK_ACTION;
                    break;
                case 2:
                    actualService = actualDoctor.chooseService(this);
                    action = action - CHOOSE_ACTION;
                    break;
                case 3:
                    if (actualService == null)
                        actualService = actualDoctor.chooseService(this);
                    System.out.println(actualDoctor.choosePatient(actualService));
                    action = action - CHECK_ACTION;
                    break;
                case 4:
                    if (actualService == null)
                        actualService = actualDoctor.chooseService(this);
                    actualDoctor.treatPatient(actualService, actualDoctor.choosePatient(actualService));
                    action = action - TREAT_ACTION;
                    break;
                case 5:
                    actualDoctor.changeServiceBudget(actualService);
                    action = action - CHANGE_ACTION;
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            if (isRunning && action <= 0) {
                System.out.println("Your Doctor is tired...");
                actualDoctor = chooseDoctor();
                action = ACTION_MAX;
            }
            if (new Random().nextInt(100) == 0) {
                System.out.println("the Hospital got more budget !");
                maxBudget++;
                System.out.println("The list of the service in the hospital :");
                actualDoctor.checkHospital(this);
                System.out.println("did you want to change the budget of one of the services ?(-1 for no)");
                resp = Integer.parseInt(scanner.nextLine());
                while (resp != -1 || maxBudget > totalBudget) {
                    actualDoctor.changeServiceBudget(actualDoctor.chooseService(this));
                    System.out.println("The list of the service in the hospital :");
                    actualDoctor.checkHospital(this);
                    System.out.println("did you want to change the budget of one of the services ?(-1 for no)");
                }
            }
        }
    }

    private Doctor chooseDoctor() {
        Doctor doctor;
        System.out.println("Choose a doctor :");
        for (int i = 0; i < doctors.length; i++) {
            System.out.println((i + 1) + " - " + doctors[i].getName());
        }
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice > 0 && choice <= doctors.length) {
            doctor = doctors[choice - 1];
            System.out.println("You have chosen " + doctor.getName());
        } else {
            System.out.println("Invalid choice");
            doctor = chooseDoctor();
        }
        return doctor;
    }

    public static void main(String[] args) {
        Hospital hospital = new Hospital("The Hospital", 3, new Service[]{
                new Service("Service", 15.2F, 800, 1)},
                new Doctor[]{new _DoctorGenerator().generateDoctor()});
        hospital.run();
    }
}