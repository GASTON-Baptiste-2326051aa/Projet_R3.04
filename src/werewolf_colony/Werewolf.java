package werewolf_colony;

import java.util.Random;

/**
 * The `Werewolf` class represents a werewolf in the colony.
 */
public class Werewolf {

    /**
     * Random instance for generating random values.
     */
    public static Random random = new Random();

    /**
     * Indicates if the werewolf is male.
     */
    private boolean isMale;

    /**
     * The category of ages of the werewolf.
     */
    private int catAge;

    /**
     * The colony to which the werewolf belongs.
     */
    private final Colony colony;

    /**
     * The domination level of the werewolf.
     */
    private int domination;

    /**
     * The strength of the werewolf.
     */
    private int strength;

    /**
     * The level of the werewolf.
     */
    private int lvl;

    /**
     * The rank of the werewolf.
     */
    private Rank rank;

    /**
     * The impetuosity of the werewolf.
     */
    private int impetuosity;

    /**
     * Indicates if the werewolf is in a relationship.
     */
    private boolean inRelationship;

    /**
     * The pack to which the werewolf belongs.
     */
    private Pack pack;

    /**
     * Constructor of the Werewolf class.
     * @param isMale the sex of the werewolf
     * @param catAge the category of ages of the werewolf
     * @param strength the strength of the werewolf
     * @param rank the rank of the werewolf
     * @param impetuosity the impetuosity of the werewolf
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
     * Constructor of the Werewolf class.
     * @param isMale the sex of the werewolf
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
     * Returns true if the werewolf is male, otherwise false.
     * @return the sex of the werewolf
     */
    public boolean isMale() {
        return this.isMale;
    }

    /**
     * Sets the gender of the werewolf.
     * @param isMale true if it is a male, otherwise false if it is a female
     */
    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }

    /**
     * Returns the category of ages of the werewolf.
     * @return the category of ages of the werewolf
     */
    public int getCatAge() {
        return this.catAge;
    }

    /**
     * Sets the category of ages of the werewolf.
     * @param catAge the category of ages of the werewolf
     */
    public void setCatAge(int catAge) {
        this.catAge = catAge;
        setLvl();
    }

    /**
     * Increments the age of the werewolf. It dies if it's older than 3 years old.
     * @param colony the colony where the werewolf is
     */
    public void vieillir(Colony colony) {
        this.catAge++;
        if (this.catAge >= 3)
            this.die(colony);
        setLvl();
    }

    /**
     * Converts the category of ages to a string representation.
     * @param catAge the category of ages
     * @return the string representation of the category of ages
     */
    public String catAgeToString(int catAge) {
        return switch (catAge) {
            case 0 -> "Young";
            case 1 -> "Adult";
            default -> "Old";
        };
    }

    /**
     * Returns the strength of the werewolf.
     * @return the strength of the werewolf
     */
    public int getStrength() {
        return this.strength;
    }

    /**
     * Sets the strength of the werewolf.
     * @param strength the strength of the werewolf
     */
    public void setStrength(int strength) {
        if (strength < 0)
            strength = 0;
        this.strength = strength;
        setLvl();
    }

    /**
     * Returns the domination level of the werewolf.
     * @return the domination level of the werewolf
     */
    public int getDomination() {
        return this.domination;
    }

    /**
     * Sets the domination level of the werewolf.
     */
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

    /**
     * Returns the rank of the werewolf.
     * @return the rank of the werewolf
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * Sets the rank of the werewolf.
     * @param rank the rank of the werewolf
     */
    public void setRank(Rank rank) {
        this.rank = rank;
        setLvl();
    }

    /**
     * Returns the level of the werewolf.
     * @return the level of the werewolf
     */
    public int getLvl() {
        return this.lvl;
    }

    /**
     * Sets the level of the werewolf.
     */
    public void setLvl() {
        this.lvl = this.catAge + this.strength + this.domination + (this.rank != null ? this.rank.getValue() : 0);
    }

    /**
     * Returns the impetuosity of the werewolf.
     * @return the impetuosity of the werewolf
     */
    public int getImpetuosity() {
        return this.impetuosity;
    }

    /**
     * Sets the impetuosity of the werewolf.
     * @param impetuosity the impetuosity of the werewolf
     */
    public void setImpetuosity(int impetuosity) {
        if (impetuosity < 1)
            impetuosity = 1;
        this.impetuosity = impetuosity;
    }

    /**
     * Returns the pack to which the werewolf belongs.
     * @return the pack of the werewolf
     */
    public Pack getPack() {
        return this.pack;
    }

    /**
     * Sets the pack of the werewolf.
     * @param pack the pack of the werewolf
     */
    public void setPack(Pack pack) {
        this.pack = pack;
    }

    /**
     * Returns true if the werewolf is in a relationship, otherwise false.
     * @return true if the werewolf is in a relationship, otherwise false
     */
    public boolean isInCouple() {
        return this.inRelationship;
    }

    /**
     * Sets the relationship status of the werewolf.
     * @param inRelationship true if the werewolf is in a relationship, otherwise false
     */
    public void setIsCouple(boolean inRelationship) {
        this.inRelationship = inRelationship;
    }

    /**
     * Makes the werewolf scream a message.
     * @param colony the colony where the werewolf is
     * @param message the message to scream
     */
    public void screams(Colony colony, Message message) {
        colony.addHowl(new Howl(this, message));
        System.out.println("A Werewolf just yelled a message: " + message);
    }

    /**
     * Makes the werewolf scream a message to another werewolf.
     * @param colony the colony where the werewolf is
     * @param to the werewolf to whom the message is directed
     * @param message the message to scream
     */
    public void screams(Colony colony, Werewolf to, Message message) {
        colony.addHowl(new Howl(this, to, message));
        System.out.println("A Werewolf just responded to another Werewolf: " + message);
    }

    /**
     * Makes the werewolf hear howls from the colony.
     * @param colony the colony where the werewolf is
     */
    public void entendre(Colony colony) {
        for (Howl howl : colony.getHowls()) {
            if (howl != null && howl.getFrom() != this && random.nextBoolean()) {
                switch (howl.getMessage().getValue()) {
                    case "werewolf_colony" -> {
                        if (this.pack != null && this.pack == howl.getFrom().getPack() && random.nextBoolean()) {
                            this.screams(colony, howl.getFrom(), Message.PACK_ANSWER);
                        }
                    }
                    case "domination" -> {
                        if (howl.getFrom() != this && random.nextBoolean()) {
                            this.screams(colony, Message.SUBMISSION);
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

    /**
     * Makes the werewolf become human.
     */
    public void becomeHuman() {
        System.out.println("Je suis un humain");
        this.pack.removeWerewolf(this);
    }

    /**
     * Makes the werewolf die.
     * @param colony the colony where the werewolf is
     */
    public void die(Colony colony) {
        System.out.println("un Werewolf vient de mourir...");
        this.pack.removeWerewolf(this);
        colony.removeWerewolf(this);
    }

    /**
     * Makes the werewolf challenge another werewolf.
     * @param werewolf the werewolf to challenge
     */
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

    /**
     * Makes the werewolf create a new pack with another werewolf.
     * @param colony the colony where the werewolf is
     * @param werewolf the werewolf to create the pack with
     */
    public void createPack(Colony colony, Werewolf werewolf) {
        if (this.isMale()) {
            CoupleWerewolf tmp = new CoupleWerewolf(this, werewolf);
            Pack pack = new Pack(tmp, new Werewolf[1000], colony);
            colony.addPack(pack);
            this.pack = pack;
            this.setRank(Rank.ALPHA);
            werewolf.pack = pack;
            werewolf.setRank(Rank.ALPHA);
            System.out.println("A new pack has been created");
        }
    }

    /**
     * Makes the werewolf join an existing pack.
     * @param colony the colony where the werewolf is
     * @param pack the pack to join
     */
    public void joinPack(Colony colony, Pack pack) {
        if (this.pack == null)
            colony.removeWerewolf(this);
        this.pack = pack;
        Rank[] ranks = this.pack.firstRankAvailable();
        this.setRank(ranks[random.nextInt(ranks.length)]);
        pack.addWerewolf(this);
        System.out.println("A Werewolf join a pack !");
    }

    /**
     * Makes the werewolf quit its current pack.
     * @param colony the colony where the werewolf is
     */
    public void quitPack(Colony colony) {
        if (this.pack != null)
            this.pack.removeWerewolf(this);
        this.pack = null;
        this.rank = null;
        colony.addWerewolf(this);
        System.out.println("A Werewolf quit a pack !");
    }

    /**
     * Returns the string representation of the werewolf.
     * @return the string representation of the werewolf
     */
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

    /**
     * Runs the werewolf's activities.
     */
    public void run() {
        Werewolf werewolf = this.pack.getAllWerewolfs()[random.nextInt(this.pack.getWerewolfCount())];
        if (werewolf != this) {
            if (this.pack != null && !this.isInCouple() && random.nextBoolean() &&
                    this.getStrength() >= werewolf.getStrength() && random.nextInt(impetuosity) == 0) {
                this.challenge(werewolf);
            }
        }
        if (!inRelationship)
            this.screams(this.getColony(), Message.values()[random.nextInt(Message.values().length)]);
        else if (random.nextBoolean())
            this.screams(this.getColony(), Message.values()[random.nextInt(1, Message.values().length)]);
        entendre(pack.getColony());
        if ((this.rank == Rank.OMEGA && random.nextBoolean()) || random.nextInt(100) == 0)
            this.becomeHuman();
        if (this.isInCouple() && random.nextBoolean())
            this.getPack().getCoupleWerewolf().reproduction();
    }

    /**
     * Returns the colony to which the werewolf belongs.
     * @return the colony of the werewolf
     */
    public Colony getColony() {
        return colony;
    }
}