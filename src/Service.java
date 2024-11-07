import java.util.Arrays;

public class Service {
    private String name;
    private float surface;
    private final int creatureMax;
    private int creatureNow;
    private Creature[] creatures;
    private int budget;

    public Service(String name, float surface, int creatureMax, int creatureNow, Creature[] creatures, int budget) {
        this.name = name;
        this.surface = surface;
        this.creatureMax = creatureMax;
        this.creatureNow = creatureNow;
        this.creatures = creatures;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public int getCreatureMax() {
        return creatureMax;
    }

    public int getCreatureNow() {
        return creatureNow;
    }

    public void setCreatureNow() {
        this.creatureNow = this.creatures.length;
    }

    public Creature[] getCreatures() {
        return creatures;
    }

    public void setCreatures(Creature[] creatures) {
        this.creatures = creatures;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String budgetToString(int budget) {
        return switch (budget) {
            case 0 -> "inexistant";
            case 1 -> "médiocre";
            case 2 -> "insuffisant";
            case 3 -> "faible";
            default -> "correct";
        };
    }

    public void addCreature(Creature creature) {
        if (this.creatureNow < this.creatureMax) {
            this.creatures[this.creatureNow] = creature;
            this.creatureNow++;
        }
    }

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

    public void cure(Creature creature) {
        for (int i = 0; i < this.creatureNow; i++) {
            if (this.creatures[i].equals(creature)) {
                this.creatures[i].cure(
                        this.creatures[i].getIllnesses()[0]
                    );
                this.removeCreature(creature);
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
                ", budget='" + this.budgetToString(this.budget) +
                "'}";
    }
}
