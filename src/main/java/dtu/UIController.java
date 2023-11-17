package dtu;

public class UIController {
    private static boolean CLI = true;
    public static String[] drawMenu() {
        if (CLI) {
            return CLIUI.drawMenu();
        }
        return new String[]{};
    }

    public static void drawBoard(Player[] players) {
        String[] playerNames = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            playerNames[i] = players[i].getName();
        }
        if (CLI) {
            CLIUI.drawBoard(playerNames);
        }
    }

    public static void movePlayer(int position, Player player) {
        if (CLI) {
            CLIUI.movePlayer(position, player.getName());
        }
    }

    public static void updateFieldOwnership(int fieldId, Player player) {
        if (CLI) {
            CLIUI.updateFieldOwnership(fieldId, player.getName());
        }
    }

    public static void endGamePodium(Player[] players, Player loser) {
        String[] playerNames = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            playerNames[i] = players[i].getName();
        }
        if (CLI) {
            CLIUI.endGamePodium(playerNames, loser.getName());
        }
    }

    public static void dieRollResult(int result) {
        if (CLI) {
            CLIUI.dieRollResult(result);
        }
    }

    public static void waitForRoll() {
        if (CLI) {
            CLIUI.waitForRoll();
        }
    }

    public static void updateMoneyInAccount(int money, Player player) {
        if (CLI) {
            CLIUI.updateMoneyInAccount(Math.abs(money), player.account.getMoney(), player.getName(), money >= 0);
        }
        else {
            JFrameUI.updateMoneyInAccount(player.account.getMoney(), player.getName(), money >= 0);
        }
    }

    public static void showNetWorth(Player player) {
        if (CLI) {
            CLIUI.showNetWorth(player.getName());
        }
    }

    public static void showChanceCard(ChanceCard card) {
        if (CLI) {
            CLIUI.showChanceCard("" + card.id); // Temporary
        }
    }

    public static void updateGetOutOfJailCards(int cardsTotal, boolean gained, Player player) {
        if (CLI) {
            CLIUI.updateGetOutOfJailCards(cardsTotal, gained, player.getName());
        }
    }

    public static void updateUniqueCards(boolean gained, Player player) {
        if (CLI) {
            CLIUI.updateUniqueCards(gained, player.getName());
        }
    }

    public static int chooseFieldOnBoard(int[] fields) {
        return 0;
    }
    
    public static int chooseOption(String[] options){
        return 1;
    }

    
}
