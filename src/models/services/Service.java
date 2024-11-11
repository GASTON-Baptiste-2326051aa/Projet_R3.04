package models.services;

import models.creatures.Creature;

import java.util.Arrays;

public abstract class Service {
    private String name;
    private float surface;
    private final int creatureMax;
    private int creatureNow;
    private Creature[] creatures;
    private int budget;

    /**
     * Constructor of a medical service
     * @param name the name of the service
     * @param surface the surface of the service
     * @param creatureMax the max amount of creature than the service could get
     * @param creatureNow the actual amount of creature than the service could get
     * @param creatures the list of creature actually inside the service
     * @param budget the budget of the service
     */
    public Service(String name, float surface, int creatureMax, int creatureNow, Creature[] creatures, int budget) {
        this.name = name;
        this.surface = surface;
        this.creatureMax = creatureMax;
        this.creatureNow = creatureNow;
        this.creatures = creatures;
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
        this.creatureNow = this.creatures.length;
    }

    /**
     * Return all the creatures inside a service
     * @return all the creatures inside a service
     */
    public Creature[] getCreatures() {
        return creatures;
    }

    /**
     * Set all the creature inside a service
     * @param creatures all the creature inside a service
     */
    public void setCreatures(Creature[] creatures) {
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
     * @param creature a creature to add to the service
     */
    public void addCreature(Creature creature) {
        if (this.creatureNow < this.creatureMax) {
            this.creatures[this.creatureNow] = creature;
            this.creatureNow++;
        }
    }

    /**
     * Remove a creature from a service
     * @param creature a creature to remove from the service
     */
    public void removeCreature(Creature creature) {
        for (int i = 0; i < this.creatureNow; i++) {
            if (this.creatures[i].equals(creature)) {
                for (int j = i; j < this.creatureNow - 1; j++) {
                    this.creatures[j] = this.creatures[j + 1];
                }
                this.creatureNow--;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", surface=" + surface +
                ", creatureMax=" + creatureMax +
                ", creatureNow=" + creatureNow +
                ", creatures=" + Arrays.toString(creatures) +
                ", budget='" + budgetToString(budget) +
                "'}";
    }
}
