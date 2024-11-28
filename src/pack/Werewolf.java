package pack;

import java.util.Random;

public class Werewolf extends Thread {

    public static Random random = new Random();
    private boolean isMale;
    private int catAge;
    private int force;
    private int domination;
    private Rank rang;
    private int lvl;
    private int impetuosite;
    private Meute meute;
    private boolean inRelationship;
    private World world;

    /**
     * Constructor the Werewolf class
     * @param isMale
     * @param catAge
     * @param force
     * @param rang
     * @param impetuosite
     * @param meute
     */
    public Werewolf(boolean isMale, int catAge, int force, Rank rang, int impetuosite, Meute meute) {
        this.isMale = isMale;
        this.catAge = catAge;
        this.force = force;
        this.rang = rang;
        this.setImpetuosite(impetuosite);
        this.meute = meute;
        this.inRelationship = false;
        setDomination();
    }

    /**
     *
     * @param isMale
     * @param catAge
     * @param force
     * @param rang
     * @param impetuosite
     * @param meute
     * @param world
     */
    public Werewolf(boolean isMale, int catAge, int force, Rank rang, int impetuosite, Meute meute, World world) {
        this.isMale = isMale;
        this.catAge = catAge;
        this.force = force;
        this.rang = rang;
        this.setImpetuosite(impetuosite);
        this.meute = meute;
        this.world = world;
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
     * @param world
     */
    public void vieillir(World world) {
        this.catAge++;
        if (this.catAge >= 3)
            this.meurt(world);
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
     * Return the force of a werewolf
     * @return
     */
    public int getForce() {
        return this.force;
    }

    public void setForce(int force) {
        if (force < 0)
            force = 0;
        this.force = force;
        setLvl();
    }

    public int getDomination() {
        return this.domination;
    }

    public void setDomination() {
        this.domination = 0;
        if (this.meute != null)
            for (Werewolf lycanthrope : meute.getLycanthropes()) {
                if (lycanthrope != null && lycanthrope != this)
                    if (this.rang != null && lycanthrope.rang != null)
                        this.domination += lycanthrope.rang.getValue() - this.rang.getValue();
            }
        setLvl();
    }

    public Rank getRang() {
        return this.rang;
    }

    public void setRang(Rank rang) {
        this.rang = rang;
        setLvl();
    }

    public int getLvl() {
        return this.lvl;
    }

    /**
     *
     */
    public void setLvl() {
        this.lvl = this.catAge + this.force + this.domination + (this.rang != null ? this.rang.getValue() : 0);
    }

    public int getImpetuosite() {
        return this.impetuosite;
    }

    public void setImpetuosite(int impetuosite) {
        if (impetuosite < 1)
            impetuosite = 1;
        this.impetuosite = impetuosite;
    }

    public Meute getMeute() {
        return this.meute;
    }

    public void setMeute(Meute meute) {
        this.meute = meute;
    }

    public boolean isEnCouple() {
        return this.inRelationship;
    }

    public void setIsCouple(boolean InRelationship) {
        this.inRelationship = InRelationship;
    }

    public void hurle(World world, Message message) {
        world.addHurlement(new Hurlement(this, message));
        System.out.println("A Werewolf just yelled a message: " + message);
    }

    public void hurle(World world, Werewolf to, Message message) {
        world.addHurlement(new Hurlement(this, to, message));
        System.out.println("A Werewolf just responded to another Werewolf : " + message);
    }

    public void entendre(World world) {
        for (Hurlement hurlement : world.getHurlements()) {
            if (hurlement != null && hurlement.getFrom() != this && random.nextBoolean()) {
                switch (hurlement.getMessage().getValue()) {
                    case "love" -> {
                        if (!this.isEnCouple() && this.isMale() & !hurlement.getFrom().isMale()) {
                            if (hurlement.getTo() != null && hurlement.getTo() == this) {
                                this.hurle(world, hurlement.getFrom(), hurlement.getMessage());
                                this.quitterMeute(world);
                                this.creerMeute(world, hurlement.getFrom());
                            } else this.hurle(world, hurlement.getFrom(), hurlement.getMessage());
                        }
                    }
                    case "hate" -> {
                        if (hurlement.getTo() != null && hurlement.getTo() != this) {
                            this.hurle(world, hurlement.getFrom(), hurlement.getMessage());
                        }
                    }
                    case "fear" -> {
                        if (this.getLvl() < hurlement.getFrom().getLvl()) {
                            this.setForce(this.getForce() + 1);
                        } else {
                            this.setForce(this.getForce() - 1);
                        }
                    }
                    case "anger" -> {
                        if (this.getLvl() > hurlement.getFrom().getLvl()) {
                            this.setForce(this.getForce() + 1);
                        } else {
                            this.setForce(this.getForce() - 1);
                        }
                    }
                    case "happiness" -> {
                        if (hurlement.getTo() != null && hurlement.getTo() != this) {
                            this.hurle(world, hurlement.getFrom(), hurlement.getMessage());
                            this.quitterMeute(world);
                            this.rejoindreMeute(world, hurlement.getFrom().getMeute());
                        }
                    }
                    case "sadness" -> {
                        if (hurlement.getTo() != null && hurlement.getTo() != this) {
                            this.hurle(world, hurlement.getFrom(), Message.HAPPINESS);
                        }
                    }
                }
            }
        }
    }

    public void devientHumains() {
        System.out.println("Je suis un humain");
        this.meute.removeLycanthrope(this);
    }

    public void meurt(World world) {
        System.out.println("un Werewolf vient de mourir...");
        this.meute.removeLycanthrope(this);
        world.removeLycanthrope(this);
        try {
            this.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void defier(World world, Werewolf lycanthrope) {
        System.out.println("un Werewolf vient de défier un autre Werewolf...");
        if (this.getForce() > lycanthrope.getForce()) {
            System.out.println("Le défi a réussi !");
            Rank tmp = lycanthrope.getRang();
            lycanthrope.setRang(this.getRang());
            this.setRang(tmp);
            if (this.rang == Rank.ALPHA) {
                this.getMeute().addLycanthrope(lycanthrope);
                this.getMeute().getCoupleLycanthrope().setMale(this);
                this.getMeute().addLycanthrope(this.getMeute().getCoupleLycanthrope().getFemale());
                this.getMeute().getCoupleLycanthrope().setFemale(this.getMeute().getBestRankFemale());
            }
        } else {
            System.out.println("Le défi a échoué...");
            lycanthrope.setForce(lycanthrope.getForce() + lycanthrope.getCatAge());
            if (this.rang == Rank.BETA && random.nextBoolean()) {
                this.quitterMeute(world);
            }
        }
        setDomination();
        if (lycanthrope.getRang() == Rank.OMEGA && random.nextBoolean())
            lycanthrope.quitterMeute(world);
    }

    public void creerMeute(World world, Werewolf lycanthrope) {
        if (this.isMale()) {
            CoupleWerewolf tmp = new CoupleWerewolf(this, lycanthrope);
            Meute meute = new Meute(tmp, new Werewolf[1000], world);
            world.addMeute(meute);
            this.meute = meute;
            this.setRang(Rank.ALPHA);
            lycanthrope.meute = meute;
            lycanthrope.setRang(Rank.ALPHA);
            System.out.println("Une nouvelle meute a été créée !");
        }
    }

    public void rejoindreMeute(World world, Meute meute) {
        if (this.meute == null)
            world.removeLycanthrope(this);
        this.meute = meute;
        Rank[] ranks = this.meute.firstRankAvailable();
        this.setRang(ranks[random.nextInt(ranks.length)]);
        meute.addLycanthrope(this);
        System.out.println("Un Werewolf a rejoint une meute !");
    }

    public void quitterMeute(World world) {
        if (this.meute != null)
            this.meute.removeLycanthrope(this);
        this.meute = null;
        this.rang = null;
        world.addLycanthrope(this);
        System.out.println("Un Werewolf a quitté une meute !");
    }

    @Override
    public String toString() {
        return "Werewolf{" +
                "isMale=" + this.isMale +
                ", catAge=" + this.catAge +
                ", force=" + this.force +
                ", domination=" + this.domination +
                ", rang=" + this.rang +
                ", lvl=" + this.lvl +
                ", impetuosite=" + this.impetuosite +
                ", meute=" + this.meute +
                ", inRelationship=" + this.inRelationship +
                ", world=" + this.world +
                '}';
    }

    @Override
    public void run() {
        while (this.getWorld().isRunning()) {
            Werewolf lycanthrope = this.meute.getAllLycanthropes()[random.nextInt(this.meute.getLycanthropeCount())];
            if (lycanthrope != this) {
                if (this.meute != null && !this.isEnCouple() && random.nextBoolean() &&
                        this.getForce() >= lycanthrope.getForce() && random.nextInt(impetuosite) == 0) {
                    this.defier(meute.getWorld(), lycanthrope);
                }
            }
            if (!inRelationship)
                hurle(this.getWorld(), Message.values()[random.nextInt(Message.values().length)]);
            else if (random.nextBoolean())
                hurle(this.getWorld(), Message.values()[random.nextInt(1, Message.values().length)]);
            entendre(meute.getWorld());
            if ((this.rang == Rank.OMEGA && random.nextBoolean()) || random.nextInt(100) == 0) {
                this.devientHumains();
            }
            if (this.isEnCouple() && random.nextBoolean())
                this.getMeute().getCoupleLycanthrope().reproduction();
        }
        try {
            this.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public World getWorld() {
        return world;
    }

}
