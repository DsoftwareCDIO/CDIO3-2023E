package dtu;

import java.util.PriorityQueue;
import java.util.Queue;

public class ChanceCardDeck {
    private Queue<ChanceCard> cards;
    
    //Constructor to create carddeck, adds the special cards depending on players
    public ChanceCardDeck(Player[] players) {
        cards = new PriorityQueue<>();
        for (int i = 0; i < 16; i++) {
            cards.add(new ChanceCard(i));
        }
        for (Player player : players) {
            switch (player.getName()) {
                case "Cat":
                    cards.add(new ChanceCard(17));
                    break;
                case "Dog":
                    cards.add(new ChanceCard(18));
                    break;
                case "Ship":
                    cards.add(new ChanceCard(16));
                    break;
                case "Car":
                    cards.add(new ChanceCard(19));
                    break;
            }
        }
    }

    //Method to draw card from pile
    public ChanceCard draw(){
        ChanceCard card = cards.poll();
        cards.add(card);
        return card;
    }
}
