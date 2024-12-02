package werewolf_colony;

public class CoupleWerewolf {
    private Werewolf male, female;

    /**
     * Constructor of the Werewolf couple class
     * @param male
     * @param female
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

    public Werewolf getMale() {
        return this.male;
    }

    public void setMale(Werewolf male) {
        this.male.setIsCouple(false);
        if (male.isMale()) {
            this.male = male;
            this.male.setIsCouple(true);
            this.male.setRank(Rank.ALPHA);
        }
    }

    public Werewolf getFemale() {
        return this.female;
    }

    public void setFemale(Werewolf female) {
        this.female.setIsCouple(false);
        if (!female.isMale()) {
            this.female = female;
            this.female.setIsCouple(true);
            this.female.setRank(Rank.ALPHA);
        }
    }

    public void reproduction() {
        Werewolf werewolf = new Werewolf(Werewolf.random.nextBoolean(), 0,
                Werewolf.random.nextInt(Math.max(this.male.getStrength() + 1, this.female.getStrength() + 1)),
                Rank.values()[Werewolf.random.nextInt(1, Rank.values().length)],
                Werewolf.random.nextInt(Math.max(this.male.getImpetuosity() + 1,
                        this.female.getImpetuosity()) + 1), this.male.getPack());
        werewolf.start();
        System.out.println("Un nouveau werewolf est né !");
        this.male.getPack().addWerewolf(werewolf);
    }
}
