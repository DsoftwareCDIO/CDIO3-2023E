package dtu;

public class Board {
    private Field[] fields;
    protected ChanceCardDeck cardDeck;
    
    public Board(Player[] players) {
        fields = new Field[24];
        // Add fields to list with description, type and inforamtion

        cardDeck = new ChanceCardDeck(players);
    }

    public Field move(Player p, int startPosition, int movement) {
        int endPosition = startPosition + movement;
        if (endPosition >= 24) {
            endPosition %= 24;
            p.account.changeMoney(2);
        }
        return fields[endPosition];
    }
}
