package werewolf_colony;

import java.util.ArrayList;
import java.util.List;

public class Colony extends Pack {

    private final static int MAX_MINUTES = 1;

    private final List<Howl> howls;
    private final List<Pack> packs;
    private final List<Werewolf> werewolfs;
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
     * Main method, to launch the program
     * @param args
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

    public List<Howl> getHowls() {
        return howls;
    }

    public void addHowl(Howl howl) {
        howls.add(howl);
        updateHowl();
    }

    public void removeHowl(Howl howl) {
        howls.remove(howl);
        updateHowl();
    }

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

    public int getHowlCount() {
        int count = 0;
        for (Howl howl : howls) {
            if (howl != null) {
                count++;
            }
        }
        return count;
    }

    public List<Pack> getPacks() {
        return packs;
    }

    public void addPack(Pack pack) {
        packs.add(pack);
        System.out.println("il y a maintenant " + getPackCount() + " packs.");
    }

    public int getPackCount() {
        return packs.size();
    }

    public List<Werewolf> getWerewolfs() {
        return werewolfs;
    }

    public void addWerewolf(Werewolf werewolf) {
        werewolfs.add(werewolf);
        System.out.println("there is now " + getWerewolfCount() + " solitary werewolfs.");
    }

    public void removeWerewolf(Werewolf werewolf) {
        int nullCount = 0;
        werewolfs.remove(werewolf);
        System.out.println("il y a maintenant " + getWerewolfCount() + " werewolfs solitaires.");
    }

    public int getWerewolfCount() {
        return werewolfs.size();
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

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
