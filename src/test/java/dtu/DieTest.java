package dtu;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dtu.game.Die;

public class DieTest {
    @Test
    public void testDie() {
        int numberofRolls = 1000;
        int[] rolls = new int[6];
        Die die = new Die();
        for (int i = 0; i < numberofRolls; i++) {
            rolls[die.roll()-1]++;
        }
        for (int i : rolls) {
            assertTrue(i < (numberofRolls/6)+30);
            assertTrue(i > (numberofRolls/6)-30);
        }
    }
}
