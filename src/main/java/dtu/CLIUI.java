package dtu;

public class CLIUI {
    public static String[] drawMenu() {
        return new String[]{};
    }

    public static void drawBoard(Player[] players) {

    }

    public static void movePlayer(int position, Player player) {
        System.out.println(player + " you  ");
    }

    public static void updateFieldOwnership(int fieldId, Player player) {

    }

    public static void endGamePodium(Player[] players) {

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