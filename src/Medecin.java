import java.util.Scanner;

public class Medecin extends Creature {

    private final Scanner input = new Scanner(System.in);

    public Medecin(String name, boolean is_male, int age) {
        super(name, is_male, age);
    }

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

    public void cure(Creature creature, Illness illness) {
        System.out.println("Soigner " + creature + " de " + illness);
        creature.cure(illness);
    }

    public void changeServiceBudget(Service service) {
        service.setBudget(input.nextInt());
        System.out.println("Nouveau budget: " + service.budgetToString(service.getBudget()));
    }

    public void moveCreature(Creature creature, Service serviceDep, Service serviceArr) {
        serviceDep.removeCreature(creature);
        serviceArr.addCreature(creature);
        System.out.println("Déplacer " + creature + " de " +
                serviceDep.getName() + " vers " + serviceArr.getName());
    }

    public Creature chooseCreature(Hospital hospital) {
        System.out.println("Choisissez une créature: ");
        int i = 1;
        Creature[] creatures = hospital.getCreatures();
        for (Creature creature : creatures) {
            System.out.println(i + " - " + creature);
            i++;
        }
        int choice = input.nextInt();
        return creatures[choice - 1];
    }

    public Service chooseService(Hospital hospital) {
        System.out.println("Choisissez un service: ");
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

    @Override
    public String toString() {
        return "Medecin{" +
                "name='" + this.getName() + '\'' +
                ", sex='" + (this.isIs_male() ? "Male" : "Female") +
                "', age=" + this.getAge() +
                '}';
    }
}
