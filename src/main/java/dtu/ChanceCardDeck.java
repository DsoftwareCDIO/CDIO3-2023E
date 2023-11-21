package dtu;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ChanceCardDeck {
    private Queue<ChanceCard> cards;
    
    //Constructor to create carddeck, adds the special cards depending on players
    public ChanceCardDeck(Player[] players) {
        cards = new LinkedList<>();
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
        // Shuffle carddeck
        Object[] cardsArr =  cards.toArray();
        Collections.shuffle(Arrays.asList(cardsArr));
        for (Object x : cardsArr){ // Remove all cards in queue
            cards.remove(x);
        }
        for (Object x : cardsArr){ // Add the now shuffled cards back into queue
            cards.add((ChanceCard)x);
        }
    }

    //Method to draw card from pile
    public ChanceCard draw(){
        ChanceCard card = cards.poll();
        cards.add(card);
        UIController.showChanceCard(card);
        return card;
    }
}
