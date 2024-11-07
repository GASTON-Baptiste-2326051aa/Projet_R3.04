public enum Illness {
    MDC("MDC", "Maladie débilitante chronique", 0, 7),
    FOMO("FOMO", "Fear of missing out", 0, 10),
    DRS("DRS", "Dépendance aux réseaux sociaux", 0, 6),
    PEC("PEC", "Porphyrie érythropoïétique congénitale", 0, 5),
    ZPL("ZPL", "Zoopathie paraphrénique lycanthropique", 0, 4),
    NDMAD("NDMAD", "Not Defined Maladie A Définir", 0, 2);

    private String name;
    private String fullName;
    private int lvl;
    private final int lvlMax;

    Illness(String name, String fullName, int lvl, int lvlMax) {
        this.name = name;
        this.fullName = fullName;
        this.lvl = lvl;
        this.lvlMax = lvlMax;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
        if (this.lvl <= 0)
            System.out.println(this.fullName + " guéri");
        else
            System.out.println(this.fullName + " a atteint le niveau " + this.lvl);
    }

    public int getLvlMax() {
        return lvlMax;
    }

    public void downgrade() {
        if (this.lvl > 0) {
            this.lvl--;
        }
    }

    public void upgrade() {
        this.lvl++;
    }

    public boolean is_mortal() {
        return this.lvl == this.lvlMax;
    }

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
