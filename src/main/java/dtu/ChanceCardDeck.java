package dtu;

import java.util.PriorityQueue;
import java.util.Queue;

public class ChanceCardDeck {
    private Queue<ChanceCard> cards;
    
    public ChanceCardDeck(Player[] players) {
        cards = new PriorityQueue<>();
        for (int i = 0; i < 20 - (4 - players.length); i++) {
            // Add cards to queue
        }
    }

    public ChanceCard draw(){
        ChanceCard card = cards.poll();
        cards.add(card);
        return card;
    }
}
