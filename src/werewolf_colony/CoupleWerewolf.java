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
     * Constructor for the `CoupleWerewolf` class.
     * @param male the male werewolf
     * @param female the female werewolf
     */
    public CoupleWerewolf(Werewolf male, Werewolf female) {
        this.male = male;
        this.female = female;
    }

    /**
     * Returns the male werewolf in the couple.
     * @return the male werewolf
     */
    public Werewolf getMale() {
        return male;
    }

    /**
     * Sets the male werewolf in the couple.
     * @param male the male werewolf
     */
    public void setMale(Werewolf male) {
        this.male = male;
    }

    /**
     * Returns the female werewolf in the couple.
     * @return the female werewolf
     */
    public Werewolf getFemale() {
        return female;
    }

    /**
     * Sets the female werewolf in the couple.
     * @param female the female werewolf
     */
    public void setFemale(Werewolf female) {
        this.female = female;
    }

    /**
     * Makes the couple reproduce, creating a new werewolf.
     */
    public void reproduction() {
        // Implementation of reproduction logic
        System.out.println("The couple has reproduced.");
    }

    /**
     * Returns the string representation of the couple.
     * @return the string representation of the couple
     */
    @Override
    public String toString() {
        return "CoupleWerewolf{" +
                "male=" + male +
                ", female=" + female +
                '}';
    }
}