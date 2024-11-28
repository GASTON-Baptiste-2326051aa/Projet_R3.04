package pack;

public class Meute extends Thread {
    private Werewolf[] lycanthropes;
    private final CoupleWerewolf coupleLycanthrope;
    private final World world;

    /**
     * Constructor of the Pack class
     * @param coupleLycanthrope
     * @param lycanthropes
     * @param world
     */
    public Meute(CoupleWerewolf coupleLycanthrope, Werewolf[] lycanthropes, World world) {
        this.coupleLycanthrope = coupleLycanthrope;
        this.lycanthropes = lycanthropes;
        this.world = world;
    }

    /**
     * Return the list of werewolves in the pack
     * @return
     */
    public Werewolf[] getLycanthropes() {
        return this.lycanthropes;
    }

    public CoupleLycanthrope getCoupleLycanthrope() {
        return this.coupleLycanthrope;
    }

    /**
     * Add a werewolve to the pack
     * @param lycanthrope
     */
    public void addLycanthrope(Werewolf lycanthrope) {
        for (int i = 0; i < lycanthropes.length; i++) {
            if (lycanthropes[i] == null) {
                lycanthropes[i] = lycanthrope;
                break;
            }
        }
        sortLycanthropes();
        System.out.println("La meute contient maintenant " + getLycanthropeCount() + " lycanthropes.");
    }

    public void removeLycanthrope(Werewolf lycanthrope) {
        for (int i = 0; i < lycanthropes.length; i++) {
            if (lycanthropes[i] == lycanthrope) {
                lycanthropes[i] = null;
                break;
            }
        }
        sortLycanthropes();
        System.out.println("La meute contient maintenant " + getLycanthropeCount() + " lycanthropes.");
    }

    public int getLycanthropeCount() {
        int count = 1;
        for (Werewolf lycanthrope : lycanthropes) {
            if (lycanthrope != null) {
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
        Werewolf bestRankFemale = lycanthropes[0];
        for (Werewolf lycanthrope : lycanthropes) {
            if (lycanthrope != null && !lycanthrope.isMale() && lycanthrope.getRang().getValue() > bestRankFemale.getRang().getValue()) {
                bestRankFemale = lycanthrope;
            }
        }
        return bestRankFemale;
    }

    public Werewolf[] getAllLycanthropes() {
        Werewolf[] allLycanthropes = new Werewolf[lycanthropes.length + 1];
        allLycanthropes[0] = coupleLycanthrope.getMale();
        int i = 1;
        for (Werewolf lycanthrope : lycanthropes) {
            if (lycanthrope != null) {
                allLycanthropes[i++] = lycanthrope;
            }
        }
        return allLycanthropes;
    }

    public void sortLycanthropes() {
        Werewolf[] sortedLycanthropes = new Werewolf[lycanthropes.length];
        int i = 0;
        for (Rank rank : Rank.values()) {
            for (Werewolf lycanthrope : lycanthropes) {
                if (lycanthrope != null && lycanthrope.getRang() == rank) {
                    sortedLycanthropes[i++] = lycanthrope;
                }
            }
        }
        this.lycanthropes = sortedLycanthropes;
    }

    public Rank[] firstRankAvailable() {
        Rank[] ranks = Rank.values();
        for (Werewolf lycanthrope : getAllLycanthropes()) {
            if (lycanthrope != null && lycanthrope.getRang().getValue() == ranks[0].getValue()) {
                ranks[0] = ranks[1];
            }
        }
        return ranks;
    }

    public World getWorld() {
        return world;
    }

    @Override
    public void run() {
        for (Werewolf lycanthrope : lycanthropes) {
            if (lycanthrope != null) {
                lycanthrope.start();
            }
        }
        this.coupleLycanthrope.getMale().start();
        this.coupleLycanthrope.getFemale().start();
        try {
            this.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
