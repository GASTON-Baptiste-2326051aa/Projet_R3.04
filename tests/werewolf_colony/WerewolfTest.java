package werewolf_colony;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WerewolfTest {
    private Colony colony;
    private Werewolf werewolf;

    @BeforeEach
    void setUp() {
        this.colony = new Colony();
        this.werewolf = new Werewolf(true, 0, 10, Rank.ALPHA, 0, colony);
    }

    @Test
    void isMale() {
        assertTrue(this.werewolf.isMale());
    }

    @Test
    void setMale() {
        this.werewolf.setMale(false);
        assertFalse(this.werewolf.isMale());
    }

    @Test
    void getCatAge() {
        assertEquals(0, this.werewolf.getCatAge());
    }

    @Test
    void setCatAge() {
        this.werewolf.setCatAge(1);
        assertEquals(1, this.werewolf.getCatAge());
    }

    @Test
    void vieillir() {
        Colony colony = new Colony();
        this.werewolf.vieillir(colony);
        assertEquals(1, this.werewolf.getCatAge());
    }

    @Test
    void catAgeToString() {
        assertEquals("Young", this.werewolf.catAgeToString(0));
        assertEquals("Adult", this.werewolf.catAgeToString(1));
        assertEquals("Old", this.werewolf.catAgeToString(2));
    }

    @Test
    void getStrength() {
        assertEquals(10, this.werewolf.getStrength());
    }

    @Test
    void setStrength() {
        this.werewolf.setStrength(20);
        assertEquals(20, this.werewolf.getStrength());
    }

    @Test
    void getDomination() {
        assertEquals(0, this.werewolf.getDomination());
    }

    @Test
    void setDomination() {
        this.werewolf.setDomination();
        assertEquals(0, this.werewolf.getDomination());
    }

    @Test
    void getRank() {
        assertEquals(Rank.ALPHA, this.werewolf.getRank());
    }

    @Test
    void setRank() {
        this.werewolf.setRank(Rank.BETA);
        assertEquals(Rank.BETA, this.werewolf.getRank());
    }

    @Test
    void getLvl() {
        assertEquals(10, this.werewolf.getLvl());
    }

    @Test
    void setLvl() {
        this.werewolf.setLvl();
        assertEquals(10, this.werewolf.getLvl());
    }

    @Test
    void getImpetuosity() {
        assertEquals(0, this.werewolf.getImpetuosity());
    }

    @Test
    void setImpetuosity() {
        this.werewolf.setImpetuosity(5);
        assertEquals(5, this.werewolf.getImpetuosity());
    }

    @Test
    void getPack() {
        assertNull(this.werewolf.getPack());
    }

    @Test
    void setPack() {
        Werewolf werewolf = new Werewolf(false, 0, 10, Rank.ALPHA, 0, colony);
        Werewolf werewolf2 = new Werewolf(true, 0, 10, Rank.ALPHA, 0, colony);
        Pack pack = new Pack(new CoupleWerewolf(werewolf, werewolf2), new Werewolf[100], new Colony());
        this.werewolf.setPack(pack);
        assertEquals(pack, this.werewolf.getPack());
    }

    @Test
    void isEnCouple() {
        assertFalse(this.werewolf.isInCouple());
    }

    @Test
    void setEnCouple() {
        this.werewolf.setIsCouple(true);
        assertTrue(this.werewolf.isInCouple());
    }

    @Test
    void screams() {
        Colony colony = new Colony();
        this.werewolf.screams(colony, Message.ANGRY);
        assertEquals(this.werewolf, colony.getHowls()[0].getFrom());
    }

    @Test
    void testScreams() {
        Colony colony = new Colony();
        Werewolf to = new Werewolf(false, 0, 10, Rank.ALPHA, 0, colony);
        this.werewolf.screams(colony, to, Message.ANGRY);
        assertEquals(this.werewolf, colony.getHowls()[0].getFrom());
    }

//    @Test
//    void entendre() {
//        Colony colony = new Colony();
//        Werewolf from = new Werewolf(false, 0, 10, Rank.ALPHA, 0, null);
//        from.screams(colony, Message.LOVE);
//        this.werewolf.entendre(colony);
//        assertEquals(2, colony.getHurlementCount());
//    }

    @Test
    void challenge() {
        assertTrue(true); // TODO
    }

    @Test
    void creerPack() {
        Colony colony = new Colony();
        Werewolf werewolfs = new Werewolf(false, 0, 10, Rank.ALPHA, 0, colony);
        this.werewolf.createPack(colony, werewolfs);
        assertEquals(1, colony.getPacks()[0].getWerewolfCount());
    }

    @Test
    void rejoindrePack() {
        Colony colony = new Colony();
        Werewolf werewolfs = new Werewolf(false, 0, 10, Rank.ALPHA, 0, colony);
        Werewolf werewolfs2 = new Werewolf(true, 0, 10, Rank.ALPHA, 0, colony);
        werewolfs2.createPack(colony, werewolfs);
        this.werewolf.joinPack(colony, werewolfs2.getPack());
        assertEquals(2, colony.getPacks()[0].getWerewolfCount());
    }

    @Test
    void quitterPack() {
        Colony colony = new Colony();
        Werewolf werewolfs = new Werewolf(false, 0, 10, Rank.ALPHA, 0, colony);
        Werewolf werewolfs2 = new Werewolf(true, 0, 10, Rank.ALPHA, 0, colony);
        werewolfs2.createPack(colony, werewolfs);
        this.werewolf.joinPack(colony, werewolfs2.getPack());
        this.werewolf.quitPack(colony);
        assertEquals(1, colony.getPacks()[0].getWerewolfCount());
    }
}