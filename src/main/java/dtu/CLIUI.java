package dtu;

public class CLIUI {
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

    public static void endGamePodium(String[] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println(i+1 + ". " + players[players.length-i]);
        }
    }    
    
    public static void dieRollResult(int result) {
        System.out.println("You have rolled a " + result);
    }

    public static void updateMoneyInAccount(int money, Player player, boolean gained) {
        System.out.println(player + " now have " + money + " monobucks");
    }

    public static void showNetWorth(Player player) {
       // System.out.println("Nani");
    }

    public static void showChanceCard(ChanceCard card) {
        
    }

    public static void updateGetOutOfJailCards(int cards, boolean gained, Player player) {

    }

    public static void updateUniqueCards(boolean gained, Player player) {
        
    }

    public static int chooseFieldOnBoard(int[] fields) {
        return 0;
    }
    
    public static int chooseOption(String[] options){
        return 1;
    }

    
}