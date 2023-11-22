package dtu.game;

import java.util.Random;

import dtu.UIController;

//6 sided die to roll on turn, same old same old
public class Die {
    Random rand = new Random();
    public int roll(){
        int roll = rand.nextInt(6)+1;
        UIController.dieRollResult(roll, MonopolyJunior.currentPlayer);
        return roll;
    }
}
