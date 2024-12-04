package werewolf_colony;

import java.util.ArrayList;
import java.util.List;

public class Pack extends Thread {
    private final CoupleWerewolf coupleWerewolf;
    private final Colony colony;
    private List<Werewolf> werewolfs;

    /**
     * Constructor of the Pack class
     * @param coupleWerewolf
     * @param werewolfs
     * @param colony
     */
    public Pack(CoupleWerewolf coupleWerewolf, List<Werewolf> werewolfs, Colony colony) {
        this.coupleWerewolf = coupleWerewolf;
        this.werewolfs = werewolfs;
        this.colony = colony;
    }

    /**
     * Return the list of werewolves in the pack
     * @return
     */
    public List<Werewolf> getWerewolfs() {
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
        werewolfs.add(werewolf);
        sortWerewolfs();
        System.out.println("The pack contains " + getWerewolfCount() + " werewolves.");
    }

    public void removeWerewolf(Werewolf werewolf) {
        werewolfs.remove(werewolf);
        sortWerewolfs();
        System.out.println("The pack contains " + getWerewolfCount() + " werewolves.");
    }

    /**
     * Return the number of werewolves
     * @return
     */
    public int getWerewolfCount() {
        return werewolfs.size();
    }

    /**
     * Return the best rank among the females werewolves
     * @return
     */
    public Werewolf getBestRankFemale() {
        Werewolf bestRankFemale = new Werewolf(false, 0, 0, Rank.BETA, 0, colony);
        for (Werewolf werewolf : werewolfs) {
            if (!werewolf.isMale() && werewolf.getRank().getValue() > bestRankFemale.getRank().getValue()) {
                bestRankFemale = werewolf;
            }
        }
        return bestRankFemale;
    }

    public List<Werewolf> getAllWerewolfs() {
        List<Werewolf> allWerewolfs = new ArrayList<>();
        allWerewolfs.add(coupleWerewolf.getMale());
        allWerewolfs.addAll(werewolfs);
        return allWerewolfs;
    }

    /**
     * Sort the werewolves by their rank
     */
    public void sortWerewolfs() {
        werewolfs.sort((werewolf1, werewolf2) -> werewolf1.getRank().getValue() - werewolf2.getRank().getValue());
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

    @Override
    public String toString() {
        return "Pack{" +
                "coupleWerewolf=" + coupleWerewolf +
                ", colony=" + colony +
                ", werewolfs=" + werewolfs +
                "} extends " + super.toString();
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
