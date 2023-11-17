package dtu;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PlayerTest {
    @Test
    void testAccount() {
        Player p = new Player("Test", 0);
        assertTrue(p.account.changeMoney(4));
        assertEquals(4, p.account.getMoney());
        assertTrue(p.account.changeMoney(-2));
        assertEquals(2, p.account.getMoney());
        assertFalse(p.account.changeMoney(-5)); // Goes under 0, so should return false and not change money
        assertEquals(0, p.account.getMoney());
        assertTrue(p.account.changeMoney(0));
        assertEquals(0, p.account.getMoney());
    }

    @Test
    void testPiece() {
        Player p = new Player("Test", 0);
        assertEquals(0, p.piece.getPosition());
        p.piece.setPosition(5);
        assertEquals(5, p.piece.getPosition());
        p.piece.setPosition(23);
        assertEquals(23, p.piece.getPosition());
        p.piece.setPosition(0);
        assertEquals(0, p.piece.getPosition());
    }

    @Test
    void testPlayerInJail() {
        Player p = new Player("Test", 0);
        p.goToJail();
        assertTrue(p.inJail);
        assertFalse(p.getOutOfJail());
        p.addGetOutOfJailCard();
        assertTrue(p.getOutOfJail());
        assertFalse(p.inJail);
        
        p.goToJail();
        assertTrue(p.inJail);
        assertFalse(p.getOutOfJail());
        p.account.changeMoney(1);
        assertTrue(p.getOutOfJail());
        assertFalse(p.inJail);
    }

    @Test
    void testUniqueCard() {
        Player p = new Player("Test", 0);
        assertFalse(p.useUniqueCardIfPossible());
        p.recieveUniqueCard();
        assertTrue(p.useUniqueCardIfPossible());
        assertFalse(p.useUniqueCardIfPossible());
    }
}
