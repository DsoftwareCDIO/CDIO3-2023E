package dtu;

import java.util.Arrays;
import java.util.Comparator;

public final class MonopolyJunior {
    protected Player[] players;
    protected Board board;
    protected Die die;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        // TODO: UI ting for at væle antal spillere
        // TODO: UI ting for at karakterer og rækkefølge af dem vælges
        // play(playerNames);
    }

    private void play(String[] playerNames){
        players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i], i);
        }

        board = new Board(players);
        die = new Die();

        int turn = 0;
        Player currentPlayer;

        while (true) {
            currentPlayer = players[turn%4];

            Field[] fields = board.move(currentPlayer.piece.getPosition(), die.roll());
            for (Field field : fields) {
                switch (field.getType()) {
                    case PROPERTY:
                        landOnProperty(currentPlayer, (Property)field); // Virker måske ikke at kalde metoden sådan her
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

            turn++;
        }
    }


    private void landOnProperty(Player currentPlayer, Property property){
        Player owner = property.getOwner();
        if (owner == currentPlayer) {
            return;
        }
        transaction(currentPlayer, -property.getPrice());
        if (owner == null) {
            property.setOwner(currentPlayer);
        }
        else {
            transaction(owner, property.getPrice());
        }
    }

    /* private void landOnChanceCard(){
        ChanceCard card = board.cardDeck.draw();
        card.activate();
    } */

    private void transaction(Player player, int money){
        if (!player.account.changeMoney(money)) {
            // TODO: End game
            // endGame() og mere visuelt osv.
        };
    }

    private void endGame(){
        Arrays.sort(players, Comparator.comparing(player->player.account.getMoney()));
        // TODO: Opret test for dette
        // Vis dem en efter en, vinder er en første i listen (håber jeg)
    }
}
