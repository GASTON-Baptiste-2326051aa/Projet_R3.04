package pack;

public class Meute extends Thread {
    private Lycanthrope[] lycanthropes;
    private final CoupleLycanthrope coupleLycanthrope;
    private final World world;

    public Meute(CoupleLycanthrope coupleLycanthrope, Lycanthrope[] lycanthropes, World world) {
        this.coupleLycanthrope = coupleLycanthrope;
        this.lycanthropes = lycanthropes;
        this.world = world;
    }

    public Lycanthrope[] getLycanthropes() {
        return this.lycanthropes;
    }

    public CoupleLycanthrope getCoupleLycanthrope() {
        return this.coupleLycanthrope;
    }

    public void addLycanthrope(Lycanthrope lycanthrope) {
        for (int i = 0; i < lycanthropes.length; i++) {
            if (lycanthropes[i] == null) {
                lycanthropes[i] = lycanthrope;
                break;
            }
        }
        sortLycanthropes();
        System.out.println("La meute contient maintenant " + getLycanthropeCount() + " lycanthropes.");
    }

    public void removeLycanthrope(Lycanthrope lycanthrope) {
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
        for (Lycanthrope lycanthrope : lycanthropes) {
            if (lycanthrope != null) {
                count++;
            }
        }
        return count;
    }

    public Lycanthrope getBestRankFemale() {
        Lycanthrope bestRankFemale = lycanthropes[0];
        for (Lycanthrope lycanthrope : lycanthropes) {
            if (lycanthrope != null && !lycanthrope.isMale() && lycanthrope.getRang().getValue() > bestRankFemale.getRang().getValue()) {
                bestRankFemale = lycanthrope;
            }
        }
        return bestRankFemale;
    }

    public Lycanthrope[] getAllLycanthropes() {
        Lycanthrope[] allLycanthropes = new Lycanthrope[lycanthropes.length + 1];
        allLycanthropes[0] = coupleLycanthrope.getMale();
        int i = 1;
        for (Lycanthrope lycanthrope : lycanthropes) {
            if (lycanthrope != null) {
                allLycanthropes[i++] = lycanthrope;
            }
        }
        return allLycanthropes;
    }

    public void sortLycanthropes() {
        Lycanthrope[] sortedLycanthropes = new Lycanthrope[lycanthropes.length];
        int i = 0;
        for (Rank rank : Rank.values()) {
            for (Lycanthrope lycanthrope : lycanthropes) {
                if (lycanthrope != null && lycanthrope.getRang() == rank) {
                    sortedLycanthropes[i++] = lycanthrope;
                }
            }
        }
        this.lycanthropes = sortedLycanthropes;
    }

    public Rank[] firstRankAvailable() {
        Rank[] ranks = Rank.values();
        for (Lycanthrope lycanthrope : getAllLycanthropes()) {
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
        for (Lycanthrope lycanthrope : lycanthropes) {
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
