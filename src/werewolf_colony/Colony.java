package werewolf_colony;

public class Colony {

    private final static int MAX_MINUTES = 1;

    private final Howl[] howls;
    private final Pack[] packs;
    private final Werewolf[] werewolfs;
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

    public Howl[] getHowls() {
        return howls;
    }

    public void addHowl(Howl howl) {
        for (int i = 0; i < howls.length; i++) {
            if (howls[i] == null) {
                howls[i] = howl;
                break;
            }
        }
        updateHowl();
    }

    public void removeHowl(Howl howl) {
        for (int i = 0; i < howls.length; i++) {
            if (howls[i] == howl) {
                howls[i] = null;
                break;
            }
        }
        updateHowl();
    }

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

    public int getHowlCount() {
        int count = 0;
        for (Howl howl : howls) {
            if (howl != null) {
                count++;
            }
        }
        return count;
    }

    public Pack[] getPacks() {
        return packs;
    }

    public void addPack(Pack pack) {
        for (int i = 0; i < packs.length; i++) {
            if (packs[i] == null) {
                packs[i] = pack;
                break;
            }
        }
        System.out.println("il y a maintenant " + getPackCount() + " packs.");
    }

    public int getPackCount() {
        int count = 0;
        for (Pack pack : packs) {
            if (pack != null) {
                count++;
            }
        }
        return count;
    }

    public Werewolf[] getWerewolfs() {
        return werewolfs;
    }

    public void addWerewolf(Werewolf werewolf) {
        for (int i = 0; i < werewolfs.length; i++) {
            if (werewolfs[i] == null) {
                werewolfs[i] = werewolf;
                break;
            }
        }
        System.out.println("il y a maintenant " + getWerewolfCount() + " werewolfs solitaires.");
    }

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

    public int getWerewolfCount() {
        int count = 0;
        for (Werewolf werewolf : werewolfs) {
            if (werewolf != null) {
                count++;
            }
        }
        return count;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
