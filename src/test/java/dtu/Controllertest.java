package dtu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Controllertest {
    
    @Test
    public void testgetNetWorth() {
        Player p = new Player("Cat", 0);
        Player p2 = new Player("Car", 0);
        Board board = new Board(new Player[]{p});
        Property apartment1 = (Property)(board.getFields()[1]);
        apartment1.setOwner(p);
        //Check for 1 property
        assertEquals(1, MonopolyJunior.getNetWorth(p, board));

        //Check for 2 property
        Property apartment2 = (Property)(board.getFields()[4]);
        apartment2.setOwner(p);
        assertEquals(2, MonopolyJunior.getNetWorth(p, board));

        //Check for other players
        Property apartment3 = (Property)(board.getFields()[14]);
        apartment3.setOwner(p2);
        assertEquals(3, MonopolyJunior.getNetWorth(p2, board));

        //Check for 3 properties, 1 other owner
        Property apartment4 = (Property)(board.getFields()[13]);
        apartment4.setOwner(p);
        assertEquals(5, MonopolyJunior.getNetWorth(p, board));

        //Check for 4 properties
        Property apartment5 = (Property)(board.getFields()[23]);
        apartment5.setOwner(p);
        assertEquals(10, MonopolyJunior.getNetWorth(p, board));
    }
}
