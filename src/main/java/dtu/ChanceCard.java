package dtu;

import java.util.stream.IntStream;

public class ChanceCard {
    protected final int id;

    public ChanceCard(int id) {
        this.id = id;
        // Activate things, description and so on is determined by id
    }

    public void activate() throws TransactionImpossibleException {
        // TODO: switch statement with effects
        int movement;
        int pos;
        switch (id) {
            case 0:
                // effect
                // go 1-5 fields ahead
                pos = MonopolyJunior.currentPlayer.piece.getPosition();
                movement = UIController.chooseFieldOnBoard(IntStream.range(pos+1, pos+6).toArray());
                movePlayerToTarget(movement, false);
                break;
            case 1:
                // effect
                // go one field ahead or take another chancecard
                int choice = UIController.chooseOption(new String[]{"Ryk 1 felt frem", "Træk et nyt kort"});// UI choose an option
                if (choice == 0) {
                    MonopolyJunior.moveOnBoard(1, false, false);
                    break;
                }
                MonopolyJunior.board.cardDeck.draw().activate();
                break;
            case 2:
                // effect
                // get 2 from the bank
                MonopolyJunior.transaction(MonopolyJunior.currentPlayer, 2);
                break;
            case 3:
                // effect
                // pay 2 to the bank
                MonopolyJunior.transaction(MonopolyJunior.currentPlayer, -2);
                break;
            case 4:
                // effect
                // get 1 from each player
                for (Player p : MonopolyJunior.players) {
                    if (p != MonopolyJunior.currentPlayer) {
                        MonopolyJunior.transaction(p, -1);
                    }
                }
                MonopolyJunior.transaction(MonopolyJunior.currentPlayer, MonopolyJunior.players.length-1);
                break;
            case 5:
                // effect
                // get out of jail free card
                MonopolyJunior.currentPlayer.addGetOutOfJailCard();
                break;
            case 6:
                // effect
                // go to start
                movePlayerToTarget(0, false);
                break;
            case 7:
                // effect
                // go to strandpromenaden
                movePlayerToTarget(23, false);
                break;
            case 8:
                // effect
                // go to the skatepark
                // get it for free if its available
                movePlayerToTarget(10, true);

                break;
            case 9:
                // effect
                // go to an orange field
                // get it for free if its availablepos = MonopolyJunior.currentPlayer.piece.getPosition();
                movement = UIController.chooseFieldOnBoard(new int[]{10, 11});
                movePlayerToTarget(movement, true);
                break;
            case 10:
                // effect
                // go to lightblue field
                // get it for free if its available
                movement = UIController.chooseFieldOnBoard(new int[]{4, 5});
                movePlayerToTarget(movement, true);
                break;
            case 11:
                // effect
                // go to a red feild
                // you get it for free if its available
                movement = UIController.chooseFieldOnBoard(new int[]{13, 14});
                movePlayerToTarget(movement, true);
                break;
            case 12:
                // effect
                // go to a light blue or red field
                // get it for free if its available
                movement = UIController.chooseFieldOnBoard(new int[]{4, 5, 13, 14});
                movePlayerToTarget(movement, true);
                break;
            case 13:
                // effect
                // go to a brown or yellow field
                // get it for free if its available
                movement = UIController.chooseFieldOnBoard(new int[]{1, 2, 16, 17});
                movePlayerToTarget(movement, true);
                break;
            case 14:
                // effect
                // go to orange or green
                // get it for free if its available
                movement = UIController.chooseFieldOnBoard(new int[]{10, 11, 19, 20});
                movePlayerToTarget(movement, true);
                break;
            case 15:
                // effect
                // go to a pink or dark blue field
                // get it for free if its available
                movement = UIController.chooseFieldOnBoard(new int[]{7, 8, 22, 23});
                movePlayerToTarget(movement, true);
                break;
            case 16:
                // effect
                // ship gets to choose what field to land on next round
                givePlayerUniqueCard("Ship");
                break;
            case 17:
                // effect
                // cat gets to choose what field to land on next round
                givePlayerUniqueCard("Cat");
                break;
            case 18:
                // effect
                // dog gets to choose what field to land on next round
                givePlayerUniqueCard("Dog");
                break;
            case 19:
                // effect
                // car gets to choose what field to land on next round
                givePlayerUniqueCard("Car");
                break;
            default:
                break;
        }
    }

    //Method to give player a unique card, aka get out of jail and the other card
    private void givePlayerUniqueCard(String name) {
        for (Player p : MonopolyJunior.players) {
            if (p.getName().equals(name)) {
                p.recieveUniqueCard();
            }
        }
    }

    //Method to move a player to a target field
    private void movePlayerToTarget(int target, boolean getForFree) throws TransactionImpossibleException {
        int movement = target - MonopolyJunior.currentPlayer.piece.getPosition();
        //Incase of movement going negative, add 24 so player still recieves start money
        movement = movement < 0 ? movement + 24 : movement;
        MonopolyJunior.moveOnBoard(movement, false, getForFree);
    }
}
