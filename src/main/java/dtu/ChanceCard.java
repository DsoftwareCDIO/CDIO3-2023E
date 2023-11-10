package dtu;

public class ChanceCard {
    protected final int id;

    public ChanceCard(int id) {
        this.id = id;
        // Activate things, description and so on is determined by id
    }

    public void activate() {
        // TODO: switch statement with effects
        switch (cardNumber) {
            case 0:
                // effect
                // car gets to choose what field to land on next round
                break;
            case 1:
                // effect
                // go to start
                break;
            case 2:
                // effect
                // go 5 fields ahead
                break;
            case 3:
                // effect
                // go to an orange field
                // get it for free if its available
                break;
            case 4:
                // effect
                // go one field ahead or take another chancecard
                break;
            case 5:
                // effect
                // ship gets to choose what field to land on next round
                break;
            case 6:
                // effect
                // pay 2 to the bank
                break;
            case 7:
                // effect
                // go to orange or green
                // get it for free if its available
                break;
            case 8:
                // effect
                // go to lightblue field
                // get it for free if its available
                break;
            case 9:
                // effect
                // get out of jail free card
                break;
            case 10:
                // effect
                // go to strandpromenaden
                break;
            case 11:
                // effect
                // cat gets to choose what field to land on next round
                break;
            case 12:
                // effect
                // dog gets to choose what field to land on next round
                break;
            case 13:
                // effect
                // get 1 from each player
                break;
            case 14:
                // effect
                // go to a pink or dark blue field
                // get it for free if its available
                break;
            case 15:
                // effect
                // get 2 from the bank
                break;
            case 16:
                // effect
                // go to a red feild
                // you get it for free if its available
                break;
            case 17:
                // effect
                // go to the skatepark
                // get it for free if its available
                break;
            case 18:
                // effect
                // go to a light blue or red field
                // get it for free if its available
                break;
            case 19:
                // effect
                // go to a brown or yellow field
                // get it for free if its available
                break;
        }
    }
}
