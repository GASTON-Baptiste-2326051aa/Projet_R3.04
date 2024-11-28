package pack;

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
            this.male.setRang(Rank.ALPHA);
        }
        if (!female.isMale()) {
            this.female = female;
            this.female.setIsCouple(true);
            this.female.setRang(Rank.ALPHA);
        }
    }

    public Werewolf getMale() {
        return this.male;
    }

    public void setMale(Werewolf male) {
        this.male.setEnCouple(false);
        if (male.isMale()) {
            this.male = male;
            this.male.setInRelationship(true);
            this.male.setRang(Rank.ALPHA);
        }
    }

    public Werewolf getFemale() {
        return this.female;
    }

    public void setFemale(Werewolf female) {
        this.female.setInRelationship(false);
        if (!female.isMale()) {
            this.female = female;
            this.female.setInRelationship(true);
            this.female.setRang(Rank.ALPHA);
        }
    }

    public void reproduction() {
        Werewolf lycanthrope = new Werewolf(Werewolf.random.nextBoolean(), 0,
                Werewolf.random.nextInt(Math.max(this.male.getForce() + 1, this.female.getForce() + 1)),
                Rank.values()[Werewolf.random.nextInt(1, Rank.values().length)],
                Werewolf.random.nextInt(Math.max(this.male.getImpetuosite() + 1,
                        this.female.getImpetuosite()) + 1), this.male.getMeute(), this.male.getWorld());
        lycanthrope.start();
        System.out.println("Un nouveau lycanthrope est né !");
        this.male.getMeute().addLycanthrope(lycanthrope);
    }
}
