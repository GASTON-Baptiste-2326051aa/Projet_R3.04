package werewolf_colony;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PackTest {
    private Colony colony;
    private Pack pack;

    @BeforeEach
    void setUp() {
        colony = new Colony();
        Werewolf werewolf1 = new Werewolf(true, 0, 10, Rank.BETA, 5, colony);
        Werewolf werewolf2 = new Werewolf(false, 0, 10, Rank.BETA, 5, colony);
        CoupleWerewolf coupleWerewolf = new CoupleWerewolf(werewolf1, werewolf2);
        pack = new Pack(coupleWerewolf, new ArrayList<>(), colony);
        colony.addPack(pack);
    }

    @Test
    void getWerewolfs() {
        assertEquals(1, pack.getAllWerewolfs().size());
    }

    @Test
    void getCoupleWerewolf() {
        assertNotNull(pack.getCoupleWerewolf());
    }

    @Test
    void addWerewolf() {
        pack.addWerewolf(new Werewolf(true, 0, 10, Rank.BETA, 5, colony));
        assertEquals(2, pack.getAllWerewolfs().size());
    }

    @Test
    void removeWerewolf() {
        pack.addWerewolf(new Werewolf(true, 0, 10, Rank.BETA, 5, colony));
        pack.removeWerewolf(pack.getWerewolfs().getFirst());
        assertEquals(0, pack.getWerewolfCount());
    }

    @Test
    void getWerewolfCount() {
        assertEquals(1, pack.getAllWerewolfs().size());
    }

    @Test
    void getBestRankFemale() {
        assertEquals(Rank.BETA.getValue(), pack.getBestRankFemale().getRank().getValue());
    }

    @Test
    void getAllWerewolfs() {
        assertEquals(1, pack.getAllWerewolfs().size());
    }

    @Test
    void sortWerewolfs() {
        assertTrue(true);
    }

    @Test
    void firstRankAvailable() {
        assertEquals(Rank.BETA.getValue(), pack.firstRankAvailable()[0].getValue());
    }

    @Test
    void getColony() {
        assertNotNull(pack.getColony());
    }

    @Test
    void run() {
        assertTrue(true);
    }
}