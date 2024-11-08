package models.services;

import models.creatures.Creature;

public class Crypt extends Service {
    /**
     * Constructor of the Crypt constructor
     * @param name the name of the service
     * @param surface the surface of the service
     * @param creatureMax the maximum number of creatures that can be in the service
     * @param creatureNow the current number of creatures in the service
     * @param creatures the creatures in the service
     * @param budget the budget of the service
     */
    public Crypt(String name, float surface, int creatureMax, int creatureNow, Creature[] creatures, int budget) {
        super(name, surface, creatureMax, creatureNow, creatures, budget);
    }

    @Override
    public void setBudget(int budget) {

    }
}
