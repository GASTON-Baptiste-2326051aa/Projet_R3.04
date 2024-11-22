package pack;

public enum Rank {
    ALPHA(0),
    BETA(1),
    GAMMA(2),
    DELTA(3),
    EPSILON(4),
    ZETA(5),
    ETA(6),
    THETA(7),
    IOTA(8),
    KAPPA(9),
    LAMBDA(10),
    MU(11),
    NU(12),
    XI(13),
    OMICRON(14),
    PI(15),
    RHO(16),
    SIGMA(17),
    TAU(18),
    UPSILON(19),
    PHI(20),
    CHI(21),
    PSI(22),
    OMEGA(23);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
