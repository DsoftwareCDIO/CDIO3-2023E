package dtu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    public void testMove() {
        Board b = new Board(new Player[]{new Player("Test1", 0), new Player("Test2", 0)});
        
        Field[] results = b.move(0, 0);
        assertEquals(1, results.length);
        assertEquals(0, results[0].getPosition());
        
        results = b.move(0, 12);
        assertEquals(1, results.length);
        assertEquals(12, results[0].getPosition());
        
        results = b.move(23, 0);
        assertEquals(1, results.length);
        assertEquals(23, results[0].getPosition());
        
        results = b.move(20, 4);
        assertEquals(1, results.length);
        assertEquals(0, results[0].getPosition());
        
        results = b.move(22, 5);
        assertEquals(2, results.length);
        assertEquals(0, results[0].getPosition());
        assertEquals(3, results[1].getPosition());
        
    }

    @Test
    public void test() {
        try {
            MonopolyJunior.transaction(new Player("Test", 0), 1);
            fail();
        } catch (TransactionImpossibleException e) {
            // TODO: handle exception
        }

        try {
            MonopolyJunior.transaction(new Player("Test", 0), 1);
            fail();
        } catch (TransactionImpossibleException e) {
            // TODO: handle exception
        }

        try {
            MonopolyJunior.transaction(new Player("Test", 0), 1);
            fail();
        } catch (TransactionImpossibleException e) {
            // TODO: handle exception
        }
    }
}
