package hospital.services;

import hospital.entity.Creature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Service
 */
public class Service implements Runnable{
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
    private Collection<Creature> creatures = new ArrayList<>();
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
        this.budget = budget;
    }

    /**
     * Return the name of a service
     * @return the name of a service
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of a service
     * @param name the name of a service
     */
    public void setName(String name) {
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
     * @return all the creatures inside a service
     */
    public Collection<Creature> getCreatures() {
        return creatures;
    }

    /**
     * Set all the creature inside a service
     * @param creatures all the creature inside a service
     */
    public void setCreatures(Collection<Creature> creatures) {
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
     */
    public void addCreature(Creature creature) {
        if (this.creatures == null) {
            this.creatures = new ArrayList<>();
        }
        if (this.creatureNow >= this.creatureMax) {
            System.out.println("The service is full");
            return;
        }
        if (!creatures.isEmpty() && !creatures.iterator().next().getClass().equals(creature.getClass())) {
            System.out.println("This service is only for " + creatures.iterator().next().getClass().getSimpleName());
            return;
        }
        this.creatures.add(creature);
        this.creatureNow++;
        System.out.println(creature.getName() + " has been added to the service.");
    }

    /**
     * Remove a creature from a service
     * @param creature a creature to remove from the service
     */
    public void removeCreature(Creature creature) {
        if (this.creatures.remove(creature)) {
            this.creatureNow--;
        }
    }
    /*
    /**
     * Cure a creature from an illness
     * @param creature a creature to cure
     * @param illness an illness to cure

    public void cureCreature(Creature creature, Illness illness)
    {
        creature.cureIllness(illness);
    }

    /**
     * Cure a creature from all its illness
     * @param creature a creature to cure

    public void cureFullyCreature(Creature creature)
    {
        creature.cureAllIllness();
    }
     */

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
                ", budget='" + budgetToString(budget) +
                "'}";
    }

    /**
     * Run the service
     */
    @Override
    public void run() {
        for(Creature creature : creatures) {
            if (creature == null) {
                break;
            }
            creature.run();
        }
        System.out.println(getName() + " is running");

    }
}
