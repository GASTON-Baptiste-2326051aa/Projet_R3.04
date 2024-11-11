package models.creatures;

import models.Hospital;
import models.Illness;
import models.services.Service;

import java.util.Scanner;

/**
 * Class Doctor
 */
public class Doctor extends Creature {
    /**
     * Scanner to read the input
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
    public void checkService(Service service) {
        System.out.println("Service: " + service.getName());
        System.out.println("Budget: " + service.getBudget());
        System.out.println("Surface: " + service.getSurface());
        System.out.println("CreatureMax: " + service.getCreatureMax());
        System.out.println("CreatureNow: " + service.getCreatureNow());
        System.out.println("Creatures: ");
        for (Creature creature : service.getCreatures()) {
            System.out.println("\t - " + creature);
        }
    }

    /**
     * Cure a creature
     * @param creature the creature to cure
     * @param illness the illness to cure
     */
    public void cure(Creature creature, Illness illness) {
        System.out.println("Soigner " + creature + " de " + illness);
        creature.cure(illness);
    }

    /**
     * Change the budget of a service
     * @param service the service to change the budget
     */
    public void changeServiceBudget(Service service) {
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
     * chooose a service in the hospital
     * @param hospital the hospital where the service is
     * @return the service chosen
     */
    public Service chooseService(Hospital hospital) {
        System.out.println("Choose a service: ");
        int nb = 1;
        Service[] services = new Service[1000];
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
        System.out.println("Choisissez une maladie: ");
        int nb = 1;
        Illness[] illnesses = new Illness[1000];
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
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1 - Vérifier un service");
        System.out.println("2 - Soigner une créature");
        System.out.println("3 - Changer le budget d'un service");
        System.out.println("4 - Déplacer une créature");
        System.out.println("5 - Quitter");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                checkService(this.chooseService(hospital));
                break;
            case 2:
                Creature creature = this.chooseCreature(hospital);
                cure(creature, this.chooseIllness(creature));
                break;
            case 3:
                changeServiceBudget(this.chooseService(hospital));
                break;
            case 4:
                moveCreature(this.chooseCreature(hospital), this.chooseService(hospital), this.chooseService(hospital));
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Choix invalide");
                break;
        }
    }

    /**
     * return the string representation of the doctor
     * @return the string representation of the doctor
     */
    @Override
    public String toString() {
        return "models.creatures.Doctor{" +
                "name='" + this.getName() + '\'' +
                ", sex='" + (this.isMale() ? "Male" : "Female") +
                "', age=" + this.getAge() +
                '}';
    }
}
