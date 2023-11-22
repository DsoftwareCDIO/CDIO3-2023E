package dtu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import dtu.game.Board;
import dtu.game.Field;
import dtu.game.MonopolyJunior;
import dtu.game.Player;
import dtu.game.TransactionImpossibleException;

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
}
