package dtu;

public class UIController {
    private static boolean CLI = false;
    public static String[] drawMenu() {
        if (CLI) {
            return CLIUI.drawMenu();
        }
        return new String[]{"Cat", "Dog", "Ship"};
    }

    public static void drawBoard(Player[] players, int startCapital) {
        String[] playerNames = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            playerNames[i] = players[i].getName();
        }
        if (CLI) {
            CLIUI.drawBoard(playerNames);
        } else {
            JFrameUI.drawBoard(playerNames);
            for (Player player : players) {
                UIController.updateMoneyInAccount(startCapital, player);
            }
        }
    }

    public static void movePlayer(int position, Player player) {
        if (CLI) {
            CLIUI.movePlayer(position, player.getName());
        } else {
            JFrameUI.movePlayer(position, player.getName());
        }
    }

    public static void updateFieldOwnership(int fieldId, Player player) {
        if (CLI) {
            CLIUI.updateFieldOwnership(fieldId, player.getName());
        } else {
            JFrameUI.updateFieldOwnership(fieldId, player.getName());
        }
    }

    public static void endGamePodium(Player[] players, Player loser) {
        String[] playerNames = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            playerNames[i] = players[i].getName();
        }
        if (CLI) {
            CLIUI.endGamePodium(playerNames, loser.getName());
        } else {
            System.out.println("SLUT");
        }
    }

    public static void dieRollResult(int result, Player player) {
        if (CLI) {
            CLIUI.dieRollResult(result);
        } else {
            JFrameUI.dieRollResult(result, player.getName());
        }
    }

    public static void waitForRoll(Player player) {
        if (CLI) {
            CLIUI.waitForRoll();
        } else {
            JFrameUI.waitForRoll(player.getName());
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
        } else {
            JFrameUI.showChanceCard(card.id);
        }
    }

    public static void updateGetOutOfJailCards(int cardsTotal, boolean gained, Player player) {
        if (CLI) {
            CLIUI.updateGetOutOfJailCards(cardsTotal, gained, player.getName());
        } else {
            JFrameUI.updateGetOutOfJailCards(cardsTotal, player.getName());
        }
    }

    public static void updateUniqueCards(boolean gained, Player player) {
        if (CLI) {
            CLIUI.updateUniqueCards(gained, player.getName());
        } else {
            JFrameUI.updateUniqueCards(gained, player.getName());
        }
    }

    public static int chooseFieldOnBoard(int[] fields) {
        if (CLI) {
            return 0;
        } else {
            return JFrameUI.chooseFieldOnBoard(fields);
        }
    }
    
    public static int chooseOption(String[] options){
        if (CLI) {
            return 0;
        } else {
            return JFrameUI.chooseOption(options);
        }
    }

    
}
