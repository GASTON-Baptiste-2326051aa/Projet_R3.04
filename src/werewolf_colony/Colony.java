package werewolf_colony;

/**
 * The `Colony` class represents a colony of werewolves.
 */
public class Colony {

    /**
     * The maximum number of minutes the colony can run.
     */
    private final static int MAX_MINUTES = 1;

    /**
     * The array of howls in the colony.
     */
    private final Howl[] howls;

    /**
     * The array of packs in the colony.
     */
    private final Pack[] packs;

    /**
     * The array of werewolves in the colony.
     */
    private final Werewolf[] werewolfs;

    /**
     * Indicates whether the colony is running.
     */
    private boolean isRunning;

    /**
     * Constructor of the Colony class, allowing us to create a colony in our program.
     */
    public Colony() {
        this.howls = new Howl[10000];
        this.packs = new Pack[1000];
        this.werewolfs = new Werewolf[5000];
        this.isRunning = false;
    }

    /**
     * Main method, to launch the program.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int minutes = 0;
        Colony colony = new Colony();
        colony.setRunning(true);
        Werewolf l1 = new Werewolf(true, 0, 0, Rank.ALPHA, 0, colony);
        Werewolf l2 = new Werewolf(false, 0, 0, Rank.ALPHA, 0, colony);
        Werewolf l3 = new Werewolf(true, 0, 0, Rank.ALPHA, 0, colony);
        Werewolf l4 = new Werewolf(false, 0, 0, Rank.ALPHA, 0, colony);
        l1.createPack(colony, l2);
        l3.createPack(colony, l4);
        for (Pack pack : colony.getPacks()) {
            if (pack != null)
                pack.start();
        }
        long time = System.currentTimeMillis();
        while (colony.isRunning()) {
            for (Werewolf werewolf : colony.getWerewolfs())
                if (werewolf != null)
                    werewolf.run();
            if (time - System.currentTimeMillis() > 60000) {
                minutes++;
                for (Pack pack : colony.getPacks()) {
                    if (pack != null)
                        for (Werewolf werewolf : pack.getAllWerewolfs()) {
                            if (werewolf != null)
                                werewolf.vieillir(colony);
                        }
                }
                for (Werewolf werewolf : colony.getWerewolfs()) {
                    if (werewolf != null)
                        werewolf.vieillir(colony);
                }
                time = System.currentTimeMillis();
            }
            if (minutes >= MAX_MINUTES) {
                colony.setRunning(false);
            }
        }
        System.out.println("Number of howls : " + colony.getHowlCount());
        System.out.println("Number of packs : " + colony.getPackCount());
        System.out.println("Number of lone werewolfs : " + colony.getWerewolfCount());
        int werewolfCount = 0;
        for (Pack pack : colony.getPacks()) {
            if (pack != null)
                werewolfCount += pack.getWerewolfCount() + 1;
        }
        for (Werewolf werewolf : colony.getWerewolfs()) {
            if (werewolf != null)
                werewolfCount++;
        }
        System.out.println("Number of werewolfs : " + werewolfCount);
        System.out.println("End of the program.");
    }

    /**
     * Returns the array of howls in the colony.
     * @return the array of howls
     */
    public Howl[] getHowls() {
        return howls;
    }

    /**
     * Adds a howl to the colony.
     * @param howl the howl to add
     */
    public void addHowl(Howl howl) {
        for (int i = 0; i < howls.length; i++) {
            if (howls[i] == null) {
                howls[i] = howl;
                break;
            }
        }
        updateHowl();
    }

    /**
     * Removes a howl from the colony.
     * @param howl the howl to remove
     */
    public void removeHowl(Howl howl) {
        for (int i = 0; i < howls.length; i++) {
            if (howls[i] == howl) {
                howls[i] = null;
                break;
            }
        }
        updateHowl();
    }

    /**
     * Updates the howls in the colony.
     */
    public void updateHowl() {
        long time = System.currentTimeMillis();
        int nullCount = 0;
        for (int i = 0; i < howls.length - 1; i++) {
            if (howls[i] != null && time - howls[i].getTime() > 100) {
                removeHowl(howls[i]);
            } else if (howls[i] == null) {
                nullCount++;
            }
            if (nullCount >= 100) {
                break;
            }
        }
        System.out.println("il y a maintenant " + getHowlCount() + " howls.");
    }

    /**
     * Returns the number of howls in the colony.
     * @return the number of howls
     */
    public int getHowlCount() {
        int count = 0;
        for (Howl howl : howls) {
            if (howl != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the array of packs in the colony.
     * @return the array of packs
     */
    public Pack[] getPacks() {
        return packs;
    }

    /**
     * Adds a pack to the colony.
     * @param pack the pack to add
     */
    public void addPack(Pack pack) {
        for (int i = 0; i < packs.length; i++) {
            if (packs[i] == null) {
                packs[i] = pack;
                break;
            }
        }
        System.out.println("il y a maintenant " + getPackCount() + " packs.");
    }

    /**
     * Returns the number of packs in the colony.
     * @return the number of packs
     */
    public int getPackCount() {
        int count = 0;
        for (Pack pack : packs) {
            if (pack != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the array of werewolves in the colony.
     * @return the array of werewolves
     */
    public Werewolf[] getWerewolfs() {
        return werewolfs;
    }

    /**
     * Adds a werewolf to the colony.
     * @param werewolf the werewolf to add
     */
    public void addWerewolf(Werewolf werewolf) {
        for (int i = 0; i < werewolfs.length; i++) {
            if (werewolfs[i] == null) {
                werewolfs[i] = werewolf;
                break;
            }
        }
        System.out.println("il y a maintenant " + getWerewolfCount() + " werewolfs solitaires.");
    }

    /**
     * Removes a werewolf from the colony.
     * @param werewolf the werewolf to remove
     */
    public void removeWerewolf(Werewolf werewolf) {
        int nullCount = 0;
        for (int i = 0; i < werewolfs.length; i++) {
            if (werewolfs[i] != null && werewolfs[i] == werewolf) {
                werewolfs[i] = null;
                break;
            } else if (werewolfs[i] == null) {
                nullCount++;
            }
            if (nullCount >= 100) {
                break;
            }
        }
        System.out.println("il y a maintenant " + getWerewolfCount() + " werewolfs solitaires.");
    }

    /**
     * Returns the number of werewolves in the colony.
     * @return the number of werewolves
     */
    public int getWerewolfCount() {
        int count = 0;
        for (Werewolf werewolf : werewolfs) {
            if (werewolf != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns whether the colony is running.
     * @return `true` if the colony is running, `false` otherwise
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Sets whether the colony is running.
     * @param running the new running state of the colony
     */
    public void setRunning(boolean running) {
        isRunning = running;
    }
}