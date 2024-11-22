package models.services;

import models.creatures.Creature;

import java.util.Arrays;

public class QuarantineCenter extends Service {
    private boolean isolation;

    /**
     * Constructor of a quarantine center
     * @param name the name of the quarantine center
     * @param surface the surface of the center
     * @param creatureMax the max number of creatures
     * @param budget the budget of the center
     * @param isolation whether the center is isolated or not
     */
    public QuarantineCenter(String name, float surface, int creatureMax, int budget, boolean isolation) {
        super(name, surface, creatureMax, budget);
        this.isolation = isolation;
    }

    /**
     * Check if the center is in isolation
     * @return true if the center is isolated, false otherwise
     */
    public boolean isIsolation() {
        return isolation;
    }

    /**
     * Set the isolation state of the center
     * @param isolation the new isolation state
     */
    public void setIsolation(boolean isolation) {
        this.isolation = isolation;
    }

    /**
     * Override the addCreature method to ensure only contagious creatures can be added
     * @param creature a creature to add
     */
    @Override
    public void addCreature(Creature creature) {
        if (creature.isContagious()) { //Il faut tester si c'est une créature bestiale
            super.addCreature(creature);
        } else {
            System.out.println("Only contagious creatures are allowed in a quarantine center.");
        }
    }

    /**
     * Override the budget revision to include the isolation factor
     */
    @Override
    public void setBudget(int budget) {
        if (isolation) {
            super.setBudget(budget+10);
        }
        else {
            super.setBudget(budget);
        }
    }

    @Override
    public String toString() {
        return "QuarantineCenter{" +
                "name='" + getName() + '\'' +
                ", surface=" + getSurface() +
                ", creatureMax=" + getCreatureMax() +
                ", creatureNow=" + getCreatureNow() +
                ", budget='" + budgetToString(getBudget()) +
                "', isolation=" + isolation +
                ", creatures=" + Arrays.toString(getCreatures()) +
                "}";
    }
}
