package hospital.services;

import hospital.entity.Creature;
import hospital.entity.Patient;
import hospital.entity.PatientCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service
 */
public class Service extends Thread {
    /**
     * The name of the service
     */
    private String name;
    /**
     * The surface of the service
     */
    private float surface;
    /**
     * The max amount of creature than the service could get
     */
    private final int creatureMax;
    /**
     * The actual number of creatures inside the service
     */
    private int creatureNow = 0;
    /**
     * The creatures inside the service
     */
    private PatientCollection creatures;
    /**
     * The budget of the service
     */
    private int budget;

    /**
     * Constructor of a medical service
     * @param name the name of the service
     * @param surface the surface of the service
     * @param creatureMax the max amount of creature than the service could get
     * @param budget the budget of the service
     */
    public Service(String name, float surface, int creatureMax, int budget) {
        this.name = name;
        this.surface = surface;
        this.creatureMax = creatureMax;
        this.creatures = new PatientCollection();
        this.budget = budget;
    }

    /**
     * Constructor of a medical service
     *
     * @param name        the name of the service
     * @param surface     the surface of the service
     * @param creatureMax the max amount of creature than the service could get
     * @param budget      the budget of the service
     * @param creatures   the creatures inside the service
     */
    public Service(String name, float surface, int creatureMax, int budget, PatientCollection creatures) {
        this.name = name;
        this.surface = surface;
        this.creatureMax = creatureMax;
        this.creatures = creatures;
        this.budget = budget;
    }

    /**
     * Return the name of a service
     * @return the name of a service
     */
    public String getServiceName() {
        return name;
    }

    /**
     * Set the name of a service
     * @param name the name of a service
     */
    public void setServiceName(String name) {
        this.name = name;
    }

    /**
     * Return the surface of a service
     * @return the surface of a service
     */
    public float getSurface() {
        return surface;
    }

    /**
     * Set the surface of a service
     * @param surface the surface of a service
     */
    public void setSurface(float surface) {
        this.surface = surface;
    }

    /**
     * Get the max number of creatures inside a service
     * @return the max number of creatures inside a service
     */
    public int getCreatureMax() {
        return creatureMax;
    }

    /**
     * Get the actual number of creatures inside a service
     * @return the actual number of creatures inside a service
     */
    public int getCreatureNow() {
        return creatureNow;
    }

    /**
     * Set the number of creatures inside a service
     */
    public void setCreatureNow() {
        this.creatureNow = this.creatures.size();
    }

    /**
     * Return all the creatures inside a service
     *
     * @return all the creatures inside a service
     */
    public PatientCollection getCreatures() {
        return creatures;
    }

    /**
     * Set all the creature inside a service
     * @param creatures all the creature inside a service
     */

    public void setCreatures(PatientCollection creatures) throws IllegalArgumentException {
        Patient creature1;
        if (creatures == null) {
            throw new IllegalArgumentException("The creatures list is empty");
        }
        if (creatures.isEmpty()) {
            throw new IllegalArgumentException("The creatures list is empty");
        }
        creature1 = creatures.iterator().next();
        for (Patient creature : creatures) {
            if (!creature.getClass().equals(creature1.getClass())) {
                throw new IllegalArgumentException("The creatures are not the same type");
            }
        }
        this.creatures = creatures;
    }

    /**
     * Return the budget of a service
     * @return the budget of a service
     */
    public int getBudget() {
        return budget;
    }

    /**
     * Set the budget of a service
     * @param budget the budget of a service
     */
    public void setBudget(int budget) {
        this.budget = budget;
        System.out.println("The budget of the service is now " + budgetToString(budget));
    }

    /**
     * Convert the budget into a String
     * @param budget the budget
     * @return a String
     */
    public String budgetToString(int budget) {
        return switch (budget) {
            case 0 -> "non-existent";
            case 1 -> "poor";
            case 2 -> "insufficient";
            case 3 -> "low";
            default -> "correct";
        };
    }

    /**
     * Add a creature inside a service
     * @param creature a creature to add to the service if it's possible
     * @throws IllegalArgumentException if the creature is not the same type as the other creatures in the service
     * @throws IllegalStateException if the service is full
     */

    public void addCreature(Patient creature) throws IllegalArgumentException, IllegalStateException {
        if (this.creatures == null) {
            this.creatures = new PatientCollection();
        }
        if(isCreatureInService(creature)) {
            System.out.println(creature.getName() + " is already in the service.");
            throw new IllegalStateException(creature.getName() + " is already in the service.");
        }
        if (isFull()) {
            System.out.println("The service is full");
            throw new IllegalStateException("The service is full");
        }
        if (!creatures.isEmpty() && !creatures.iterator().next().getClass().equals(creature.getClass())) {
            System.out.println("This service is only for " + creatures.iterator().next().getClass().getSimpleName());
            throw new IllegalArgumentException("This service is only for " + creatures.iterator().next().getClass().getSimpleName());
        }
        this.creatures.add(creature);
        this.creatureNow++;
        System.out.println(creature.getName() + " has been added to the service.");
    }

    /**
     * Remove a creature from a service
     * @param creature a creature to remove from the service
     * @throws IllegalArgumentException if the creature is not in the service
     */

    public void removeCreature(Creature creature) throws IllegalArgumentException {
        if (this.creatures.remove(creature)) {
            this.creatureNow--;
            System.out.println(creature.getName() + " has been removed from the service.");
        }
        else {
            System.out.println(creature.getName() + " is not in the service.");
            throw new IllegalArgumentException(creature.getName() + " is not in the service.");
        }
    }


    /**
     * Function allowing us to swap elements in an array, used for sorting
     * @param patients the array of patient
     * @param i index to swap
     * @param j index to swap
     */
    public void swap(Patient[] patients, int i, int j) {

    }

    /**
     * Sort every creature in the service according to their morale
     * Use a bubble sort
     */
    public void sortMorale() {
                int n = getCreatures().size();
                Patient[] patients = (Patient[]) getCreatures().toArray();
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (patients[j].compareMorale(patients[j + 1]))
                            swap(patients, j, j + 1);
                    }
                }
            }

    public boolean isCreatureInService(Patient creature) {
        return creatures.contains(creature);
    }
    /**
     * Check if the service is full
     * @return true if the service is full, false otherwise
     */
    public boolean isFull() {
        return creatureNow == creatureMax;
    }

    /**
     * Sort every creature in the service according to their illness level
     * Use a bubble sort
     */
    public void sortIllnessLevel() {
        int n = getCreatures().size();
        Patient[] patients = (Patient[]) getCreatures().toArray();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (patients[j].compareIllnessLevel(patients[j + 1]))
                    swap(patients, j, j + 1);
            }
        }
    }

    public void sortIllnessAndMorale() {
        Patient[] patients = (Patient[]) getCreatures().toArray();
        Patient[] sortedPatients = sortIllnessAndMorale(patients);
        this.creatures = new PatientCollection(Arrays.asList(sortedPatients).toArray(new Patient[]{}));
    }

    /**
     * sort the patient by Illness level and Morale using Quicksort
     *
     * @param creatures the patient to sort
     * @return the patient sort by Illness level and Morale
     */
    private Patient[] sortIllnessAndMorale(Patient[] creatures) {
        List<Patient> less = new ArrayList<>();
        List<Patient> more = new ArrayList<>();
        Patient pivot = creatures[0];

        if (creatures.length < 2) {
            for (Patient patient : creatures) {
                if (patient.compareMoraleAndIllnessLevel(pivot))
                    more.add(patient);
                else less.add(patient);
            }
            List<Patient> tmp = new ArrayList<>(List.of(sortIllnessAndMorale((Patient[]) less.toArray())));
            tmp.addAll(List.of(sortIllnessAndMorale((Patient[]) more.toArray())));
            return (Patient[]) tmp.toArray();
        } else return creatures;
    }

    public void contaminate(Creature from) {

    }

    /**
     * Return the string representation of a service
     * @return the string representation of a service
     */
    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", surface=" + surface +
                ", creatureMax=" + creatureMax +
                ", creatureNow=" + creatureNow +
                ", creatures=" + creatures +
                ", budget=" + budgetToString(budget) +
                "}";
    }

    /**
     * Run the service
     */
    @Override
    public void run() {
        for (Patient creature : creatures.toArray(new Patient[]{})) {
            if (creature == null) {
                break;
            }
            creature.run();
        }
        System.out.println(getName() + " is running");
    }
}