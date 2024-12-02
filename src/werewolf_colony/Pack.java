package werewolf_colony;

public class Pack extends Thread {
    private final CoupleWerewolf coupleWerewolf;
    private final Colony colony;
    private Werewolf[] werewolfs;

    /**
     * Constructor of the Pack class
     * @param coupleWerewolf
     * @param werewolfs
     * @param colony
     */
    public Pack(CoupleWerewolf coupleWerewolf, Werewolf[] werewolfs, Colony colony) {
        this.coupleWerewolf = coupleWerewolf;
        this.werewolfs = werewolfs;
        this.colony = colony;
    }

    /**
     * Return the list of werewolves in the pack
     * @return
     */
    public Werewolf[] getWerewolfs() {
        return this.werewolfs;
    }

    /**
     * Return a couple of werewolves
     * @return
     */
    public CoupleWerewolf getCoupleWerewolf() {
        return this.coupleWerewolf;
    }

    /**
     * Add a werewolve to the pack
     * @param werewolf
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
     * Return the number of werewolves
     * @return
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
     * Return the best rank among the females werewolves
     * @return
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
     * Sort the werewolves by their rank
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
     * Return the colony
     * @return
     */
    public Colony getColony() {
        return colony;
    }

    /**
     * Run the program
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
            try {
                this.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
