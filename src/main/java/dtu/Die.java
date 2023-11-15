package dtu;

import java.util.Random;

//6 sided die to roll on turn, same old same old
public class Die {
    Random rand = new Random();
    public int roll(){
        return rand.nextInt(6)+1;
    }
}
