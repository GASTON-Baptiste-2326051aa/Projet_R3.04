package werewolf_colony;

import java.util.ArrayList;
import java.util.List;

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
     * The list of werewolves in the pack.
     */
    private List<Werewolf> werewolfs;

    /**
     * Constructor of the Pack class.
     * @param coupleWerewolf the couple of werewolves leading the pack
     * @param werewolfs the list of werewolves in the pack
     * @param colony the colony to which the pack belongs
     */
    public Pack(CoupleWerewolf coupleWerewolf, List<Werewolf> werewolfs, Colony colony) {
        this.coupleWerewolf = coupleWerewolf;
        this.werewolfs = werewolfs;
        this.colony = colony;
    }

    /**
     * Returns the list of werewolves in the pack.
     * @return the list of werewolves
     */
    public List<Werewolf> getWerewolfs() {
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
        werewolfs.add(werewolf);
        sortWerewolfs();
        System.out.println("The pack contains " + getWerewolfCount() + " werewolves.");
    }

    /**
     * Removes a werewolf from the pack.
     * @param werewolf the werewolf to remove
     */
    public void removeWerewolf(Werewolf werewolf) {
        werewolfs.remove(werewolf);
        sortWerewolfs();
        System.out.println("The pack contains " + getWerewolfCount() + " werewolves.");
    }

    /**
     * Returns the number of werewolves in the pack.
     * @return the number of werewolves
     */
    public int getWerewolfCount() {
        return werewolfs.size();
    }

    /**
     * Returns the best rank among the female werewolves in the pack.
     * @return the best rank female werewolf
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

    /**
     * Returns all werewolves in the pack, including the leading couple.
     * @return the list of all werewolves
     */
    public List<Werewolf> getAllWerewolfs() {
        List<Werewolf> allWerewolfs = new ArrayList<>();
        allWerewolfs.add(coupleWerewolf.getMale());
        allWerewolfs.addAll(werewolfs);
        return allWerewolfs;
    }

    /**
     * Sorts the werewolves in the pack by their rank.
     */
    public void sortWerewolfs() {
        werewolfs.sort((werewolf1, werewolf2) -> werewolf1.getRank().getValue() - werewolf2.getRank().getValue());
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
     * Returns the string representation of the pack.
     * @return the string representation of the pack
     */
    @Override
    public String toString() {
        return "Pack{" +
                "coupleWerewolf=" + coupleWerewolf +
                ", colony=" + colony +
                ", werewolfs=" + werewolfs +
                "} extends " + super.toString();
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
            try {
                this.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}