package models.services;

import models.creatures.Creature;

/**
 * Class QuarantineCenter
 */
public class QuarantineCenter extends Service {
    private double ventilationLevel;
    private double temperature;

    /**
     * Constructor of the QuarantineCenter class
     * @param name the name of the service
     * @param surface the surface of the service
     * @param creatureMax the maximum number of creatures that can be in the service
     * @param creatureNow the current number of creatures in the service
     * @param creatures the creatures in the service
     * @param budget the budget of the service
     */
    public QuarantineCenter(String name, float surface, int creatureMax, int creatureNow, Creature[] creatures, int budget) {
        super(name, surface, creatureMax, creatureNow, creatures, budget);
    }

    /**
     * return the temperature of the Quarantine Center
     * @return the temperature of the Quarantine Center
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * set the temperature of the Quarantine Center
     * @param temperature the temperature of the Quarantine Center
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * return the ventilation level of the Quarantine Center
     * @return the ventilation level of the Quarantine Center
     */
    public double getVentilationLevel() {
        return ventilationLevel;
    }

    /**
     * set the ventilation level of the Quarantine Center
     * @param ventilationLevel the ventilation level of the Quarantine Center
     */
    public void setVentilationLevel(double ventilationLevel) {
        this.ventilationLevel = ventilationLevel;
    }
}
