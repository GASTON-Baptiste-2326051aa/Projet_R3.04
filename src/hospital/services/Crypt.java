package hospital.services;

import hospital.entity.Creature;
import hospital.race.Zombie;
import hospital.race.behavior.Revive;

import java.util.Arrays;
import java.util.Collection;

/**
 * Crypt
 */
public class Crypt extends Service {
    /**
     * The ventilation level of the crypt
     */
    private int ventilationLevel; // Niveau de ventilation (de 1 à 10, par exemple)
    /**
     * The temperature of the crypt
     */
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
     * @throws IllegalArgumentException if the creature is not a regenerative creature
     * @throws IllegalStateException if the service is full or the creature is already in the service
     */
    @Override
    public void addCreature(Creature creature) throws IllegalArgumentException{
        if (creature instanceof Revive) { // vérifier si c'est un mort vivant
            super.addCreature(creature);
        } else {
            System.out.println("Only regenerative creatures are allowed in a crypt.");
            throw new IllegalArgumentException("Only regenerative creatures are allowed in a crypt");
        }
    }

    @Override
    public void setCreatures(Collection<Creature> creatures) {
        Creature creature1;
        if (creatures == null) {
            throw new IllegalArgumentException("The creatures list is empty");
        }
        if (creatures.isEmpty()) {
            throw new IllegalArgumentException("The creatures list is empty");
        }
        creature1 = creatures.iterator().next();
        if (!(creature1 instanceof Revive)) {
            throw new IllegalArgumentException("Only regenerative creatures are allowed in a crypt");
        }
        for (Creature creature : creatures) {
            if (!creature.getClass().equals(creature1.getClass())) {
                throw new IllegalArgumentException("The creatures are not the same type");
            }
        }
        super.setCreatures(creatures);
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

    /**
     * Run the crypt
     */
    @Override
    public void run(){
        for(Creature creature : getCreatures()) {
            creature.run();
        }
        System.out.println(getName() + " is running");
    }

    /**
     * Return the string representation of the crypt
     * @return the string representation of the crypt
     */
    @Override
    public String toString() {
        return "Crypt{" +
                "name=" + getName()  +
                ", surface=" + getSurface() +
                ", creatureMax=" + getCreatureMax() +
                ", creatureNow=" + getCreatureNow() +
                ", budget=" + budgetToString(getBudget()) +
                ", ventilationLevel=" + ventilationLevel +
                ", temperature=" + temperature +
                "}";
    }
}
