package werewolf_colony;

import java.util.ArrayList;
import java.util.Random;

public class Werewolf {

    public static Random random = new Random();
    private boolean isMale;
    private int catAge;
    private final Colony colony;
    private int domination;
    private int strength;
    private int lvl;
    private Rank rank;
    private int impetuosity;
    private boolean inRelationship;
    private Pack pack;

    /**
     * Constructor of the Werewolf class
     * @param isMale the sexe of the werewolf
     * @param catAge the category of ages of the werewolf
     * @param strength the strength of the werewolf
     * @param rank the rank of the werewolf
     * @param impetuosity the impetusity of the werewolf
     * @param pack the pack of the werewolf
     */
    public Werewolf(boolean isMale, int catAge, int strength, Rank rank, int impetuosity, Pack pack) {
        this.isMale = isMale;
        this.catAge = catAge;
        this.strength = strength;
        this.rank = rank;
        this.setImpetuosity(impetuosity);
        this.pack = pack;
        this.inRelationship = false;
        setDomination();
        this.colony = getPack().getColony();
    }

    /**
     * Constructor of the Werewolf class
     * @param isMale the sexe of the werewolf
     * @param catAge the category of ages of the werewolf
     * @param strength the strength of the werewolf
     * @param rank the rank of the werewolf
     * @param impetuosity the impetuosity of the werewolf
     * @param colony the colony of the werewolf
     */
    public Werewolf(boolean isMale, int catAge, int strength, Rank rank, int impetuosity, Colony colony) {
        this.isMale = isMale;
        this.catAge = catAge;
        this.strength = strength;
        this.rank = rank;
        this.setImpetuosity(impetuosity);
        this.pack = null;
        this.colony = colony;
        this.inRelationship = false;
        setDomination();
    }

    /**
     * Return true if the werewolf is a male, otherwise it is false
     * @return the sex of the werewolf
     */
    public boolean isMale() {
        return this.isMale;
    }

    /**
     * Set the gender of the werewolf
     * @param isMale true if it is a male, otherwise false if it is a female
     */
    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }


    public int getCatAge() {
        return this.catAge;
    }

    public void setCatAge(int catAge) {
        this.catAge = catAge;
        setLvl();
    }

    /**
     * Increments the age of the cat. It dies if it's older than 3 years old
     * @param colony the colony where the werewolf is
     */
    public void vieillir(Colony colony) {
        this.catAge++;
        if (this.catAge >= 3)
            this.die();
        setLvl();
    }

    public String catAgeToString(int catAge) {
        return switch (catAge) {
            case 0 -> "Young";
            case 1 -> "Adult";
            default -> "Old";
        };
    }

    /**
     * Return the strength of a werewolf
     * @return the strength of a werewolf
     */
    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        if (strength < 0)
            strength = 0;
        this.strength = strength;
        setLvl();
    }

    public int getDomination() {
        return this.domination;
    }

    public void setDomination() {
        this.domination = 0;
        if (this.pack != null)
            for (Werewolf werewolf : pack.getWerewolfs()) {
                if (werewolf != null && werewolf != this)
                    if (this.rank != null && werewolf.rank != null)
                        this.domination += werewolf.rank.getValue() - this.rank.getValue();
            }
        setLvl();
    }

    public Rank getRank() {
        return this.rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
        setLvl();
    }

    public int getLvl() {
        return this.lvl;
    }

    /**
     *
     */
    public void setLvl() {
        this.lvl = this.catAge + this.strength + this.domination + (this.rank != null ? this.rank.getValue() : 0);
    }

    public int getImpetuosity() {
        return this.impetuosity;
    }

    public void setImpetuosity(int impetuosity) {
        if (impetuosity < 1)
            impetuosity = 1;
        this.impetuosity = impetuosity;
    }

    public Pack getPack() {
        return this.pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public boolean isInCouple() {
        return this.inRelationship;
    }

    public void setIsCouple(boolean InRelationship) {
        this.inRelationship = InRelationship;
    }

    public void screams(Message message) {
        colony.addHowl(new Howl(this, message));
        System.out.println("A Werewolf just yelled a message: " + message);
    }

    public void entendre(Colony colony) {
        for (Howl howl : colony.getHowls()) {
            if (howl != null && howl.getFrom() != this && random.nextBoolean()) {
                switch (howl.getMessage().getValue()) {
                    case "werewolf_colony" -> {
                        if (this.pack != null && this.pack == howl.getFrom().getPack() && random.nextBoolean()) {
                            this.screams(Message.PACK_ANSWER);
                        }
                    }
                    case "domination" -> {
                        if (howl.getFrom() != this && random.nextBoolean()) {
                            this.screams(Message.SUBMISSION);
                        }
                    }
                    case "submission" -> {
                        if (this.rank != null && howl.getFrom().getRank() != null && this.rank.getValue() > howl.getFrom().getRank().getValue() && random.nextBoolean()) {
                            this.challenge(howl.getFrom());
                        }
                    }
                    case "angry" -> {
                        if (this.rank != null && howl.getFrom().getRank() != null && this.rank.getValue() == howl.getFrom().getRank().getValue() && random.nextBoolean()) {
                            this.challenge(howl.getFrom());
                        }
                    }
                }
            }
        }
    }

    public void becomeHuman() {
        System.out.println("Je suis un humain");
        this.pack.removeWerewolf(this);
    }

    public void die() {
        System.out.println("un Werewolf vient de mourir...");
        this.pack.removeWerewolf(this);
        colony.removeWerewolf(this);
    }

    public void challenge(Werewolf werewolf) {
        System.out.println("un Werewolf vient de défier un autre Werewolf...");
        if (this.getStrength() > werewolf.getStrength()) {
            System.out.println("Le défi a réussi !");
            Rank tmp = werewolf.getRank();
            werewolf.setRank(this.getRank());
            this.setRank(tmp);
            if (this.rank == Rank.ALPHA) {
                this.getPack().addWerewolf(werewolf);
                this.getPack().getCoupleWerewolf().setMale(this);
                this.getPack().addWerewolf(this.getPack().getCoupleWerewolf().getFemale());
                this.getPack().getCoupleWerewolf().setFemale(this.getPack().getBestRankFemale());
            }
        } else {
            System.out.println("Le défi a échoué...");
            werewolf.setStrength(werewolf.getStrength() + werewolf.getCatAge());
            if (this.rank == Rank.BETA && random.nextBoolean()) {
                this.quitPack(colony);
            }
        }
        setDomination();
        if (werewolf.getRank() == Rank.OMEGA && random.nextBoolean())
            werewolf.quitPack(colony);
    }

    public void createPack(Colony colony, Werewolf werewolf) {
        if (this.isMale()) {
            CoupleWerewolf tmp = new CoupleWerewolf(this, werewolf);
            Pack pack = new Pack(tmp, new ArrayList<>(), colony);
            colony.addPack(pack);
            this.pack = pack;
            this.setRank(Rank.ALPHA);
            werewolf.pack = pack;
            werewolf.setRank(Rank.ALPHA);
            System.out.println("A new pack has been created");
        }
    }

    public void joinPack(Colony colony, Pack pack) {
        if (this.pack == null)
            colony.removeWerewolf(this);
        this.pack = pack;
        Rank[] ranks = this.pack.firstRankAvailable();
        this.setRank(ranks[random.nextInt(ranks.length)]);
        pack.addWerewolf(this);
        System.out.println("A Werewolf join a pack !");
    }

    public void quitPack(Colony colony) {
        if (this.pack != null)
            this.pack.removeWerewolf(this);
        this.pack = null;
        this.rank = null;
        colony.addWerewolf(this);
        System.out.println("A Werewolf quit a pack !");
    }

    @Override
    public String toString() {
        return "Werewolf{" +
                "isMale=" + this.isMale +
                ", catAge=" + this.catAge +
                ", strength=" + this.strength +
                ", domination=" + this.domination +
                ", rank=" + this.rank +
                ", lvl=" + this.lvl +
                ", impetuosity=" + this.impetuosity +
                ", pack=" + this.pack +
                ", inRelationship=" + this.inRelationship +
                ", colony=" + this.colony +
                '}';
    }

    public void run() {
        Werewolf werewolf = this.pack.getAllWerewolfs().get(random.nextInt(this.pack.getWerewolfCount()));
        if (werewolf != this) {
            if (this.pack != null && !this.isInCouple() && random.nextBoolean() &&
                    this.getStrength() >= werewolf.getStrength() && random.nextInt(impetuosity) == 0) {
                this.challenge(werewolf);
            }
        }
        if (!inRelationship)
            this.screams(Message.values()[random.nextInt(Message.values().length)]);
        else if (random.nextBoolean())
            this.screams(Message.values()[random.nextInt(1, Message.values().length)]);
        entendre(pack.getColony());
        if ((this.rank == Rank.OMEGA && random.nextBoolean()) || random.nextInt(100) == 0)
            this.becomeHuman();
        if (this.isInCouple() && random.nextBoolean())
            this.getPack().getCoupleWerewolf().reproduction();
    }

    public Colony getColony() {
        return colony;
    }

}
