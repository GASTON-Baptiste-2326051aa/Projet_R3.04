package models;

public enum Illnesses {
    MDC("MDC", "Maladie débilitante chronique", 7),
    FOMO("FOMO", "Fear of missing out", 10),
    DRS("DRS", "Dépendance aux réseaux sociaux", 6),
    PEC("PEC", "Porphyrie érythropoïétique congénitale", 5),
    ZPL("ZPL", "Zoopathie paraphrénique lycanthropique", 4),
    NDMAD("NDMAD", "Not Defined Maladie A Définir", 2);

    private final String name;
    private final String fullName;
    private final int lvlMax;

    /**
     * the constructor of the enum class Illness
     *
     * @param name     the name of Illness
     * @param fullName the full name of Illness
     * @param lvl      the level of the Illness
     * @param lvlMax   the max level of the Illness
     */
    Illnesses(String name, String fullName, int lvlMax) {
        this.name = name;
        this.fullName = fullName;
        this.lvlMax = lvlMax;
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
