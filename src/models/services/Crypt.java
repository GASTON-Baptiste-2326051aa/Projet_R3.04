package models.services;

import models.Creature;
import models.Service;

public class Crypt extends Service {
    /**
     * Constructor of the Crypt constructor
     * @param name
     * @param surface
     * @param creatureMax
     * @param creatureNow
     * @param creatures
     * @param budget
     */
    public Crypt(String name, float surface, int creatureMax, int creatureNow, Creature[] creatures, int budget) {
        super(name, surface, creatureMax, creatureNow, creatures, budget);
    }

    @Override
    public void setBudget(int budget) {

    }
}
