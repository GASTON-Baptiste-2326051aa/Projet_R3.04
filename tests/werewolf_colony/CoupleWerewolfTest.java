package werewolf_colony;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoupleWerewolfTest {
    private Colony colony;
    private Pack pack;
    private CoupleWerewolf coupleWerewolf;

    @BeforeEach
    void setUp() {
        colony = new Colony();
        Werewolf l1 = new Werewolf(true, 0, 0, Rank.ALPHA, 0, colony);
        Werewolf l2 = new Werewolf(false, 0, 0, Rank.ALPHA, 0, colony);
        l1.createPack(colony, l2);
        pack = colony.getPacks().getFirst();
        coupleWerewolf = new CoupleWerewolf(l1, l2);
    }

    @Test
    void getMale() {
        assertEquals(coupleWerewolf.getMale(),  pack.getCoupleWerewolf().getMale());
    }

    @Test
    void setMale() {
        Werewolf l3 = new Werewolf(true, 0, 0, Rank.ALPHA, 0, colony);
        coupleWerewolf.setMale(l3);
        assertEquals(coupleWerewolf.getMale(), l3);
    }

    @Test
    void getFemale() {
        assertEquals(coupleWerewolf.getFemale(), pack.getCoupleWerewolf().getFemale());
    }

    @Test
    void setFemale() {
        Werewolf l4 = new Werewolf(false, 0, 0, Rank.ALPHA, 0, colony);
        coupleWerewolf.setFemale(l4);
        assertEquals(coupleWerewolf.getFemale(), l4);
    }

    @Test
    void reproduction() {
        coupleWerewolf.reproduction();
        assertEquals(1, pack.getWerewolfCount());
    }
}