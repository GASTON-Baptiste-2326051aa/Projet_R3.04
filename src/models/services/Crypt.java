package models.services;

import models.creatures.Creature;

import java.util.Arrays;

public class Crypt extends Service {
    private int ventilationLevel; // Niveau de ventilation (de 1 à 10, par exemple)
    private float temperature; // Température en degrés Celsius

    /**
     * Constructor of a crypt
     * @param name the name of the crypt
     * @param surface the surface of the crypt
     * @param creatureMax the max number of creatures
     * @param budget the budget of the crypt
     * @param ventilationLevel the ventilation level of the crypt
     * @param temperature the temperature of the crypt
     */
    public Crypt(String name, float surface, int creatureMax, int budget, int ventilationLevel, float temperature) {
        super(name, surface, creatureMax, budget);
        this.ventilationLevel = ventilationLevel;
        this.temperature = temperature;
    }

    /**
     * Get the ventilation level of the crypt
     * @return the ventilation level
     */
    public int getVentilationLevel() {
        return ventilationLevel;
    }

    /**
     * Set the ventilation level of the crypt
     * @param ventilationLevel the new ventilation level
     */
    public void setVentilationLevel(int ventilationLevel) {
        if (ventilationLevel < 1 || ventilationLevel > 10) {
            System.out.println("Ventilation level must be between 1 and 10.");
        } else {
            this.ventilationLevel = ventilationLevel;
        }
    }

    /**
     * Get the temperature of the crypt
     * @return the temperature
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * Set the temperature of the crypt
     * @param temperature the new temperature
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    /**
     * Override the addCreature method to ensure only regenerative creatures can be added
     * @param creature a creature to add
     */
    @Override
    public void addCreature(Creature creature) {
        if (creature.isRegenerative()) { // vérifier si c'est un mort vivant
            super.addCreature(creature);
        } else {
            System.out.println("Only regenerative creatures are allowed in a crypt.");
        }
    }

    /**
     * Override the budget revision to include ventilation and temperature checks
     * Faut finir la méthode
     */
    @Override
    public void setBudget(int budget) {
        super.setBudget(budget);
        System.out.println("Budget revised considering ventilation (Level " + ventilationLevel
                + ") and temperature (" + temperature + "°C).");
    }

    @Override
    public String toString() {
        return "Crypt{" +
                "name='" + getName() + '\'' +
                ", surface=" + getSurface() +
                ", creatureMax=" + getCreatureMax() +
                ", creatureNow=" + getCreatureNow() +
                ", budget='" + budgetToString(getBudget()) +
                "', ventilationLevel=" + ventilationLevel +
                ", temperature=" + temperature +
                ", creatures=" + Arrays.toString(getCreatures()) +
                "}";
    }
}
