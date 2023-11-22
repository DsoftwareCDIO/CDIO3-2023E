package dtu.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JFrameUI {
    private static JFrame frame;
    private static HashMap<String, Color> playerColors = new HashMap<>();
    private static HashMap<String, PlayerImage> players = new HashMap<>();
    private static HashMap<String, JLabel> playerMoney = new HashMap<>();
    private static HashMap<String, JLabel> playerGetOutOfJailCards = new HashMap<>();
    private static HashMap<String, JLabel> playerUniqueCards = new HashMap<>();
    private static HashMap<Integer, PropertyTag> propertyTags = new HashMap<>();
    private static HashMap<Integer, ChoiceBtn> fieldChoices = new HashMap<>();
    private static HashMap<String, JButton> rollBtns = new HashMap<>();
    private static HashMap<String, RollPanel> rollPanels = new HashMap<>();
    protected static HashMap<String, Image> playerImages;
    private static ChanceCardImage drawnCard;
    private static ChoiceBtn[] choiceBtns;
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static JPanel characterChoicePanel;
    private static JLabel characterChoiceText;
    private static JLabel startText;
    private static JButton startButton;
    
    public static boolean btnPressed = false;
    public static int btnChoice = 0;
    private static int boardScale;

    // Temp main method to test JFrame
    /* public static void main(String[] args) {
        drawMenu();
        drawBoard(new String[]{"Cat", "Dog"});
        chooseFieldOnBoard(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        endGamePodium(new String[]{"Cat", "Car", "Ship"}, new int[]{15, 4, 2}, "Dog");
    } */

    public static void drawMenu() { 
        playerImages = new HashMap<>();
        playerImages.put("Cat", Toolkit.getDefaultToolkit().getImage(PlayerImage.class.getResource("/playermodel/catcircle.png")));
        playerImages.put("Car", Toolkit.getDefaultToolkit().getImage(PlayerImage.class.getResource("/playermodel/carcircle.png")));
        playerImages.put("Ship", Toolkit.getDefaultToolkit().getImage(PlayerImage.class.getResource("/playermodel/boatcircle.png")));
        playerImages.put("Dog", Toolkit.getDefaultToolkit().getImage(PlayerImage.class.getResource("/playermodel/dogcircle.png")));

        frame = new JFrame();
        // Set to full screen constantly
        frame.setResizable(false);
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        // Program ends when JFrame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        menuPanel.setBackground(new Color(222, 203, 175));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, (int)(screenSize.getHeight()/30));
        JTextArea rules = new JTextArea("Regler: " + System.lineSeparator() + "1. Hvis du ikke har nok penge til at betale huslejen," +
        " købe en ejendom, som du lander på, eller betale afgiften fra et chancekort, er du gået falit! Og så er spillet slut." + 
        System.lineSeparator() + "2. De andre spillere tæller deres penge, og den der har flest, har VUNDET!" + 
        System.lineSeparator() + "3. Uafgjort? Tæl, hvor meget dine ejendomme er værd, og læg det til dine penge" + 
        System.lineSeparator() + "4. Den yngste spiller vælger figur først" +
        System.lineSeparator() + "5. Hvis en spiller ejer begge felter af en farve bliver huslejen dobbelt så stor" +
        System.lineSeparator() + System.lineSeparator() + "Sådan spiller du:" + System.lineSeparator() + "Tryk på knappen 'Rul terning' for at slå" + 
        System.lineSeparator() + "Hvis du får et chancekort hvor du skal rykke dig på brættet skal du trykke på en af de røde pile der viser hvor du kan flytte dig hen");
        rules.setBackground(new Color(222, 203, 175));
        rules.setLineWrap(true);
        rules.setEditable(false);
        rules.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        rules.setMaximumSize(new Dimension((int)(screenSize.getWidth()*0.8), (int)(screenSize.getHeight()*0.8)));
        rules.setFont(font);
        rules.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        menuPanel.add(rules);
        menuPanel.add(Box.createRigidArea(new Dimension(0, (int)(screenSize.getHeight()/20))));

        JButton nextBtn = new JButton("Videre");
        nextBtn.setBackground(Color.GREEN);
        nextBtn.setFont(font);
        nextBtn.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        nextBtn.addActionListener(e -> btnPressed = true);
        menuPanel.add(nextBtn);
        frame.add(menuPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        // Loop to wait for button press
        while (!btnPressed) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        menuPanel.removeAll();
        menuPanel.repaint();
        btnPressed = false;

        menuPanel.add(Box.createRigidArea(new Dimension(0, (int)(screenSize.getHeight()/10))));

        JLabel character = new JLabel("Spiller 1, vælg din karakter");
        character.setFont(font);
        character.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        characterChoiceText = character;
        menuPanel.add(character);
        menuPanel.add(Box.createRigidArea(new Dimension(0, (int)(screenSize.getHeight()/20))));

        JPanel choicePanel = new JPanel();
        choicePanel.setMaximumSize(new Dimension((int)(screenSize.getWidth()/1.42), (int)(screenSize.getHeight()/3.5)));
        choicePanel.setBackground(new Color(222, 203, 175));
        menuPanel.add(choicePanel);
        menuPanel.add(Box.createRigidArea(new Dimension(0, (int)(screenSize.getHeight()/20))));
        characterChoicePanel = choicePanel;

        JLabel fillText = new JLabel("Eller");
        fillText.setFont(font);
        fillText.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        fillText.setVisible(false);
        startText = fillText;
        menuPanel.add(fillText);
        menuPanel.add(Box.createRigidArea(new Dimension(0, (int)(screenSize.getHeight()/20))));

        JButton startBtn = new JButton("Start");
        startBtn.setBackground(Color.GREEN);
        startBtn.setFont(font);
        startBtn.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        startBtn.addActionListener(e -> {
            btnChoice = -1;
            btnPressed = true;
        });
        startBtn.setVisible(false);
        startButton = startBtn;
        menuPanel.add(startBtn);
        
        frame.add(menuPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void drawBoard(String[] playerNames) {
        frame.getContentPane().removeAll();

        playerColors.put("Cat", Color.RED);
        playerColors.put("Car", Color.GREEN);
        playerColors.put("Dog", Color.BLACK);
        playerColors.put("Ship", Color.BLUE);

        Color backGroundColor = new Color(0, 0, 0);

        // Set background image as board
        JPanel back = new JPanel();
        JPanel left = new JPanel(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());
        boardScale = (int)(screenSize.getHeight()-screenSize.getHeight()/10);
        back.setPreferredSize(new Dimension(boardScale, boardScale));
        left.setPreferredSize(new Dimension((int)(screenSize.getWidth()-boardScale)/2, boardScale));
        right.setPreferredSize(new Dimension((int)(screenSize.getWidth()-boardScale)/2, boardScale));
        right.setBackground(backGroundColor);
        left.setBackground(backGroundColor);

        JPanel backImage = new BoardImage();
        backImage.setPreferredSize(new Dimension(boardScale, boardScale));
        
        int playerWidth = boardScale/5;
        double fontScale = (double)boardScale/972;
        JPanel leftPlayerPanel = new JPanel(new BorderLayout());
        leftPlayerPanel.setPreferredSize(new Dimension(playerWidth, boardScale));
        leftPlayerPanel.setBackground(backGroundColor);

        JPanel rightPlayerPanel = new JPanel(new BorderLayout());
        rightPlayerPanel.setPreferredSize(new Dimension(playerWidth, boardScale));
        rightPlayerPanel.setBackground(backGroundColor);

        JPanel rightRollField = new JPanel(new BorderLayout());
        rightRollField.setPreferredSize(new Dimension((int)((screenSize.getWidth()-boardScale)/2-playerWidth), boardScale));
        rightRollField.setBackground(backGroundColor);

        JPanel leftRollField = new JPanel(new BorderLayout());
        leftRollField.setPreferredSize(new Dimension((int)((screenSize.getWidth()-boardScale)/2-playerWidth), boardScale));
        leftRollField.setBackground(backGroundColor);

        for (int i = 0; i < playerNames.length; i++) {
            JPanel panel = (i == 0 || i == 3) ? leftPlayerPanel : rightPlayerPanel;
            JPanel newPanel = new JPanel(new FlowLayout(i > 1 ? FlowLayout.LEFT : FlowLayout.LEADING, 0, 5));
            JPanel img = new PlayerImage(playerNames[i], 0, 0, 1);
            JPanel moneyImg = new MoneyImage(true);
            JLabel moneyText = new JLabel("0");
            JPanel jailCardImg = new ChanceCardImage(5);
            JLabel jailCardText = new JLabel("0");
            JPanel jailPanel = new JPanel(new FlowLayout(i > 1 ? FlowLayout.LEFT : FlowLayout.LEADING, 0, 0));
            JPanel uniqueCardImg = new ChanceCardImage(playerNames[i]);
            JLabel uniqueCardText = new JLabel("0");
            JPanel uniquePanel = new JPanel(new FlowLayout(i > 1 ? FlowLayout.LEFT : FlowLayout.LEADING, 0, 0));
            newPanel.setPreferredSize(new Dimension(100, (int) (playerWidth * 2.3)));
            newPanel.setBackground(backGroundColor);
            img.setBackground(backGroundColor);
            img.setPreferredSize(new Dimension(playerWidth, playerWidth));
            moneyImg.setPreferredSize(new Dimension(playerWidth / 3, playerWidth / 3));
            moneyImg.setBackground(backGroundColor);
            moneyText.setForeground(Color.WHITE);
            java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, (int)(80*fontScale));
            moneyText.setFont(font);
            java.awt.Font smallFont = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, (int)(60*fontScale));
            jailCardImg.setPreferredSize(new Dimension(playerWidth / 2, playerWidth / 4));
            jailCardImg.setBackground(backGroundColor);
            jailCardText.setForeground(Color.WHITE);
            jailCardText.setFont(smallFont);
            jailPanel.setPreferredSize(new Dimension(playerWidth, playerWidth / 3));
            jailPanel.setBackground(backGroundColor);
            jailPanel.add(jailCardText);
            jailPanel.add(jailCardImg);
            uniqueCardImg.setPreferredSize(new Dimension(playerWidth / 2, playerWidth / 4));
            uniqueCardImg.setBackground(backGroundColor);
            uniqueCardText.setForeground(Color.WHITE);
            uniqueCardText.setFont(smallFont);
            uniquePanel.setPreferredSize(new Dimension(playerWidth, playerWidth / 3));
            uniquePanel.setBackground(backGroundColor);
            uniquePanel.add(uniqueCardText);
            uniquePanel.add(uniqueCardImg);
            if (i > 1) {
                newPanel.add(uniquePanel);
                newPanel.add(jailPanel);
                newPanel.add(moneyText);
                newPanel.add(moneyImg);
                newPanel.add(img);
            } else {
                newPanel.add(img);
                newPanel.add(moneyText);
                newPanel.add(moneyImg);
                newPanel.add(jailPanel);
                newPanel.add(uniquePanel);
            }
            RollPanel rollPanel = new RollPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
            rollPanel.setBackground(backGroundColor);
            rollPanel.setPreferredSize(new Dimension(1, playerWidth));
            JButton roll = new JButton("Slå terning");
            roll.setBackground(new Color(222, 203, 175));
            roll.setForeground(Color.BLACK);
            roll.setFont(new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, (int)(30*fontScale)));
            roll.setVisible(false);
            rollPanel.add(roll);
            rollPanels.put(playerNames[i], rollPanel);
            roll.addActionListener(e -> btnPressed = true);
            ((i == 0 || i == 3) ? leftRollField : rightRollField).add(rollPanel,
                    i > 1 ? BorderLayout.SOUTH : BorderLayout.NORTH);
            panel.add(newPanel, i > 1 ? BorderLayout.SOUTH : BorderLayout.NORTH);

            rollBtns.put(playerNames[i], roll);
            playerMoney.put(playerNames[i], moneyText);
            playerGetOutOfJailCards.put(playerNames[i], jailCardText);
            playerUniqueCards.put(playerNames[i], uniqueCardText);
        }

        backImage.setLayout(null);
        drawnCard = new ChanceCardImage(0);
        drawnCard.setLocation(boardScale/4,boardScale/3);
        drawnCard.setSize(new Dimension(boardScale/2,boardScale/4));
        drawnCard.setVisible(false);
        backImage.add(drawnCard);

        choiceBtns = new ChoiceBtn[2];
        for (int i = 0; i < 2; i++) {
            ChoiceBtn choiceBtn = new ChoiceBtn(null, i);
            choiceBtn.setBackground(new Color(222, 203, 175));
            choiceBtn.setSize(boardScale / 3, boardScale / 3);
            choiceBtn.setText(i == 0 ? "Ryk 1 felt frem" : "Træk et nyt kort");
            java.awt.Font smallFont = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, (int)(40*fontScale));
            choiceBtn.setFont(smallFont);
            choiceBtn.setLocation(i == 0 ? boardScale / 7 : (int)(boardScale / 1.9), boardScale / 3);
            choiceBtn.setVisible(false);
            choiceBtn.addActionListener(e -> 
            {
                btnChoice = ((ChoiceBtn) e.getSource()).id;
                btnPressed = true;
            });
            choiceBtns[i] = choiceBtn;
            backImage.add(choiceBtn);
        }
        
        int propertyBtnScale = boardScale/10;
        Image choiceImgTemp = Toolkit.getDefaultToolkit().getImage(ChoiceBtn.class.getResource("/other/ChoiceArrow.png"));
        ImageIcon propertyChoiceImg = new ImageIcon(
        choiceImgTemp.getScaledInstance(propertyBtnScale, propertyBtnScale, Image.SCALE_DEFAULT));

        for (int i = 0; i < 24; i++) {
            ChoiceBtn btn = new ChoiceBtn(propertyChoiceImg, i);
            btn.setSize(new Dimension(propertyBtnScale, propertyBtnScale));
            btn.setBackground(Color.WHITE);
            btn.addActionListener(e -> {
                btnChoice = ((ChoiceBtn) e.getSource()).id;
                btnPressed = true;
            });
            fieldChoices.put(i, btn);
            btn.setVisible(false);

            switch (i/6) {
                    case 0:
                        btn.setLocation(boardScale/5+(int)(boardScale/7.6)*(i-1), boardScale/25);
                        break;
                    case 1:
                        btn.setLocation((int)(boardScale/4.5+boardScale/7.6*5), (int)(boardScale/5.6 + (boardScale/7.6)*(i-7)));
                        break;
                    case 2:
                        btn.setLocation(boardScale/5+(int)(boardScale/7.6)*(17-i), boardScale/5+(int)(boardScale/7.6)*5);
                        break;
                    case 3:
                        btn.setLocation(boardScale/20, (int)(boardScale/5.6+(boardScale/7.6)*(23-i)));
                        break;
                    default:
                        break;
                }
                
            backImage.add(btn);
        }
        
        int[] xOffsets = new int[]{0, boardScale/20, 0, boardScale/20};
        int[] yOffsets = new int[]{0, 0, boardScale/20, boardScale/20};
        for (int i = 0; i < playerNames.length; i++) {
            PlayerImage player = new PlayerImage(playerNames[i], xOffsets[i], yOffsets[i], 1.9);
            player.setSize(new Dimension(boardScale/10, boardScale/10));
            player.setLocation(boardScale/20, boardScale/20);
            player.setBackground(new Color(255, 255, 255, 0));
            player.setForeground(playerColors.get(playerNames[i]));
            player.setOpaque(false);
            players.put(playerNames[i], player);
            backImage.add(player);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 1; j <= 2; j++) {
                PropertyTag propertyTag = new PropertyTag(boardScale, "Cat");
                propertyTag.setSize(new Dimension(boardScale/18, boardScale/18));
                propertyTag.setBackground(new Color(255, 255, 255, 0));
                propertyTags.put(i * 3 + j, propertyTag);
                switch (i / 2) {
                    case 0:
                        propertyTag.setLocation((int)(boardScale/4.6 + (boardScale/7.6)*(3*i+j-1)), (int)(boardScale/7.2));
                        break;
                    case 1:
                        propertyTag.setLocation((int)(boardScale/6.7)+(int)(boardScale/7.6*5), (int)(boardScale/4.6 + (boardScale/7.6)*(i*3+j-7)));
                        break;
                    case 2:
                        propertyTag.setLocation((int)(boardScale/4.6 + (boardScale/7.6)*(17-i*3-j)), (int)(boardScale/7.2+(boardScale/7.6)*5));
                        break;
                    case 3:
                        propertyTag.setLocation((int)(boardScale/6.7), (int)(boardScale/4.6 + (boardScale/7.6)*(23-3*i-j)));
                        break;
                    default:
                        break;
                }
                propertyTag.setVisible(false);
                propertyTag.setOpaque(false);
                backImage.add(propertyTag);
            }
        }

        left.add(leftPlayerPanel, BorderLayout.WEST);
        right.add(rightPlayerPanel, BorderLayout.EAST);

        left.add(leftRollField, BorderLayout.EAST);
        right.add(rightRollField, BorderLayout.WEST);

        // Show frame
        back.add(backImage, BorderLayout.CENTER);
        frame.add(left, BorderLayout.WEST);
        frame.add(right, BorderLayout.EAST);
        frame.add(back, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void updateMoneyInAccount(int money, String player, boolean gained) {
        try {
            playerMoney.get(player).setForeground(gained ? Color.GREEN : Color.RED);
            Thread.sleep(500);
            playerMoney.get(player).setText("" + money);
            Thread.sleep(500);
            playerMoney.get(player).setForeground(Color.WHITE);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void updateGetOutOfJailCards(int cards, String player) {
        playerGetOutOfJailCards.get(player).setText("" + cards);
    }

    public static void updateUniqueCards(boolean gained, String player) {
        playerUniqueCards.get(player).setText(gained ? "1" : "0");
    }

    public static void movePlayer(int position, String player) {
        int xOffset;
        int yOffset;
        int startOffset = boardScale/20;
        int fieldSize = (int)(boardScale/7.4);
        if (position <= 5) {
            xOffset = position * fieldSize + startOffset;
            yOffset = startOffset;
        } else if (position > 5 && position <= 12) {
            xOffset = 6 * fieldSize + startOffset;
            yOffset = (position - 6) * fieldSize + startOffset;
        } else if (position > 12 && position <= 18) {
            xOffset = (18 - position) * fieldSize + startOffset;
            yOffset = 6 * fieldSize + startOffset;
        } else {
            xOffset = startOffset;
            yOffset = (24 - position) * fieldSize + startOffset;
        }
        players.get(player).setLocation(xOffset, yOffset);
    }

    public static void updateFieldOwnership(int position, String player) {
        propertyTags.get(position).setNewPlayer(player);
    }

    public static void waitForRoll(String player) {
        btnPressed = false;
        JButton btn = rollBtns.get(player);
        btn.setVisible(true);

        while (!btnPressed) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        btn.setVisible(false);
    }

    public static void dieRollResult(int result, String player) {
        RollPanel r = rollPanels.get(player);
        r.showNewResult(result);
        try {
            Thread.sleep(500);
            r.showNewResult(0);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static int chooseFieldOnBoard(int[] fields) {
        btnPressed = false;
        for (int field : fields) {
            ChoiceBtn btn = fieldChoices.get(field);
            btn.setVisible(true);
        }

        while (!btnPressed) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        for (int field : fields) {
            ChoiceBtn btn = fieldChoices.get(field);
            btn.setVisible(false);
        }
        return btnChoice;
    }

    public static void showChanceCard(int cardId) {
        drawnCard.setNewCardImg(cardId);
        try {
            Thread.sleep(cardId > 15 ? 5000 : 3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        drawnCard.setVisible(false);
    }

    public static int chooseOption(String[] options) {
        btnPressed = false;
        for (int i = 0; i < options.length; i++) {
            ChoiceBtn btn = choiceBtns[i];
            btn.setText(options[i]);
            btn.setVisible(true);
        }

        while (!btnPressed) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        for (int i = 0; i < options.length; i++) {
            JButton btn = choiceBtns[i];
            btn.setVisible(false);
        }
        System.out.println(btnChoice);
        return btnChoice;
    }

    public static int chooseCharacter(String[] options, int playerNum) {
        characterChoiceText.setText("Player " + playerNum + ", vælg din karakter");
        if (playerNum > 2) {
            startButton.setVisible(true);
            startText.setVisible(true);
        }
        for (int i = 0; i < options.length; i++) {
            if (options[i].equals("")) {
                continue;
            }
            Image choiceTemp = playerImages.get(options[i]);
            ImageIcon choiceImg = new ImageIcon(choiceTemp.getScaledInstance((int)(screenSize.getHeight()/4), (int)(screenSize.getHeight()/4), Image.SCALE_DEFAULT));
            ChoiceBtn choiceBtn = new ChoiceBtn(choiceImg, i);
            choiceBtn.setSize(new Dimension((int)(screenSize.getHeight()/4), (int)(screenSize.getHeight()/4)));
            choiceBtn.setBackground(Color.WHITE);
            choiceBtn.setBorder(null);
            choiceBtn.setOpaque(false);
            choiceBtn.setLocation(i * (int)(screenSize.getHeight()/3), 0);
            choiceBtn.addActionListener(e -> {
                btnChoice = ((ChoiceBtn) e.getSource()).id;
                btnPressed = true;
            });
            characterChoicePanel.add(choiceBtn);
            characterChoicePanel.paintComponents(characterChoicePanel.getGraphics());
        }

        while (!btnPressed) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        characterChoicePanel.removeAll();
        characterChoicePanel.paint(characterChoicePanel.getGraphics());
        btnPressed = false;
        return btnChoice;
    }

    public static void endGamePodium(String[] players, int[] money, String loser) {
        try {
            Thread.sleep(1000);
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        panel.setBackground(new Color(222, 203, 175));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0, (int)(screenSize.getHeight()/20))));
        JLabel text1;
        switch (loser) {
            case "Cat":
                text1 = new JLabel("Kat er gået bankerot og har tabt, og spillet er slut");
                break;
            case "Dog":
                text1 = new JLabel("Hund er gået bankerot og har tabt, og spillet er slut");
                break;
            case "Car":
                text1 = new JLabel("Bil er gået bankerot og har tabt, og spillet er slut");
                break;
            default:
                text1 = new JLabel("Skib er gået bankerot og har tabt, og spillet er slut");
                break;
        }
        JLabel text2 = new JLabel("Her er ranglisten");
        JLabel text3 = new JLabel("(Hvis nogle står lige, bliver det vurderet efter værdien af ens ejendomme)");
        java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, (int)(screenSize.getHeight()/30));
        text1.setFont(font);
        text1.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        text2.setFont(font);
        text2.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        text3.setFont(font);
        text3.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        panel.add(text1);
        panel.add(text2);
        panel.add(text3);
        panel.add(Box.createRigidArea(new Dimension(0, (int)(screenSize.getHeight()/10))));

        font = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, (int)(screenSize.getHeight()/10));
        for (int i = 0; i < players.length+1; i++) {
            JPanel playerRanking = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
            playerRanking.setMaximumSize(new Dimension((int)(screenSize.getWidth()/3), (int)(screenSize.getHeight()/7)));
            playerRanking.setBackground(new Color(222, 203, 175));

            JLabel rankText = new JLabel(i+1 + ".");
            rankText.setFont(font);

            PlayerImage playerImg = new PlayerImage(i == players.length ? loser : players[i], 0, 0, 1);
            playerImg.setOpaque(false);
            playerImg.setPreferredSize(new Dimension((int)(screenSize.getHeight()/8), (int)(screenSize.getHeight()/8)));

            JLabel moneyText = new JLabel("" + (i == players.length ? 0 : money[i]));
            moneyText.setFont(font);

            MoneyImage moneyImg = new MoneyImage(false);
            moneyImg.setOpaque(false);
            moneyImg.setPreferredSize(new Dimension((int)(screenSize.getHeight()/12), (int)(screenSize.getHeight()/12)));

            playerRanking.add(rankText);
            playerRanking.add(playerImg);
            playerRanking.add(moneyText);
            playerRanking.add(moneyImg);
            panel.add(playerRanking);
        }
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.repaint();
    }
}
