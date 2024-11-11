package models.creatures;

import models.Hospital;
import models.Illness;
import models.services.Service;

import java.util.Scanner;

public class Doctor extends Creature {
    /**
     * The maximum number of actions the doctor can do
     */
    private static final int MAX_ACTION_LEFT = 10;
    private static final int COST_CHECK_SERVICE = 0;
    private static final int COST_CURE_CREATURE = 2;
    private static final int COST_CHANGE_SERVICE_BUDGET = 3;
    private static final int COST_MOVE_CREATURE = 1;

    /**
     * The scanner to read the input
     */
    private final Scanner input = new Scanner(System.in);

    /**
     * Constructor of the Doctor class
     * @param name the name of the doctor
     * @param is_male the sexe of the doctor
     * @param age the age of the doctor
     */
    public Doctor(String name, boolean is_male, int age) {
        super(name, is_male, age);
    }

    /**
     * Gives the information about the medical service
     * @param service the service to check
     */
    public Service checkService(Service service) {
        System.out.println("Service: " + service.getName());
        System.out.println("Budget: " + service.getBudget());
        System.out.println("Surface: " + service.getSurface());
        System.out.println("CreatureMax: " + service.getCreatureMax());
        System.out.println("CreatureNow: " + service.getCreatureNow());
        System.out.println("Creatures: ");
        for (Creature creature : service.getCreatures()) {
            System.out.println("\t - " + creature);
        }
        return service;
    }

    /**
     * Cure a creature
     * @param creature the creature to cure
     */
    public void cure(Service service, Creature creature) {
        for (int i = 0; i < service.getBudget() + 1; i++) {
            Illness illness = this.chooseIllness(creature);
            System.out.println("Cure " + creature.getName() + " from " + illness.getName());
            creature.cureIllness(illness);
        }
    }

    /**
     * Change the budget of a service
     * @param service the service to change the budget
     */
    public void changeServiceBudget(Service service) {
        System.out.println("Set the new budget: ");
        service.setBudget(input.nextInt());
        System.out.println("New budget: " + service.budgetToString(service.getBudget()));
    }

    /**
     * Change the service of a creature.
     * @param creature the creature to move
     * @param serviceDep the service where the creature is
     * @param serviceArr the service where the creature will be
     */
    public void moveCreature(Creature creature, Service serviceDep, Service serviceArr) {
        serviceDep.removeCreature(creature);
        serviceArr.addCreature(creature);
        System.out.println("Move " + creature + " from " +
                serviceDep.getName() + " to " + serviceArr.getName());
    }

    /**
     * choose a creature in the hospital
     * @param hospital the hospital where the creature is
     * @return the creature chosen
     */
    public Creature chooseCreature(Hospital hospital) {
        System.out.println("Choose a creature: ");
        int i = 1;
        Creature[] creatures = hospital.getCreatures();
        for (Creature creature : creatures) {
            System.out.println(i + " - " + creature);
            i++;
        }
        int choice = input.nextInt();
        return creatures[choice - 1];
    }

    /**
     * choose a creature in the service
     * @param service the service where the creature is
     * @return the creature chosen
     */
    public Creature chooseCreature(Service service) {
        System.out.println("Choose a creature: ");
        int i = 1;
        Creature[] creatures = service.getCreatures();
        for (Creature creature : creatures) {
            System.out.println(i + " - " + creature);
            i++;
        }
        int choice = input.nextInt();
        return creatures[choice - 1];
    }

    /**
     * choose a service in the hospital
     * @param hospital the hospital where the service is
     * @return the service chosen
     */
    public Service chooseService(Hospital hospital) {
        System.out.println("Choose a service: ");
        int nb = 1;
        Service[] services = new Service[hospital.getServiceMax()];
        for (Service service : hospital.getServices()) {
            System.out.println(nb + " - " + service.getName());
            services[nb - 1] = service;
            nb++;
        }
        int choice = input.nextInt();
        return services[choice - 1];
    }

    /**
     * Choose an illness for a creature
     * @param creature the creature to choose the illness
     * @return the illness chosen
     */
    public Illness chooseIllness(Creature creature) {
        System.out.println("Choose an illness: ");
        int nb = 1;
        Illness[] illnesses = new Illness[creature.getIllnesses().length];
        for (Illness illness : creature.getIllnesses()) {
            System.out.println(nb + " - " + illness);
            illnesses[nb - 1] = illness;
            nb++;
        }
        int choice = input.nextInt();
        return illnesses[choice - 1];
    }

    /**
     * Launch the menu of the hospital simulation
     * @param hospital the hospital where the doctor is
     */
    public void runMenu(Hospital hospital) {
        int actionLeft = MAX_ACTION_LEFT;
        Service actualService = null;
        while (actionLeft > 0) {
            System.out.println("Actions left: " + actionLeft);
            System.out.println(actualService != null ? "Current service: " + actualService : "No current service");
            System.out.println("What do you want to do?");
            System.out.println("1 - Check a service");
            System.out.println("2 - Cure a creature");
            System.out.println("3 - Change the budget of a service");
            System.out.println("4 - Move a creature");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    actualService = checkService(this.chooseService(hospital));
                    actionLeft -= COST_CHECK_SERVICE;
                    break;
                case 2:
                    if (actualService == null) {
                        System.out.println("You must check a service before curing a creature");
                    } else {
                        Creature creature = this.chooseCreature(actualService);
                        cure(actualService, creature);
                        actionLeft -= COST_CURE_CREATURE;
                    }
                    break;
                case 3:
                    changeServiceBudget(this.chooseService(hospital));
                    actionLeft -= COST_CHANGE_SERVICE_BUDGET;
                    break;
                case 4:
                    moveCreature(this.chooseCreature(hospital), this.chooseService(hospital), this.chooseService(hospital));
                    actionLeft -= COST_MOVE_CREATURE;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    /**
     * return the string representation of the doctor
     * @return the string representation of the doctor
     */
    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + this.getName() + '\'' +
                ", sex='" + (this.isMale() ? "Male" : "Female") +
                "', age=" + this.getAge() +
                '}';
    }
}