package werewolf_colony;

/**
 * The `Pack` class represents a pack of werewolves.
 */
public class Pack extends Thread {
    /**
     * The couple of werewolves leading the pack.
     */
    private final CoupleWerewolf coupleWerewolf;

    /**
     * The colony to which the pack belongs.
     */
    private final Colony colony;

    /**
     * The array of werewolves in the pack.
     */
    private Werewolf[] werewolfs;

    /**
     * Constructor of the Pack class.
     * @param coupleWerewolf the couple of werewolves leading the pack
     * @param werewolfs the array of werewolves in the pack
     * @param colony the colony to which the pack belongs
     */
    public Pack(CoupleWerewolf coupleWerewolf, Werewolf[] werewolfs, Colony colony) {
        this.coupleWerewolf = coupleWerewolf;
        this.werewolfs = werewolfs;
        this.colony = colony;
    }

    /**
     * Returns the array of werewolves in the pack.
     * @return the array of werewolves
     */
    public Werewolf[] getWerewolfs() {
        return this.werewolfs;
    }

    /**
     * Returns the couple of werewolves leading the pack.
     * @return the couple of werewolves
     */
    public CoupleWerewolf getCoupleWerewolf() {
        return this.coupleWerewolf;
    }

    /**
     * Adds a werewolf to the pack.
     * @param werewolf the werewolf to add
     */
    public void addWerewolf(Werewolf werewolf) {
        for (int i = 0; i < werewolfs.length; i++) {
            if (werewolfs[i] == null) {
                werewolfs[i] = werewolf;
                break;
            }
        }
        sortWerewolfs();
        System.out.println("The pack contains " + getWerewolfCount() + " werewolves.");
    }

    /**
     * Removes a werewolf from the pack.
     * @param werewolf the werewolf to remove
     */
    public void removeWerewolf(Werewolf werewolf) {
        for (int i = 0; i < werewolfs.length; i++) {
            if (werewolfs[i] == werewolf) {
                werewolfs[i] = null;
                break;
            }
        }
        sortWerewolfs();
        System.out.println("The pack contains " + getWerewolfCount() + " werewolves.");
    }

    /**
     * Returns the number of werewolves in the pack.
     * @return the number of werewolves
     */
    public int getWerewolfCount() {
        int count = 1;
        for (Werewolf werewolf : werewolfs) {
            if (werewolf != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the best rank among the female werewolves in the pack.
     * @return the best rank female werewolf
     */
    public Werewolf getBestRankFemale() {
        Werewolf bestRankFemale = werewolfs[0];
        for (Werewolf werewolf : werewolfs) {
            if (werewolf != null && !werewolf.isMale() && werewolf.getRank().getValue() > bestRankFemale.getRank().getValue()) {
                bestRankFemale = werewolf;
            }
        }
        return bestRankFemale;
    }

    /**
     * Returns all werewolves in the pack, including the leading couple.
     * @return the array of all werewolves
     */
    public Werewolf[] getAllWerewolfs() {
        Werewolf[] allWerewolfs = new Werewolf[werewolfs.length + 1];
        allWerewolfs[0] = coupleWerewolf.getMale();
        int i = 1;
        for (Werewolf werewolf : werewolfs) {
            if (werewolf != null) {
                allWerewolfs[i++] = werewolf;
            }
        }
        return allWerewolfs;
    }

    /**
     * Sorts the werewolves in the pack by their rank.
     */
    public void sortWerewolfs() {
        Werewolf[] sortedWerewolfs = new Werewolf[werewolfs.length];
        int i = 0;
        for (Rank rank : Rank.values()) {
            for (Werewolf werewolf : werewolfs) {
                if (werewolf != null && werewolf.getRank() == rank) {
                    sortedWerewolfs[i++] = werewolf;
                }
            }
        }
        this.werewolfs = sortedWerewolfs;
    }

    /**
     * Returns the first available rank for a new werewolf.
     * @return the array of available ranks
     */
    public Rank[] firstRankAvailable() {
        Rank[] ranks = Rank.values();
        for (Werewolf werewolf : getAllWerewolfs()) {
            if (werewolf != null && werewolf.getRank().getValue() == ranks[0].getValue()) {
                ranks[0] = ranks[1];
            }
        }
        return ranks;
    }

    /**
     * Returns the colony to which the pack belongs.
     * @return the colony
     */
    public Colony getColony() {
        return colony;
    }

    /**
     * Runs the pack's activities.
     */
    @Override
    public void run() {
        while (getColony().isRunning()) {
            for (Werewolf werewolf : werewolfs) {
                if (werewolf != null) {
                    werewolf.run();
                }
            }
            this.coupleWerewolf.getMale().run();
            this.coupleWerewolf.getFemale().run();
        }
    }
}