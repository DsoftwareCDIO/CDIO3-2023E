package dtu;

import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;

class BoardImage extends JPanel {
    Image img;

    public BoardImage() {
        img = Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Board.png");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}

class MoneyImage extends JPanel {
    Image img;

    public MoneyImage() {
        img = Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\monopolybuckswhite.png");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}

class ChoiceBtn extends JButton {
    protected int id;

    public ChoiceBtn(ImageIcon img, int id) {
        super(img);
        this.id = id;
    }
}

class ChanceCardImage extends JPanel {
    HashMap<Integer, Image> images;
    int cardId;

    public ChanceCardImage(int cardId) {
        this.cardId = cardId;
        images = new HashMap<>();
        images.put(0, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveUptoFiveFields.png"));
        images.put(1, Toolkit.getDefaultToolkit()
                .createImage("src\\\\pictures\\\\Chance-MoveOneFieldOrDrawAnotherChance.png"));
        images.put(2, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-ReceiveTwo.png"));
        images.put(3, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-PayTwoToBank.png"));
        images.put(4, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-EveryonePaysYouOne.png"));
        images.put(5, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-OutOfJail.png"));
        images.put(6, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToStart.png"));
        images.put(7, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToStrandpromenaden.png"));
        images.put(8, Toolkit.getDefaultToolkit()
                .createImage("src\\\\pictures\\\\Chance-MoveToSkaterparkenGetFreeOrpay.png"));
        images.put(9,
                Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToOrangeGetFreeOrPay.png"));
        images.put(10,
                Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToLightblueGetFreeOrPay.png"));
        images.put(11, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToRedGetFreeOrPay.png"));
        images.put(12, Toolkit.getDefaultToolkit()
                .createImage("src\\\\pictures\\\\Chance-MoveToLightblueOrRedGetFreeOrPay.png"));
        images.put(13, Toolkit.getDefaultToolkit()
                .createImage("src\\\\pictures\\\\Chance-MoveToBrownOrYellowGetFreeOrPay.png"));
        images.put(14, Toolkit.getDefaultToolkit()
                .createImage("src\\\\pictures\\\\Chance-MoveToOrangeOrGreenGetFreeOrPay.png"));
        images.put(15, Toolkit.getDefaultToolkit()
                .createImage("src\\\\pictures\\\\Chance-MoveToPinkOrDarkblueGetFreeOrPay.png"));
        images.put(16, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-ShipUnique.png"));
        images.put(17, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-CatUnique.png"));
        images.put(18, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-DogUnique.png"));
        images.put(19, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-CarUnique.png"));
    }

    public ChanceCardImage(String playerName) {
        images = new HashMap<>();
        switch (playerName) {
            case "Ship":
                images.put(16, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-ShipUnique.png"));
                cardId = 16;
                break;
            case "Car":
                images.put(19, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-CarUnique.png"));
                cardId = 19;
                break;
            case "Cat":
                images.put(17, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-CatUnique.png"));
                cardId = 17;
                break;
            case "Dog":
                images.put(18, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-DogUnique.png"));
                cardId = 18;
                break;
            default:
                break;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(images.get(cardId), 0, 0, getWidth(), getHeight(), this);
    }

    public void setNewCardImg(int cardId) {
        this.cardId = cardId;
        paintComponent(getGraphics());
        this.setVisible(true);
    }
}

class PlayerImage extends JPanel {
    HashMap<String, Image> images;
    String playerName;
    int xOffset, yOffset;
    double scaleDivide;

    public PlayerImage(String playerName, int xOffset, int yOffset, double scaleDivide) {
        this.playerName = playerName;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.scaleDivide = scaleDivide;
        images = new HashMap<>();
        images.put("Cat", Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\katcirkel.png"));
        images.put("Car", Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\bilcirkel.png"));
        images.put("Ship", Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\bådcirkel.png"));
        images.put("Dog", Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\hundcirkel.png"));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(images.get(playerName), xOffset, yOffset, (int) (getWidth() / scaleDivide),
                (int) (getHeight() / scaleDivide), this);
    }
}

class RollPanel extends JPanel {
    HashMap<Integer, Image> images;
    int dieResult;

    public RollPanel(LayoutManager lm) {
        super(lm);
        images = new HashMap<>();
        images.put(0, null);
        images.put(1, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\dieOneSide.png"));
        images.put(2, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\dieTwoSide.png"));
        images.put(3, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\dieThreeSide.png"));
        images.put(4, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\dieFourSide.png"));
        images.put(5, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\dieFiveSide.png"));
        images.put(6, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\dieSixSide.png"));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(images.get(dieResult), getHeight() / 4, getHeight() / 4, (int) (getHeight() * 0.7),
                (int) (getHeight() * 0.7), this);
    }

    public void showNewResult(int dieResult) {
        this.dieResult = dieResult;
        paintComponent(getGraphics());
    }
}

class PropertyTag extends JPanel {
    protected int boardScale; 
    private static HashMap<String, Color> playerColors = new HashMap<>();
    private String player;
    public PropertyTag(int boardScale, String player) {
        this.boardScale = boardScale;
        this.player = player;
        playerColors.put("Cat", Color.RED);
        playerColors.put("Car", Color.GREEN);
        playerColors.put("Dog", Color.BLACK);
        playerColors.put("Ship", Color.BLUE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCircle(g, 0, 0, boardScale/40);
    }

    public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
        this.setForeground(playerColors.get(player));
        cg.fillOval(xCenter, yCenter, 2 * r, 2 * r);
        this.setBackground(new Color(0, 0, 0, 0));
    }

    public void setNewPlayer(String player) {
        this.player = player;
        paintComponent(getGraphics());
        this.setVisible(true);
    }
}

public class JFrameUI {
    private static HashMap<String, Color> playerColors = new HashMap<>();
    private static HashMap<String, PlayerImage> players = new HashMap<>();
    private static HashMap<String, JLabel> playerMoney = new HashMap<>();
    private static HashMap<String, JLabel> playerGetOutOfJailCards = new HashMap<>();
    private static HashMap<String, JLabel> playerUniqueCards = new HashMap<>();
    private static HashMap<Integer, PropertyTag> propertyTags = new HashMap<>();
    private static HashMap<Integer, ChoiceBtn> fieldChoices = new HashMap<>();
    private static HashMap<String, JButton> rollBtns = new HashMap<>();
    private static HashMap<String, RollPanel> rollPanels = new HashMap<>();
    private static ChanceCardImage drawnCard;
    private static JButton[] choiceBtns;

    public static boolean btnPressed = false;
    public static int btnChoice = 0;
    private static int boardScale;

    // Temp main method to test JFrame
    public static void main(String[] args) {
        drawBoard(new String[] { "Cat", "Car", "Dog", "Ship" });

        /*
         * for (int i = 0; i < 24; i++) {
         * movePlayer(i, "Cat");
         * movePlayer(i, "Car");
         * movePlayer(i, "Dog");
         * movePlayer(i, "Ship");
         * try {
         * Thread.sleep(500);
         * } catch (Exception e) {
         * // TODO: handle exception
         * }
         * }
         */
        /*
         * waitForRoll("Cat");
         * movePlayer(2, "Cat");
         * waitForRoll("Ship");
         * System.out.println(chooseFieldOnBoard(new int[]{1,2,4,7,8}));
         * System.out.println(chooseFieldOnBoard(new int[]{1,2,4,7,8}));
         * System.out.println(chooseFieldOnBoard(new int[]{1,2,4,7,8}));
         * System.out.println(chooseFieldOnBoard(new int[]{1,2,4,7,8}));
         * waitForRoll("Car");
         */

    }

    public static void drawBoard(String[] playerNames) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        playerColors.put("Cat", Color.RED);
        playerColors.put("Car", Color.GREEN);
        playerColors.put("Dog", Color.BLACK);
        playerColors.put("Ship", Color.BLUE);

        JFrame frame = new JFrame();
        // Set to full screen constantly
        frame.setResizable(false);
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.BLACK);

        // Program ends when JFrame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color backGroundColor = new Color(0, 0, 0);

        // Set background image as board
        JPanel back = new JPanel();
        JPanel left = new JPanel(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());
        boardScale = (int)(screenSize.getHeight()-screenSize.getHeight()/15);
        back.setPreferredSize(new Dimension(boardScale, boardScale));
        left.setPreferredSize(new Dimension((int)(screenSize.getWidth()-boardScale)/2, boardScale));
        right.setPreferredSize(new Dimension((int)(screenSize.getWidth()-boardScale)/2, boardScale));
        right.setBackground(backGroundColor);
        left.setBackground(backGroundColor);

        JPanel backImage = new BoardImage();
        backImage.setPreferredSize(new Dimension(boardScale, boardScale));
        
        int playerWidth = 180;
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
            JPanel panel = i % 2 == 0 ? leftPlayerPanel : rightPlayerPanel;
            JPanel newPanel = new JPanel(new FlowLayout(i > 1 ? FlowLayout.LEFT : FlowLayout.LEADING, 0, 5));
            JPanel img = new PlayerImage(playerNames[i], 0, 0, 1);
            JPanel moneyImg = new MoneyImage();
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
            java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, 80);
            moneyText.setFont(font);
            java.awt.Font smallFont = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, 60);
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
            roll.setFont(new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, 30));
            roll.setVisible(false);
            rollPanel.add(roll);
            rollPanels.put(playerNames[i], rollPanel);
            roll.addActionListener(e -> {
                btnPressed = true;
            });

            (i % 2 == 0 ? leftRollField : rightRollField).add(rollPanel,
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

        choiceBtns = new JButton[2];
        for (int i = 0; i < 2; i++) {
            JButton choiceBtn = new JButton();
            choiceBtn.setBackground(new Color(222, 203, 175));
            choiceBtn.setSize(playerWidth * 2, (int) (playerWidth * 1.8));
            choiceBtn.setText(i == 0 ? "Ryk 1 felt frem" : "Træk et nyt kort");
            java.awt.Font smallFont = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, 40);
            choiceBtn.setFont(smallFont);
            choiceBtn.setLocation(i == 0 ? (int) (playerWidth / 2) : playerWidth * 3, playerWidth * 2);
            choiceBtn.setVisible(false);
            backImage.add(choiceBtn);
            choiceBtns[i] = choiceBtn;
        }
        choiceBtns[0].addActionListener(e -> {
            btnChoice = 0;
            btnPressed = true;
        });
        choiceBtns[1].addActionListener(e -> {
            btnChoice = 1;
            btnPressed = true;
        }); 
        
        int propertyBtnScale = boardScale/10;
        ImageIcon propertyChoiceImg = new ImageIcon("src\\\\pictures\\\\ChoiceArrow.png");
        Image choiceImgTemp = propertyChoiceImg.getImage();
        propertyChoiceImg = new ImageIcon(
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
                    System.out.println(boardScale);
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
                        propertyTag.setLocation(150+(int)(boardScale/7.6*5), (int)(boardScale/4.6 + (boardScale/7.6)*(i*3+j-7)));
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
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void updateGetOutOfJailCards(int cards, String player) {
        playerGetOutOfJailCards.get(player).setText("" + cards);
    }

    public static void updateUniqueCards(boolean gained, String player) {
        playerUniqueCards.get(player).setText(gained ? "1" : "0");
    }

    public static void movePlayer(int position, String player) {
        int xOffset, yOffset;
        int startOffset = boardScale/20;
        int fieldSize = (int)(boardScale/8.2);
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
            } catch (Exception e) {
                // TODO: handle exception
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
        } catch (Exception e) {
            // TODO: handle exception
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
            } catch (Exception e) {
                // TODO: handle exception
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
        } catch (Exception e) {
            // TODO: handle exception
        }
        drawnCard.setVisible(false);
    }

    public static int chooseOption(String[] options) {
        btnPressed = false;
        for (int i = 0; i < options.length; i++) {
            JButton btn = choiceBtns[i];
            btn.setText(options[i]);
            btn.setVisible(true);
        }

        while (!btnPressed) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        for (int i = 0; i < options.length; i++) {
            JButton btn = choiceBtns[i];
            btn.setVisible(false);
        }
        System.out.println(btnChoice);
        return btnChoice;
    }

}
