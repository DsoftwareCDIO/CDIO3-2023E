package dtu;

import java.util.Random;

public class Die {
    Random rand = new Random();
    public int roll(){
        return rand.nextInt(6)+1;
    }
}
