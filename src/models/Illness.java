package models;

/**
 * Enum Illness
 */
public enum Illness {
    /**
     * MDC Illness
     */
    MDC("MDC", "Maladie débilitante chronique", 0, 7),
    /**
     * FOMO Illness
     */
    FOMO("FOMO", "Fear of missing out", 0, 10),
    /**
     * DRS Illness
     */
    DRS("DRS", "Dépendance aux réseaux sociaux", 0, 6),
    /**
     * PEC Illness
     */
    PEC("PEC", "Porphyrie érythropoïétique congénitale", 0, 5),
    /**
     * ZPL Illness
     */
    ZPL("ZPL", "Zoopathie paraphrénique lycanthropique", 0, 4),
    /**
     * NDMAD Illness
     */
    NDMAD("NDMAD", "Not Defined Maladie A Définir", 0, 2);

    private String name;
    private String fullName;
    private int lvl;
    private final int lvlMax;

    /**
     * the constructor of the enum class Illness
     * @param name the name of Illness
     * @param fullName the full name of Illness
     * @param lvl the level of the Illness
     * @param lvlMax the max level of the Illness
     */
    Illness(String name, String fullName, int lvl, int lvlMax) {
        this.name = name;
        this.fullName = fullName;
        this.lvl = lvl;
        this.lvlMax = lvlMax;
    }

    /**
     * Return the full name of an illness
     * @return the full name of an illness
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * redefine the new value of this.fullName
     * @param fullName the new value of this.fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * return this.name
     * @return this.name
     */
    public String getName() {
        return name;
    }

    /**
     * define the new value of this.name
     * @param name the new value of this.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * return this.lvl
     * @return this.lvl
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * define the new value of this.lvl
     * @param lvl the new value of this.lvl
     */
    public void setLvl(int lvl) {
        this.lvl = lvl;
        if (this.lvl <= 0)
            System.out.println(this.fullName + " guéri");
        else
            System.out.println(this.fullName + " a atteint le niveau " + this.lvl);
    }

    /**
     * return max level of the illness
     * @return max level of the illness
     */
    public int getLvlMax() {
        return lvlMax;
    }

    /**
     * decrease illness level if possible
     */
    public void decrease() {
        if (this.lvl > 0) {
            this.lvl--;
        }
    }

    /**
     * increase illness level
     */
    public void increase() {
        this.lvl++;
    }

    /**
     * Return if illness is mortal or not
     * @return if illness is mortal or not
     */
    public boolean is_mortal() {
        return this.lvl == this.lvlMax;
    }

    /**
     * return "Illness{name='name', fullName='fullName', lvl=0, lvlMax=2}"
     * with this.name='name', this.fullName='fullName', this.lvl=0 and this.lvlMax=2
     * @return "Illness{name='name', fullName='fullName', lvl=0, lvlMax=2}"
     */
    @Override
    public String toString() {
        return "Illness{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", lvl=" + lvl +
                ", lvlMax=" + lvlMax +
                '}';
    }
}
