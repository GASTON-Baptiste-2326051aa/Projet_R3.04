package werewolf_colony;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HowlTest {
    private Werewolf from;
    private Howl howl;

    @BeforeEach
    void setUp() {
        from = new Werewolf(true, 0, 0, Rank.ALPHA, 0, null);
        howl = new Howl(from, Message.PACK);
    }

    @Test
    void getFrom() {
        assertEquals(from, howl.getFrom());
    }

    @Test
    void getMessage() {
        assertEquals(Message.PACK, howl.getMessage());
    }

    @Test
    void getTime() {
        assertTrue(howl.getTime() <= System.currentTimeMillis());
    }
}