package dtu;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ControllerTest {
    @Test
    void testTransaction() {
        Player p = new Player("Test", 0);
        try {
            MonopolyJunior.transaction(p, -1);
            fail();
        } catch (TransactionImpossibleException e) {
            try {
                MonopolyJunior.transaction(p, 2);
            } catch (TransactionImpossibleException ex) {
                fail();
            }
        }

        try {
            MonopolyJunior.transaction(p, -1);
        } catch (TransactionImpossibleException e) {
            fail();
        }
        try {
            MonopolyJunior.transaction(p, -2);
            fail();
        } catch (TransactionImpossibleException e) {
            try {
                MonopolyJunior.transaction(p, -1);
            } catch (TransactionImpossibleException ex) {
                fail();
            }
        }
    }
}
