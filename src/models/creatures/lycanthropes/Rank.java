package models.creatures.lycanthropes;

public enum Rank {
    Alpha('α'),
    Beta('β'),
    Gamma('γ'),
    Omega('ω');



    private char name;

    Rank(char name) {

        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }



}
