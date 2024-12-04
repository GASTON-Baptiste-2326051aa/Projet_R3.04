package werewolf_colony;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void getValue() {
        assertEquals("pack", Message.PACK.getValue());
    }

    @Test
    void testToString() {
        assertEquals("Message: PACK", Message.PACK.toString());
    }

    @Test
    void values() {
        assertEquals(5, Message.values().length);
    }

    @Test
    void valueOf() {
        assertEquals(Message.PACK, Message.valueOf("PACK"));
    }
}