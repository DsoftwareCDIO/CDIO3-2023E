package dtu.game;

import dtu.UIController;

//6 sided die to roll on turn, same old same old
public class DieStub {
    public int roll(){
        int roll = 3;
        UIController.dieRollResult(roll, MonopolyJunior.currentPlayer);
        return roll;
    }
}
