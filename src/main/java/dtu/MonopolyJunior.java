package dtu;

import java.util.Arrays;
import java.util.Comparator;

public final class MonopolyJunior {
    protected static Player[] players;
    protected static Board board;
    protected static Die die;
    protected static Player currentPlayer;

    public static void main(String[] args) {
        String[] playerNames = {"Cat", "Dog", "Ship", "Car"};
        // TODO: UI ting for at væle antal spillere
        // TODO: UI ting for at karakterer og rækkefølge af dem vælges
        play(playerNames);
    }

    private static void play(String[] playerNames){
        players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i], i);
        }

        board = new Board(players);
        die = new Die();

        int turn = 0;

        while (true) {
            currentPlayer = players[turn%4];

            if (currentPlayer.inJail) {
                if (!currentPlayer.getOutOfJail()) {
                    endGame();
                }
            }

            if (currentPlayer.useUniqueCard()) {
                int targetField = 0;// TODO: Vælg felt at rykke til med UI
                // Valget er kun mellem frie properties medmindre alle properties af købt, så er alle mulige
                int movement = targetField - currentPlayer.piece.getPosition();
                movement = movement < 0 ? movement + 24 : movement;
                moveOnBoard(movement, true);
            } else {
                moveOnBoard(die.roll(), false);
            }

            turn++;
        }
    }

    public static void moveOnBoard(int movement, boolean forceBuy){
        Field[] fields = board.move(currentPlayer.piece.getPosition(), movement);
        for (Field field : fields) {
            switch (field.getType()) {
                case PROPERTY:
                    landOnProperty((Property)field, forceBuy); // Virker måske ikke at kalde metoden sådan her
                    break;
                case JAIL:
                    currentPlayer.goToJail();
                    break;
                case EMPTY:
                    break;
                case CHANCE:
                    //board.cardDeck.draw().activate();
                    break;
                case START:
                    transaction(currentPlayer, 2);  
                default:
                    break;
            }
        }
    }

    private static void landOnProperty(Property property, boolean forceBuy){
        Player owner = property.getOwner();
        if (owner == currentPlayer) {
            return;
        }
        transaction(currentPlayer, -property.getPrice());
        if (owner == null) {
            property.setOwner(currentPlayer);
        }
        else {
            if (forceBuy) {
                property.setOwner(currentPlayer);
            }
            transaction(owner, property.getPrice());
        }
    }

    public static void transaction(Player player, int money){
        if (!player.account.changeMoney(money)) {
            // TODO: End game
            // endGame() og mere visuelt osv.
        };
    }

    private static void endGame(){
        Arrays.sort(players, Comparator.comparing(player->player.account.getMoney()));
        // TODO: Opret test for dette
        // Vis dem en efter en, vinder er en første i listen (håber jeg)
    }
}
