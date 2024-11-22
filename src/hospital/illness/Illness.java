package hospital.illness;

/**
 * The Illness class
 */
public class Illness {

    /**
     * The amount of illnesses
     */
    public final static int AMOUNT = Illnesses.values().length;

    /**
     * The name of an illness
     */
    private final String name;
    /**
     * The full name of an illness
     */
    private final String fullName;
    /**
     * The level of an illness
     */
    private int lvl;
    /**
     * The max level of an illness
     */
    private final int lvlMax;

    /**
     * Constructor of the class Illness
     * @param illnesses the base of the creature's illness
     */
    public Illness(Illnesses illnesses) {
        this.name = illnesses.getName();
        this.fullName = illnesses.getFullName();
        this.lvl = 0;
        this.lvlMax = illnesses.getLvlMax();
    }

    /**
     * Return the full name of an illness
     * @return the full name of an illness
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Return the name of an illness
     * @return the name of an illness
     */
    public String getName() {
        return name;
    }

    /**
     * Return the level of an illness
     * @return the level of an illness
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * Set the level of an illness
     * @param lvl the level of an illness
     */
    public void setLvl(int lvl) {
        this.lvl = lvl;
        if (this.lvl > lvlMax) {
            this.lvl = lvlMax;
        } else if (this.lvl < 0) {
            this.lvl = 0;
        }
    }

    /**
     * Return the max level of an illness
     * @return the max level of an illness
     */
    public int getLvlMax() {
        return lvlMax;
    }

    /**
     * Increase the level of an illness
     */
    public void increase() {
        if (lvl < lvlMax) {
            setLvl(lvl + 1);
        }
    }

    /**
     * Decrease the level of an illness
     */
    public void decrease() {
        if (lvl > 0) {
            setLvl(lvl - 1);
        }
    }

    /**
     * Return if the illness is mortal
     * @return if the illness is mortal
     */
    public boolean is_mortal() {
        return lvl == lvlMax;
    }

    /**
     * Return the string representation of an illness
     * @return the string representation of an illness
     */
    public String toString() {
        return "Illness{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", lvl=" + lvl +
                ", lvlMax=" + lvlMax +
                '}';
    }
}
