package dtu;

import java.util.Arrays;
import java.util.Comparator;

public final class MonopolyJunior {
    protected static Player[] players;
    protected static Board board;
    protected static Die die;
    protected static Player currentPlayer;

    private static boolean gameHasEnded;

    public static void main(String[] args) {
        String[] playerNames = {"Cat", "Dog", "Ship", "Car"};
        // TODO: UI ting for at væle antal spillere
        // TODO: UI ting for at karakterer og rækkefølge af dem vælges
        play(playerNames);
    }

    private static void play(String[] playerNames){
        gameHasEnded = false;
        players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i], i);
        }

        board = new Board(players);
        die = new Die();

        int turn = 0;

        while (!gameHasEnded) {
            currentPlayer = players[turn%4];

            if (currentPlayer.inJail) {
                if (!currentPlayer.getOutOfJail()) {
                    gameHasEnded = true;
                    break;
                }
            }

            if (currentPlayer.useUniqueCard()) {
                int targetField = 0;// TODO: Vælg felt at rykke til med UI
                // Valget er kun mellem frie properties medmindre alle properties af købt, så er alle mulige
                int movement = targetField - currentPlayer.piece.getPosition();
                movement = movement < 0 ? movement + 24 : movement;
                moveOnBoard(movement, true, false);
            } else {
                moveOnBoard(die.roll(), false, false);
            }

            turn++;
        }
        endGame();
    }

    public static void moveOnBoard(int movement, boolean forceBuy, boolean getForFree){
        Field[] fields = board.move(currentPlayer.piece.getPosition(), movement);
        for (Field field : fields) {
            switch (field.getType()) {
                case PROPERTY:
                    landOnProperty((Property)field, forceBuy, getForFree); // Virker måske ikke at kalde metoden sådan her
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
                    break; 
                default:
                    break;
            }
        }
    }

    private static void landOnProperty(Property property, boolean forceBuy, boolean getForFree){
        // TODO: double price if owner has both of the same color
        Player owner = property.getOwner();
        if (owner == currentPlayer) {
            return;
        }
        if (!getForFree) {
            transaction(currentPlayer, -property.getPrice());
        }
        if (gameHasEnded) {
            return;
        }

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
        }
    }

    private static void endGame(){
        gameHasEnded = true;
        Arrays.sort(players, Comparator.comparing(player->player.account.getMoney()));
        // TODO: Opret test for dette
        // Vis dem en efter en, vinder er en første i listen (håber jeg)
    }
}
