package werewolf_colony;

/**
 * The `Rank` enum represents different ranks that a werewolf can have.
 */
public enum Rank {
    /**
     * Alpha rank.
     */
    ALPHA(0),

    /**
     * Beta rank.
     */
    BETA(1),

    /**
     * Gamma rank.
     */
    GAMMA(2),

    /**
     * Delta rank.
     */
    DELTA(3),

    /**
     * Epsilon rank.
     */
    EPSILON(4),

    /**
     * Zeta rank.
     */
    ZETA(5),

    /**
     * Eta rank.
     */
    ETA(6),

    /**
     * Theta rank.
     */
    THETA(7),

    /**
     * Iota rank.
     */
    IOTA(8),

    /**
     * Kappa rank.
     */
    KAPPA(9),

    /**
     * Lambda rank.
     */
    LAMBDA(10),

    /**
     * Mu rank.
     */
    MU(11),

    /**
     * Nu rank.
     */
    NU(12),

    /**
     * Xi rank.
     */
    XI(13),

    /**
     * Omicron rank.
     */
    OMICRON(14),

    /**
     * Pi rank.
     */
    PI(15),

    /**
     * Rho rank.
     */
    RHO(16),

    /**
     * Sigma rank.
     */
    SIGMA(17),

    /**
     * Tau rank.
     */
    TAU(18),

    /**
     * Upsilon rank.
     */
    UPSILON(19),

    /**
     * Phi rank.
     */
    PHI(20),

    /**
     * Chi rank.
     */
    CHI(21),

    /**
     * Psi rank.
     */
    PSI(22),

    /**
     * Omega rank.
     */
    OMEGA(23);

    /**
     * The value of the rank.
     */
    private final int value;

    /**
     * Constructor for the `Rank` enum.
     * @param value the value of the rank
     */
    Rank(int value) {
        this.value = value;
    }

    /**
     * Returns the value of the rank.
     * @return the value of the rank
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Returns the string representation of the rank.
     * @return the string representation of the rank
     */
    @Override
    public String toString() {
        return this.name();
    }
}