package dtu;

import java.util.PriorityQueue;
import java.util.Queue;

public class ChanceCardDeck {
    private Queue<ChanceCard> cards;
    
    public ChanceCardDeck(Player[] players) {
        cards = new PriorityQueue<ChanceCard>();

        // Add cards to queue
    }

    public void draw(MonopolyJunior cont){
        ChanceCard card = cards.poll();
        card.activate(cont);
        cards.add(card);
    }
}
