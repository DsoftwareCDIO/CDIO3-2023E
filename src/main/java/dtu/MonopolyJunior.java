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
        //Modtager listen af spillernavne og laver en liste af mængden af spillerne
        players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i], i);
        }

        //Sætter boardet op med 2-4 spillere
        board = new Board(players);
        die = new Die();

        int turn = 0;
        try {
            while (!gameHasEnded) {
                currentPlayer = players[turn%4];

                //Check for om spiller er i fængsel, hvis ja så fjern enten 1 money eller 1 goujc
                if (currentPlayer.inJail) {
                    if (!currentPlayer.getOutOfJail()) {
                        transaction(currentPlayer, -1);
                        if (gameHasEnded) {
                            break;
                        }
                    }
                }

                //Hvis spiller har modtaget specielt(aka ryk felt), så vælger man felt
                if (currentPlayer.useUniqueCard()) {
                    int targetField = 0;
                    // TODO: Vælg felt at rykke til med UI
                    // Valget er kun mellem frie properties medmindre alle properties af købt, så er alle mulige
                    int movement = targetField - currentPlayer.piece.getPosition();
                    movement = movement < 0 ? movement + 24 : movement;
                    moveOnBoard(movement, true, false);
                } else {
                    moveOnBoard(die.roll(), false, false);
                }

                turn++;
            }
        } catch (TransactionImpossibleException e) {
            endGame(e.loser);
        }
    }

    //Flytter spiller til position, switch case for type af felt og hvad der så skal ske
    public static void moveOnBoard(int movement, boolean forceBuy, boolean getForFree) throws TransactionImpossibleException {
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
                    board.cardDeck.draw().activate();
                    break;
                case START:
                    transaction(currentPlayer, 2); 
                    break; 
                default:
                    break;
            }
        }
    }

    private static void landOnProperty(Property property, boolean forceBuy, boolean getForFree) throws TransactionImpossibleException {
        // TODO: double price if owner has both of the same color
        Player owner = property.getOwner();
        if (owner == currentPlayer) {
            return;
        }

        if (owner == null) {
            if (!getForFree) {
                transaction(currentPlayer, -property.getPrice());
                if (gameHasEnded) {
                    return;
                }
            }
            property.setOwner(currentPlayer);
        } else {
            if (forceBuy) {
                transaction(currentPlayer, -property.getPrice());
                if (gameHasEnded) {
                    return;
                }
                property.setOwner(currentPlayer);
                transaction(owner, property.getPrice());
            } else {
                int rent = (owner == property.getSameColor().getOwner() ? 2 : 1);
                transaction(currentPlayer, -property.getPrice() * rent);
                if (gameHasEnded) {
                    return;
                }
                transaction(owner, property.getPrice() * rent);
            }
        }
    }

    //Checker om en spiller kan købe grund, hvis return er false så ender spillet
    public static void transaction(Player player, int money) throws TransactionImpossibleException {
        if (!player.account.changeMoney(money)) {
            // TODO: End game UI ting
            throw new TransactionImpossibleException(player);
        }
    }

    //Laver en liste med spillernes penge og sortere den fra højst til lavest?
    private static void endGame(Player loser){
        gameHasEnded = false;
        Player[] leaderBoard = new Player[players.length-1];
        for (int i=0, k=0; i < players.length; i++){
            if (players[i] != currentPlayer) {
                leaderBoard[k] = players[i];
                k++;
            }
        }

        Arrays.sort(leaderBoard, Comparator.comparing(player->player.account.getMoney()));
        // Leaderboard har en rangeret liste af spillerne, udover personen som tabte

        // TODO: Other players might have 0 money without having lost/gone bancrupt
        // TODO: Opret test for dette
        
    }
}
