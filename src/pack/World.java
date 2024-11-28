package pack;

public class World {

    private final static int MAX_MINUTES = 1;

    private final Hurlement[] hurlements;
    private final Meute[] meutes;
    private final Werewolf[] lycanthropes;
    private boolean isRunning;

    public World() {
        this.hurlements = new Hurlement[10000];
        this.meutes = new Meute[1000];
        this.lycanthropes = new Werewolf[5000];
        this.isRunning = false;
    }

    public static void main(String[] args) {
        int minutes = 0;
        World world = new World();
        world.setRunning(true);
        Werewolf l1 = new Werewolf(true, 0, 0, Rank.ALPHA, 0, null, world);
        Werewolf l2 = new Werewolf(false, 0, 0, Rank.ALPHA, 0, null, world);
        Werewolf l3 = new Werewolf(true, 0, 0, Rank.ALPHA, 0, null, world);
        Werewolf l4 = new Werewolf(false, 0, 0, Rank.ALPHA, 0, null, world);
        l1.creerMeute(world, l2);
        l3.creerMeute(world, l4);
        for (Meute meute : world.getMeutes()) {
            if (meute != null)
                meute.start();
        }
        for (Werewolf lycanthrope : world.getLycanthropes()) {
            if (lycanthrope != null)
                lycanthrope.start();
        }
        long time = System.currentTimeMillis();
        while (world.isRunning()) {
            if (time - System.currentTimeMillis() > 60000) {
                minutes++;
                for (Meute meute : world.getMeutes()) {
                    if (meute != null)
                        for (Werewolf lycanthrope : meute.getAllLycanthropes()) {
                            if (lycanthrope != null)
                                lycanthrope.vieillir(world);
                        }
                }
                for (Werewolf lycanthrope : world.getLycanthropes()) {
                    if (lycanthrope != null)
                        lycanthrope.vieillir(world);
                }
                time = System.currentTimeMillis();
            }
            if (minutes >= MAX_MINUTES) {
                world.setRunning(false);
            }
        }
        System.out.println("Nombre de hurlements : " + world.getHurlementCount());
        System.out.println("Nombre de meutes : " + world.getMeuteCount());
        System.out.println("Nombre de lycanthropes solitaires : " + world.getLycanthropeCount());
        int lycanthropeCount = 0;
        for (Meute meute : world.getMeutes()) {
            if (meute != null)
                lycanthropeCount += meute.getLycanthropeCount() + 1;
        }
        for (Werewolf lycanthrope : world.getLycanthropes()) {
            if (lycanthrope != null)
                lycanthropeCount++;
        }
        System.out.println("Nombre de lycanthropes : " + lycanthropeCount);
        System.out.println("Fin du programme.");
    }

    public Hurlement[] getHurlements() {
        return hurlements;
    }

    public void addHurlement(Hurlement hurlement) {
        for (int i = 0; i < hurlements.length; i++) {
            if (hurlements[i] == null) {
                hurlements[i] = hurlement;
                break;
            }
        }
        updateHurlement();
    }

    public void removeHurlement(Hurlement hurlement) {
        for (int i = 0; i < hurlements.length; i++) {
            if (hurlements[i] == hurlement) {
                hurlements[i] = null;
                break;
            }
        }
        updateHurlement();
    }

    public void updateHurlement() {
        long time = System.currentTimeMillis();
        int nullCount = 0;
        for (int i = 0; i < hurlements.length - 1; i++) {
            if (hurlements[i] != null && time - hurlements[i].getTime() > 100) {
                removeHurlement(hurlements[i]);
            } else if (hurlements[i] == null) {
                nullCount++;
            }
            if (nullCount >= 100) {
                break;
            }
        }
        System.out.println("il y a maintenant " + getHurlementCount() + " hurlements.");
    }

    public int getHurlementCount() {
        int count = 0;
        for (Hurlement hurlement : hurlements) {
            if (hurlement != null) {
                count++;
            }
        }
        return count;
    }

    public Meute[] getMeutes() {
        return meutes;
    }

    public void addMeute(Meute meute) {
        for (int i = 0; i < meutes.length; i++) {
            if (meutes[i] == null) {
                meutes[i] = meute;
                break;
            }
        }
        System.out.println("il y a maintenant " + getMeuteCount() + " meutes.");
    }

    public int getMeuteCount() {
        int count = 0;
        for (Meute meute : meutes) {
            if (meute != null) {
                count++;
            }
        }
        return count;
    }

    public Werewolf[] getLycanthropes() {
        return lycanthropes;
    }

    public void addLycanthrope(Werewolf lycanthrope) {
        for (int i = 0; i < lycanthropes.length; i++) {
            if (lycanthropes[i] == null) {
                lycanthropes[i] = lycanthrope;
                break;
            }
        }
        System.out.println("il y a maintenant " + getLycanthropeCount() + " lycanthropes solitaires.");
    }

    public void removeLycanthrope(Werewolf lycanthrope) {
        int nullCount = 0;
        for (int i = 0; i < lycanthropes.length; i++) {
            if (lycanthropes[i] != null && lycanthropes[i] == lycanthrope) {
                lycanthropes[i] = null;
                break;
            } else if (lycanthropes[i] == null) {
                nullCount++;
            }
            if (nullCount >= 100) {
                break;
            }
        }
        System.out.println("il y a maintenant " + getLycanthropeCount() + " lycanthropes solitaires.");
    }

    public int getLycanthropeCount() {
        int count = 0;
        for (Werewolf lycanthrope : lycanthropes) {
            if (lycanthrope != null) {
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
