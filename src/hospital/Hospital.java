package hospital;

import hospital.entity.Creature;
import hospital.entity.Doctor;
import hospital.entity.Patient;
import hospital.entity.doctor._DoctorGenerator;
import hospital.entity.patient._PatientGenerator;
import hospital.illness.Illness;
import hospital.services.Crypt;
import hospital.services.Service;

import java.util.Random;
import java.util.Scanner;

/**
 * The `Hospital` class represents a hospital.
 */
public class Hospital {
    /**
     * The maximum number of services in the hospital.
     */
    private final static int SERVICE_MAX = 10;

    /**
     * The maximum number of actions a doctor can perform.
     */
    private static final int ACTION_MAX = 10;

    /**
     * The action value for checking a service.
     */
    private static final int CHECK_ACTION = 0;

    /**
     * The action value for choosing a service.
     */
    private static final int CHOOSE_ACTION = 1;

    /**
     * The action value for treating a patient.
     */
    private static final int TREAT_ACTION = 1;

    /**
     * The action value for changing the service budget.
     */
    private static final int CHANGE_ACTION = 2;

    /**
     * The default budget value.
     */
    private static final int BUDGET_DEFAULT = 2;

    /**
     * the factor of propagation of illness
     */
    private final float ILLNESS_FACTOR = 0.5F;

    /**
     * The name of the hospital.
     */
    private String name;

    /**
     * The maximum number of services in the hospital.
     */
    private final int serviceMax;

    /**
     * The list of services in the hospital.
     */
    private Service[] services;

    /**
     * The list of doctors in the hospital.
     */
    private Doctor[] doctors;

    /**
     * The total budget of the hospital.
     */
    private int totalBudget = 0;

    /**
     * The maximum budget of the hospital.
     */
    private int maxBudget = 0;

    /**
     * Indicates whether the hospital is running.
     */
    private boolean isRunning = true;

    /**
     * The scanner for user input.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Constructor of the class Hospital
     * @param name the name of the hospital
     * @param serviceMax the maximum number of services in the hospital
     */
    public Hospital(String name, int serviceMax) {
        this.name = name;
        this.serviceMax = serviceMax;
        this.maxBudget = BUDGET_DEFAULT;
        setTotalBudget();
    }

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
            creatureNow += service.getPatientNow();
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
            for (Patient creature : service.getPatients()) {
                creatures[i++] = creature;
            }
        }
        return creatures;
    }

    /**
     * Return the total budget of the hospital
     * @return the total budget of the hospital
     */
    public int getTotalBudget() {
        return totalBudget;
    }

    /**
     * Set the total budget of the hospital
     */
    public void setTotalBudget() {
        this.totalBudget = 0;
        if (services == null) {
            return;
        }
        for (Service service : services) {
            if(service != null){
                this.totalBudget += service.getBudget();
            }
        }
    }

    /**
     * Return the maximum budget of the hospital
     * @return the maximum budget of the hospital
     */
    public int getMaxBudget() {
        return maxBudget;
    }

    /**
     * Set the maximum budget of the hospital
     * @param maxBudget the new maximum budget of the hospital
     */
    public void setMaxBudget(int maxBudget) {
        this.maxBudget = maxBudget;
    }

    /**
     * Function to handle the menu
     */
    public void handleMenu(){
        System.out.println("What do you want to do ?");
        System.out.println("1 - Check a service.");
        System.out.println("2 - Choose a service.");
        System.out.println("3 - Check a patient.");
        System.out.println("4 - Treat a patient.");
        System.out.println("5 - Change the Service Budget.");
        System.out.println("6 - Exit the Hospital.");
    }

    /**
     * Add a random creature to a random service
     * @param turn the current turn
     */
    public void addRandomCreature(int turn){
        if (turn % 2 == 0){
            Service targetService = services[new Random().nextInt(services.length)];
            Patient patient = new _PatientGenerator().generatePatient();
            System.out.println(patient.toString());

            if (targetService != null){
                targetService.addPatient(patient);
            }
        }
    }

    /**
     * Increase the illnesses of the patients
     */
    public void increaseIllnesses(){
        for (Service service : getServices()) {
            for (Patient patient : service.getPatients()){
                for (Illness illness : patient.getIllnesses()) {
                    if (new Random().nextFloat() < ILLNESS_FACTOR)
                        illness.increase();
                }
            }
        }
    }

    /**
     * Start the hospital
     */
    public void run() {
        Service actualService = null;
        Doctor actualDoctor = null;
        int turn = 1;
        int action = ACTION_MAX;
        for (Service service : services) {
            service.start();
        }
        actualDoctor = chooseDoctor();
        while (isRunning) {
            System.out.println("TURN : " + turn);
            addRandomCreature(turn);
            increaseIllnesses();
            handleMenu();
            int resp = Integer.parseInt(scanner.nextLine());
            switch (resp) {
                case 1:
                    for (int i = 0; i < services.length; i++) {
                        System.out.println((i + 1) + " - " + services[i].getServiceName());
                    }
                    int serviceChoice = Integer.parseInt(scanner.nextLine());
                    if (serviceChoice > 0 && serviceChoice <= services.length) {
                        System.out.println("Details of " + services[serviceChoice - 1].getServiceName() + ":");
                        System.out.println(services[serviceChoice - 1].toString());
                    } else {
                        System.out.println("Invalid choice.");
                    }
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
                    System.out.println("Invalid choice.");
            }
            if (isRunning && action <= 0) {
                System.out.println("Your Doctor is tired...");
                actualDoctor = chooseDoctor();
                action = ACTION_MAX;
            }
            if (new Random().nextInt(100) == 0) {
                System.out.println("The Hospital got more budget !");
                maxBudget++;
                System.out.println("The list of the services in the hospital :");
                actualDoctor.checkHospital(this);
                System.out.println("Do you want to change the budget of one of the services ? (-1 for no)");
                resp = Integer.parseInt(scanner.nextLine());
                while (resp != -1 || maxBudget > totalBudget) {
                    actualDoctor.changeServiceBudget(actualDoctor.chooseService(this));
                    System.out.println("The list of the services in the hospital :");
                    actualDoctor.checkHospital(this);
                    System.out.println("Do you want to change the budget of one of the services ? (-1 for no)");
                }
            }
            turn++;
        }
    }

    /**
     * Choose a doctor from the list of doctors in the hospital
     * @return the chosen doctor
     */
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
            System.out.println("Invalid choice.");
            doctor = chooseDoctor();
        }
        return doctor;
    }

    /**
     * Return whether the hospital is running
     * @return `true` if the hospital is running, `false` otherwise
     */
    public boolean isRunning() {
        return this.isRunning;
    }

    /**
     * Set whether the hospital is running
     * @param running the new running state of the hospital
     */
    public void setIsRunning(boolean running) {
        this.isRunning = running;
    }


    /**
     * Initialize every Service for each type of creature
     */
    public void initializeServices(){
        services = new Service[]{
                new Service("Beast Men Service", 15.2F, 800, 1),
                new Service("Dwarfs Service", 15.2F, 800, 1),
                new Service("Elves Service", 15.2F, 800, 1),
                new Service("Orcs Service", 15.2F, 800, 1),
                new Service("Reptilians Service", 15.2F, 800, 1),
                new Service("Vampires Service", 15.2F, 800, 1),
                new Service("Werewolves Service", 15.2F, 800, 1),
                new Service("Zombies Service", 15.2F, 800, 1),
                new Crypt("The Crypt", 10.5F, 300, 1, 2, 24)


        };
    }

    /**
     * The main method to run the hospital
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hospital hospital = new Hospital("The Monstrospital", 3);
        hospital.initializeServices();
        hospital.setDoctors(_DoctorGenerator.generateDoctors(10));
        System.out.println("Welcome to the Monstrospital, Doctor, good luck !");
        hospital.run();
    }
}