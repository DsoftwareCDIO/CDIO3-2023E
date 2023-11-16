package dtu;

import java.util.Scanner;

public class CLIUI {
    private static Scanner scanner = new Scanner(System.in);
    public static String[] drawMenu() {
        return new String[]{"Cat", "Dog", "Ship", "Car"};
    }

    public static void drawBoard() {
        System.out.println("Welcome to the game, Monopoly Junior!");
    }

    public static void movePlayer(int position, String player) {
        System.out.println(player + " you are now on field " + position);
    }

    public static void updateFieldOwnership(int fieldId, String player) {
        System.out.println(player + "You are now the proud owner of " + fieldId);
    }

    public static void endGamePodium(String[] players, String loser) {
        for (int i = 1; i <= players.length; i++) {
            System.out.println(i + ". " + players[players.length-i]);
        }
        System.out.println(players.length+1 + ". " + loser);
        scanner.close();
    }    
    
    public static void dieRollResult(int result) {
        System.out.println("You have rolled a " + result);
    }

    public static void waitForRoll() {
        System.out.println("Roll the dice");
        scanner.nextLine();
    }

    public static void updateMoneyInAccount(int money, int moneyTotal, String player, boolean gained) {
        System.out.println(player + ", you " + (gained ? "gained" : "lost") + " " + money + " monobucks, you now have " + moneyTotal + " monobucks");
    }

    public static void showNetWorth(String player) {
       // System.out.println("Nani");
    }

    public static void showChanceCard(String card) {
        System.out.println("You got a chance card:\n" + card);
    }

    public static void updateGetOutOfJailCards(int cardsTotal, boolean gained, String player) {
        System.out.println(player + ", you " + (gained ? "gained" : "used") + " a Get Out Of Jail card, you now have " + cardsTotal + " left");
    }

    public static void updateUniqueCards(boolean gained, String player) {
        System.out.println(player + ", you " + (gained ? "gained" : "used") + " your unique card");
    }

    public static int chooseFieldOnBoard(int[] fields) {
        return 0;
    }
    
    public static int chooseOption(String[] options){
        return 1;
    }
}