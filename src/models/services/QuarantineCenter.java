package models.services;

import models.Creature;
import models.Service;

public class QuarantineCenter extends Service {
    private double ventilationLevel;
    private double temperature;

    /**
     * Constructor of the QuarantineCenter class
     *
     * @param name
     * @param surface
     * @param creatureMax
     * @param creatureNow
     * @param creatures
     * @param budget
     */
    public QuarantineCenter(String name, float surface, int creatureMax, int creatureNow, Creature[] creatures, int budget) {
        super(name, surface, creatureMax, creatureNow, creatures, budget);
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getVentilationLevel() {
        return ventilationLevel;
    }

    public void setVentilationLevel(double ventilationLevel) {
        this.ventilationLevel = ventilationLevel;
    }


}


