package werewolf_colony;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ColonyTest {
    private Colony colony;

    @BeforeEach
    void setUp() {
        this.colony = new Colony();
    }

    @Test
    void testMain() {
        assertTrue(true);
    }

    @Test
    void getHowls() {
        Werewolf werewolf = new Werewolf(true, 0, 0, Rank.ALPHA, 0, this.colony);
        Howl howl = new Howl(werewolf, Message.ANGRY);
        this.colony.addHowl(howl);
        assertEquals(howl, this.colony.getHowls().getFirst());
    }

    @Test
    void addHowl() {
        Werewolf werewolf = new Werewolf(true, 0, 0, Rank.ALPHA, 0, this.colony);
        Howl howl = new Howl(werewolf, Message.ANGRY);
        this.colony.addHowl(howl);
        assertEquals(howl, this.colony.getHowls().getFirst());
    }

    @Test
    void removeHowl() {
        Werewolf werewolf = new Werewolf(true, 0, 0, Rank.ALPHA, 0, this.colony);
        Howl howl = new Howl(werewolf, Message.ANGRY);
        this.colony.addHowl(howl);
        this.colony.removeHowl(howl);
        assertNull(this.colony.getHowls().getFirst());
    }

    @Test
    void updateHowl() {
        Werewolf werewolf = new Werewolf(true, 0, 0, Rank.ALPHA, 0, this.colony);
        Howl howl = new Howl(werewolf, Message.ANGRY);
        this.colony.addHowl(howl);
        this.colony.updateHowl();
        assertEquals(1, this.colony.getHowlCount());
    }

    @Test
    void getHowlCount() {
        Werewolf werewolf = new Werewolf(true, 0, 0, Rank.ALPHA, 0, this.colony);
        Howl howl = new Howl(werewolf, Message.ANGRY);
        this.colony.addHowl(howl);
        assertEquals(1, this.colony.getHowlCount());
    }

    @Test
    void getPacks() {
        Werewolf werewolf = new Werewolf(true, 0, 0, Rank.ALPHA, 0, this.colony);
        Werewolf werewolf2 = new Werewolf(false, 0, 0, Rank.ALPHA, 0, this.colony);
        CoupleWerewolf coupleWerewolf = new CoupleWerewolf(werewolf, werewolf2);
        Pack pack = new Pack(coupleWerewolf, new ArrayList<>(), this.colony);
        this.colony.addPack(pack);
        assertEquals(pack, this.colony.getPacks().getFirst());
    }

    @Test
    void addPack() {
        Werewolf werewolf = new Werewolf(true, 0, 0, Rank.ALPHA, 0, this.colony);
        Werewolf werewolf2 = new Werewolf(false, 0, 0, Rank.ALPHA, 0, this.colony);
        CoupleWerewolf coupleWerewolf = new CoupleWerewolf(werewolf, werewolf2);
        Pack pack = new Pack(coupleWerewolf, new ArrayList<>(), this.colony);
        this.colony.addPack(pack);
        assertEquals(pack, this.colony.getPacks().getFirst());
    }

    @Test
    void getPackCount() {
        Werewolf werewolf = new Werewolf(true, 0, 0, Rank.ALPHA, 0, this.colony);
        Werewolf werewolf2 = new Werewolf(false, 0, 0, Rank.ALPHA, 0, this.colony);
        CoupleWerewolf coupleWerewolf = new CoupleWerewolf(werewolf, werewolf2);
        Pack pack = new Pack(coupleWerewolf, new ArrayList<>(), this.colony);
        this.colony.addPack(pack);
        assertEquals(1, this.colony.getPackCount());
    }

    @Test
    void getWerewolfs() {
        Werewolf werewolf = new Werewolf(true, 0, 0, Rank.ALPHA, 0, this.colony);
        this.colony.addWerewolf(werewolf);
        assertEquals(werewolf, this.colony.getWerewolfs().getFirst());
    }

    @Test
    void addWerewolf() {
        Werewolf werewolf = new Werewolf(true, 0, 0, Rank.ALPHA, 0, this.colony);
        this.colony.addWerewolf(werewolf);
        assertEquals(werewolf, this.colony.getWerewolfs().getFirst());
    }

    @Test
    void removeWerewolf() {
        Werewolf werewolf = new Werewolf(true, 0, 0, Rank.ALPHA, 0, this.colony);
        this.colony.addWerewolf(werewolf);
        this.colony.removeWerewolf(werewolf);
        assertNull(this.colony.getWerewolfs().getFirst());
    }

    @Test
    void getWerewolfCount() {
        Werewolf werewolf = new Werewolf(true, 0, 0, Rank.ALPHA, 0, this.colony);
        this.colony.addWerewolf(werewolf);
        assertEquals(1, this.colony.getWerewolfCount());
    }

    @Test
    void isRunning() {
        assertFalse(this.colony.isRunning());
    }

    @Test
    void setRunning() {
        this.colony.setRunning(false);
        assertFalse(this.colony.isRunning());
    }
}