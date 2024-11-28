package pack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LycanthropeTest {
    private Werewolf lycanthrope;

    @BeforeEach
    void setUp() {
        this.lycanthrope = new Werewolf(true, 0, 10, Rank.ALPHA, 0, null);
    }

    @Test
    void isMale() {
        assertTrue(this.lycanthrope.isMale());
    }

    @Test
    void setMale() {
        this.lycanthrope.setMale(false);
        assertFalse(this.lycanthrope.isMale());
    }

    @Test
    void getCatAge() {
        assertEquals(0, this.lycanthrope.getCatAge());
    }

    @Test
    void setCatAge() {
        this.lycanthrope.setCatAge(1);
        assertEquals(1, this.lycanthrope.getCatAge());
    }

    @Test
    void vieillir() {
        World world = new World();
        this.lycanthrope.vieillir(world);
        assertEquals(1, this.lycanthrope.getCatAge());
    }

    @Test
    void catAgeToString() {
        assertEquals("Jeune", this.lycanthrope.catAgeToString(0));
        assertEquals("Adulte", this.lycanthrope.catAgeToString(1));
        assertEquals("Vieux", this.lycanthrope.catAgeToString(2));
    }

    @Test
    void getForce() {
        assertEquals(10, this.lycanthrope.getForce());
    }

    @Test
    void setForce() {
        this.lycanthrope.setForce(20);
        assertEquals(20, this.lycanthrope.getForce());
    }

    @Test
    void getDomination() {
        assertEquals(0, this.lycanthrope.getDomination());
    }

    @Test
    void setDomination() {
        this.lycanthrope.setDomination();
        assertEquals(0, this.lycanthrope.getDomination());
    }

    @Test
    void getRang() {
        assertEquals(Rank.ALPHA, this.lycanthrope.getRang());
    }

    @Test
    void setRang() {
        this.lycanthrope.setRang(Rank.BETA);
        assertEquals(Rank.BETA, this.lycanthrope.getRang());
    }

    @Test
    void getLvl() {
        assertEquals(10, this.lycanthrope.getLvl());
    }

    @Test
    void setLvl() {
        this.lycanthrope.setLvl();
        assertEquals(10, this.lycanthrope.getLvl());
    }

    @Test
    void getImpetuosite() {
        assertEquals(0, this.lycanthrope.getImpetuosite());
    }

    @Test
    void setImpetuosite() {
        this.lycanthrope.setImpetuosite(5);
        assertEquals(5, this.lycanthrope.getImpetuosite());
    }

    @Test
    void getMeute() {
        assertNull(this.lycanthrope.getMeute());
    }

    @Test
    void setMeute() {
        Werewolf lycanthrope = new Werewolf(false, 0, 10, Rank.ALPHA, 0, null);
        Werewolf lycanthrope2 = new Werewolf(true, 0, 10, Rank.ALPHA, 0, null);
        Meute meute = new Meute(new CoupleWerewolf(lycanthrope, lycanthrope2), new Werewolf[100], new World());
        this.lycanthrope.setMeute(meute);
        assertEquals(meute, this.lycanthrope.getMeute());
    }

    @Test
    void isEnCouple() {
        assertFalse(this.lycanthrope.isEnCouple());
    }

    @Test
    void setEnCouple() {
        this.lycanthrope.setEnCouple(true);
        assertTrue(this.lycanthrope.isEnCouple());
    }

    @Test
    void hurle() {
        World world = new World();
        this.lycanthrope.hurle(world, Message.LOVE);
        assertEquals(this.lycanthrope, world.getHurlements()[0].getFrom());
    }

    @Test
    void testHurle() {
        World world = new World();
        Werewolf to = new Werewolf(false, 0, 10, Rank.ALPHA, 0, null);
        this.lycanthrope.hurle(world, to, Message.LOVE);
        assertEquals(this.lycanthrope, world.getHurlements()[0].getFrom());
        assertEquals(to, world.getHurlements()[0].getTo());
    }

//    @Test
//    void entendre() {
//        World world = new World();
//        Werewolf from = new Werewolf(false, 0, 10, Rank.ALPHA, 0, null);
//        from.hurle(world, Message.LOVE);
//        this.lycanthrope.entendre(world);
//        assertEquals(2, world.getHurlementCount());
//    }

    @Test
    void defier() {
        assertTrue(true); // TODO
    }

    @Test
    void creerMeute() {
        World world = new World();
        Werewolf lycanthropes = new Werewolf(false, 0, 10, Rank.ALPHA, 0, null);
        this.lycanthrope.creerMeute(world, lycanthropes);
        assertEquals(1, world.getMeutes()[0].getLycanthropeCount());
    }

    @Test
    void rejoindreMeute() {
        World world = new World();
        Werewolf lycanthropes = new Werewolf(false, 0, 10, Rank.ALPHA, 0, null);
        Werewolf lycanthropes2 = new Werewolf(true, 0, 10, Rank.ALPHA, 0, null);
        lycanthropes2.creerMeute(world, lycanthropes);
        this.lycanthrope.rejoindreMeute(world, lycanthropes2.getMeute());
        assertEquals(2, world.getMeutes()[0].getLycanthropeCount());
    }

    @Test
    void quitterMeute() {
        World world = new World();
        Werewolf lycanthropes = new Werewolf(false, 0, 10, Rank.ALPHA, 0, null);
        Werewolf lycanthropes2 = new Werewolf(true, 0, 10, Rank.ALPHA, 0, null);
        lycanthropes2.creerMeute(world, lycanthropes);
        this.lycanthrope.rejoindreMeute(world, lycanthropes2.getMeute());
        this.lycanthrope.quitterMeute(world);
        assertEquals(1, world.getMeutes()[0].getLycanthropeCount());
    }
}