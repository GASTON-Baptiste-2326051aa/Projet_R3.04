package werewolf_colony;

import java.util.ArrayList;
import java.util.List;

/**
 * The `Colony` class represents a colony of werewolves.
 */
public class Colony extends Pack {

    private final static int MAX_MINUTES = 1;

    /**
     * The list of howls in the colony.
     */
    private final List<Howl> howls;

    /**
     * The list of packs in the colony.
     */
    private final List<Pack> packs;

    /**
     * The list of solitary werewolves in the colony.
     */
    private final List<Werewolf> werewolfs;

    /**
     * Indicates whether the colony is running.
     */
    private boolean isRunning;

    /**
     * Constructor of the Colony class, allowing us to create a colony in our program.
     */
    public Colony() {
        super(null, new ArrayList<>(), null);
        this.howls = new ArrayList<>();
        this.packs = new ArrayList<>();
        this.werewolfs = new ArrayList<>();
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
     * Returns the list of howls in the colony.
     * @return the list of howls
     */
    public List<Howl> getHowls() {
        return howls;
    }

    /**
     * Adds a howl to the colony.
     * @param howl the howl to add
     */
    public void addHowl(Howl howl) {
        howls.add(howl);
        updateHowl();
    }

    /**
     * Removes a howl from the colony.
     * @param howl the howl to remove
     */
    public void removeHowl(Howl howl) {
        howls.remove(howl);
        updateHowl();
    }

    /**
     * Updates the list of howls in the colony.
     */
    public void updateHowl() {
        long time = System.currentTimeMillis();
        int nullCount = 0;
        for (int i = 0; i < howls.size() - 1; i++) {
            if (howls.get(i) != null && time - howls.get(i).getTime() > 100) {
                removeHowl(howls.get(i));
            } else if (howls.get(i) == null) {
                nullCount++;
            }
            if (nullCount >= 100) {
                break;
            }
        }
        System.out.println("there is now " + getHowlCount() + " howls actually.");
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
     * Returns the list of packs in the colony.
     * @return the list of packs
     */
    public List<Pack> getPacks() {
        return packs;
    }

    /**
     * Adds a pack to the colony.
     * @param pack the pack to add
     */
    public void addPack(Pack pack) {
        packs.add(pack);
        System.out.println("il y a maintenant " + getPackCount() + " packs.");
    }

    /**
     * Returns the number of packs in the colony.
     * @return the number of packs
     */
    public int getPackCount() {
        return packs.size();
    }

    /**
     * Returns the list of solitary werewolves in the colony.
     * @return the list of solitary werewolves
     */
    public List<Werewolf> getWerewolfs() {
        return werewolfs;
    }

    /**
     * Adds a solitary werewolf to the colony.
     * @param werewolf the solitary werewolf to add
     */
    public void addWerewolf(Werewolf werewolf) {
        werewolfs.add(werewolf);
        System.out.println("there is now " + getWerewolfCount() + " solitary werewolfs.");
    }

    /**
     * Removes a solitary werewolf from the colony.
     * @param werewolf the solitary werewolf to remove
     */
    public void removeWerewolf(Werewolf werewolf) {
        int nullCount = 0;
        werewolfs.remove(werewolf);
        System.out.println("il y a maintenant " + getWerewolfCount() + " werewolfs solitaires.");
    }

    /**
     * Returns the number of solitary werewolves in the colony.
     * @return the number of solitary werewolves
     */
    public int getWerewolfCount() {
        return werewolfs.size();
    }

    /**
     * Returns whether the colony is running.
     * @return true if the colony is running, false otherwise
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Sets whether the colony is running.
     * @param running true to set the colony as running, false otherwise
     */
    public void setRunning(boolean running) {
        isRunning = running;
    }

    /**
     * Returns the string representation of the colony.
     * @return the string representation of the colony
     */
    @Override
    public String toString() {
        return "Colony{" +
                "howls=" + howls +
                ", packs=" + packs +
                ", werewolfs=" + werewolfs +
                ", isRunning=" + isRunning +
                "} extends " + super.toString();
    }
}