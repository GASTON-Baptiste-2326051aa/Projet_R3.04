package werewolf_colony;

/**
 * The `CoupleWerewolf` class represents a couple of werewolves.
 */
public class CoupleWerewolf {
    /**
     * The male werewolf in the couple.
     */
    private Werewolf male;

    /**
     * The female werewolf in the couple.
     */
    private Werewolf female;

    /**
     * Constructor of the Werewolf couple class.
     * @param male the male werewolf
     * @param female the female werewolf
     */
    public CoupleWerewolf(Werewolf male, Werewolf female) {
        if (male.isMale()) {
            this.male = male;
            this.male.setIsCouple(true);
            this.male.setRank(Rank.ALPHA);
        }
        if (!female.isMale()) {
            this.female = female;
            this.female.setIsCouple(true);
            this.female.setRank(Rank.ALPHA);
        }
    }

    /**
     * Returns the male werewolf in the couple.
     * @return the male werewolf
     */
    public Werewolf getMale() {
        return this.male;
    }

    /**
     * Sets the male werewolf in the couple.
     * @param male the new male werewolf
     */
    public void setMale(Werewolf male) {
        this.male.setIsCouple(false);
        if (male.isMale()) {
            this.male = male;
            this.male.setIsCouple(true);
            this.male.setRank(Rank.ALPHA);
        }
    }

    /**
     * Returns the female werewolf in the couple.
     * @return the female werewolf
     */
    public Werewolf getFemale() {
        return this.female;
    }

    /**
     * Sets the female werewolf in the couple.
     * @param female the new female werewolf
     */
    public void setFemale(Werewolf female) {
        this.female.setIsCouple(false);
        if (!female.isMale()) {
            this.female = female;
            this.female.setIsCouple(true);
            this.female.setRank(Rank.ALPHA);
        }
    }

    /**
     * Handles the reproduction process for the werewolf couple.
     */
    public void reproduction() {
        int rdm = Werewolf.random.nextInt(7) + 1;
        for (int i = 0; i < rdm; i++) {
            Werewolf werewolf = new Werewolf(Werewolf.random.nextBoolean(), 0,
                Werewolf.random.nextInt(Math.max(this.male.getStrength() + 1, this.female.getStrength() + 1)),
                Rank.values()[Werewolf.random.nextInt(1, Rank.values().length)],
                Werewolf.random.nextInt(Math.max(this.male.getImpetuosity() + 1,
                        this.female.getImpetuosity()) + 1), this.male.getPack());
            System.out.println("Un nouveau werewolf est né !");
            this.male.getPack().addWerewolf(werewolf);
        }
    }
}