package pack;

public class CoupleLycanthrope {
    private Lycanthrope male, female;

    public CoupleLycanthrope(Lycanthrope male, Lycanthrope female) {
        if (male.isMale()) {
            this.male = male;
            this.male.setEnCouple(true);
            this.male.setRang(Rank.ALPHA);
        }
        if (!female.isMale()) {
            this.female = female;
            this.female.setEnCouple(true);
            this.female.setRang(Rank.ALPHA);
        }
    }

    public Lycanthrope getMale() {
        return this.male;
    }

    public void setMale(Lycanthrope male) {
        this.male.setEnCouple(false);
        if (male.isMale()) {
            this.male = male;
            this.male.setEnCouple(true);
            this.male.setRang(Rank.ALPHA);
        }
    }

    public Lycanthrope getFemale() {
        return this.female;
    }

    public void setFemale(Lycanthrope female) {
        this.female.setEnCouple(false);
        if (!female.isMale()) {
            this.female = female;
            this.female.setEnCouple(true);
            this.female.setRang(Rank.ALPHA);
        }
    }

    public void reproduction() {
        Lycanthrope lycanthrope = new Lycanthrope(Lycanthrope.random.nextBoolean(), 0,
                Lycanthrope.random.nextInt(Math.max(this.male.getForce() + 1, this.female.getForce() + 1)),
                Rank.values()[Lycanthrope.random.nextInt(1, Rank.values().length)],
                Lycanthrope.random.nextInt(Math.max(this.male.getImpetuosite() + 1,
                        this.female.getImpetuosite()) + 1), this.male.getMeute(), this.male.getWorld());
        lycanthrope.start();
        System.out.println("Un nouveau lycanthrope est né !");
        this.male.getMeute().addLycanthrope(lycanthrope);
    }
}
