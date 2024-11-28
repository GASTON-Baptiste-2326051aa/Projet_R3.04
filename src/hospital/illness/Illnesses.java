package hospital.illness;

/**
 * The Illnesses enum class
 */
public enum Illnesses {
    MDC("MDC", "Maladie débilitante chronique", 7),
    FOMO("FOMO", "Fear of missing out", 10),
    DRS("DRS", "Dépendance aux réseaux sociaux", 6),
    PEC("PEC", "Porphyrie érythropoïétique congénitale", 5),
    ZPL("ZPL", "Zoopathie paraphrénique lycanthropique", 4),
    NDMAD("NDMAD", "Not Defined Maladie A Définir", 2);

    /**
     * the name of the Illness
     */
    private final String name;
    /**
     * the full name of the Illness
     */
    private final String fullName;
    /**
     * the level of the Illness
     */
    private final int lvlMax;

    /**
     * the constructor of the enum class Illness
     *
     * @param name     the name of Illness
     * @param fullName the full name of Illness
     * @param lvlMax   the max level of the Illness
     */
    Illnesses(String name, String fullName, int lvlMax) {
        this.name = name;
        this.fullName = fullName;
        this.lvlMax = lvlMax;
    }

    public static Illness getRandomIllness() {
        return new Illness(Illnesses.values()[(int) (Math.random() * Illnesses.values().length)]);
    }

    /**
     * Return the full name of an illness
     *
     * @return the full name of an illness
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * return this.name
     *
     * @return this.name
     */
    public String getName() {
        return name;
    }

    /**
     * return max level of the illness
     *
     * @return max level of the illness
     */
    public int getLvlMax() {
        return lvlMax;
    }
}
