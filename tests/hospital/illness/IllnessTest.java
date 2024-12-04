package hospital.illness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IllnessTest {

    Illness illness;

    @BeforeEach
    void setUp() {
        illness = new Illness(Illnesses.values()[0]);
    }

    @Test
    void getFullName() {
        assertEquals("Maladie débilitante chronique", illness.getFullName());
    }

    @Test
    void getName() {
        assertEquals("MDC", illness.getName());
    }

    @Test
    void getLvl() {
        assertEquals(0, illness.getLvl());
    }

    @Test
    void setLvl() {
        illness.setLvl(5);
        assertEquals(5, illness.getLvl());
        assertThrows(IllegalArgumentException.class, () -> illness.setLvl(11));
        assertThrows(IllegalArgumentException.class, () -> illness.setLvl(-1));
    }

    @Test
    void getLvlMax() {
        assertEquals(7, illness.getLvlMax());
    }

    @Test
    void increase() {
        illness.increase();
        assertEquals(1, illness.getLvl());
        illness.setLvl(7);
        assertThrows(IllegalStateException.class, () -> illness.increase());
    }

    @Test
    void decrease() {
        illness.setLvl(5);
        illness.decrease();
        assertEquals(4, illness.getLvl());
        illness.setLvl(0);
        assertThrows(IllegalStateException.class, () -> illness.decrease());
    }

    @Test
    void is_mortal() {
        assertFalse(illness.is_mortal());
        illness.setLvl(7);
        assertTrue(illness.is_mortal());
    }

    @Test
    void testToString() {
        assertEquals("Illness{name='MDC', fullName='Maladie débilitante chronique', lvl=0, lvlMax=7}", illness.toString());
    }
}