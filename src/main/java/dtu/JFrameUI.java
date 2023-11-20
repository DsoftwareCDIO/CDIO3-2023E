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
import java.awt.Toolkit;
class BoardImage extends JPanel{
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
class MoneyImage extends JPanel{
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

class ChoiceBtn extends JButton{
    protected int id;
    public ChoiceBtn(ImageIcon img, int id) {
        super(img);
        this.id = id;
    }
}

class ChanceCardImage extends JPanel{
    HashMap<Integer, Image> images;
    int cardId;
    public ChanceCardImage(int cardId) {
        this.cardId = cardId;
        images = new HashMap<>();
        images.put(0, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveUptoFiveFields.png"));
        images.put(1, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveOneFieldOrDrawAnotherChance.png"));
        images.put(2, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-ReceiveTwo.png"));
        images.put(3, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-PayTwoToBank.png"));
        images.put(4, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-EveryonePaysYouOne.png"));
        images.put(5, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-OutOfJail.png"));
        images.put(6, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToStart.png"));
        images.put(7, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToStrandpromenaden.png"));
        images.put(8, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToSkaterparkenGetFreeOrpay.png"));
        images.put(9, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToOrangeGetFreeOrPay.png"));
        images.put(10, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToLightblueGetFreeOrPay.png"));
        images.put(11, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToRedGetFreeOrPay.png"));
        images.put(12, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToLightblueOrRedGetFreeOrPay.png"));
        images.put(13, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToBrownOrYellowGetFreeOrPay.png"));
        images.put(14, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToOrangeOrGreenGetFreeOrPay.png"));
        images.put(15, Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Chance-MoveToPinkOrDarkblueGetFreeOrPay.png"));
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

class PlayerImage extends JPanel{
    HashMap<String, Image> images;
    String playerName;
    public PlayerImage(String playerName) {
        this.playerName = playerName;
        images = new HashMap<>();
        images.put("Cat", Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\katcirkel.png"));
        images.put("Car", Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\bilcirkel.png"));
        images.put("Ship", Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\bådcirkel.png"));
        images.put("Dog", Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\hundcirkel.png"));
    }
    @Override
    public void paintComponent(Graphics g) {      
        super.paintComponent(g);  
        g.drawImage(images.get(playerName), 0, 0, getWidth(), getHeight(), this);
    } 
    public void setNewPlayerImg(String player) {
        playerName = player;
        paintComponent(getGraphics());
        this.setVisible(true);
    }
}

class PlayerPiece extends JPanel {
    protected int scale, xOffset, yOffset; 
    public PlayerPiece(int scale, int xOffset, int yOffset) {
        this.scale = scale;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCircle(g, xOffset, yOffset, scale/50);
    }
    public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
        cg.fillOval(xCenter, yCenter, 2*r, 2*r);
    }
}


public class JFrameUI {
    private static HashMap<String, Color> playerColors = new HashMap<>();
    private static HashMap<String, PlayerPiece> players = new HashMap<>();
    private static HashMap<String, JLabel> playerMoney = new HashMap<>();
    private static HashMap<String, JLabel> playerGetOutOfJailCards = new HashMap<>();
    private static HashMap<String, JLabel> playerUniqueCards = new HashMap<>();
    private static HashMap<Integer, PlayerImage> propertyTags = new HashMap<>();
    private static HashMap<Integer, ChoiceBtn> fieldChoices = new HashMap<>();
    private static HashMap<String, JButton> rollBtns = new HashMap<>();
    private static ChanceCardImage drawnCard;

    public static boolean btnPressed = false;
    public static int btnChoice = 0;

    // Temp main method to test JFrame
    public static void main(String[] args){
        drawBoard(new String[]{"Cat", "Car", "Dog", "Ship"});
        waitForRoll("Cat");
        movePlayer(2, "Cat");
        waitForRoll("Ship");
        System.out.println(chooseFieldOnBoard(new int[]{1,2,4,7,8}));
        System.out.println(chooseFieldOnBoard(new int[]{1,2,4,7,8}));
        System.out.println(chooseFieldOnBoard(new int[]{1,2,4,7,8}));
        System.out.println(chooseFieldOnBoard(new int[]{1,2,4,7,8}));
        waitForRoll("Car");

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
        int scale = (int)(screenSize.getHeight()-screenSize.getHeight()/15);
        back.setPreferredSize(new Dimension(scale, scale));
        left.setPreferredSize(new Dimension((int)(screenSize.getWidth()-scale)/2, scale));
        right.setPreferredSize(new Dimension((int)(screenSize.getWidth()-scale)/2, scale));
        right.setBackground(backGroundColor);
        left.setBackground(backGroundColor);
        
        JPanel backImage = new BoardImage
    ();
        backImage.setPreferredSize(new Dimension(scale, scale));
        
        int playerWidth = 180;
        JPanel leftPlayerPanel = new JPanel(new BorderLayout());
        leftPlayerPanel.setPreferredSize(new Dimension(playerWidth, scale));
        leftPlayerPanel.setBackground(backGroundColor);

        JPanel rightPlayerPanel = new JPanel(new BorderLayout());
        rightPlayerPanel.setPreferredSize(new Dimension(playerWidth, scale));
        rightPlayerPanel.setBackground(backGroundColor);

        JPanel rightRollField = new JPanel(new BorderLayout());
        rightRollField.setPreferredSize(new Dimension((int)((screenSize.getWidth()-scale)/2-playerWidth), scale));
        rightRollField.setBackground(backGroundColor);

        JPanel leftRollField = new JPanel(new BorderLayout());
        leftRollField.setPreferredSize(new Dimension((int)((screenSize.getWidth()-scale)/2-playerWidth), scale));
        leftRollField.setBackground(backGroundColor);

        for (int i = 0; i < playerNames.length; i++) {
            JPanel panel = i % 2 == 0 ? leftPlayerPanel : rightPlayerPanel;
            JPanel newPanel = new JPanel(new FlowLayout(i > 1 ? FlowLayout.LEFT : FlowLayout.LEADING, 0, 5));
            JPanel img = new PlayerImage(playerNames[i]);
            JPanel moneyImg = new MoneyImage();
            JLabel moneyText = new JLabel("0");
            JPanel jailCardImg = new ChanceCardImage(5);
            JLabel jailCardText = new JLabel("0");
            JPanel jailPanel = new JPanel(new FlowLayout(i > 1 ? FlowLayout.LEFT : FlowLayout.LEADING, 0, 0));
            JPanel uniqueCardImg = new ChanceCardImage(playerNames[i]);
            JLabel uniqueCardText = new JLabel("0");
            JPanel uniquePanel = new JPanel(new FlowLayout(i > 1 ? FlowLayout.LEFT : FlowLayout.LEADING, 0, 0));
            newPanel.setPreferredSize(new Dimension(100, (int)(playerWidth*2.3)));
            newPanel.setBackground(backGroundColor);
            img.setBackground(backGroundColor);
            img.setPreferredSize(new Dimension(playerWidth, playerWidth));
            moneyImg.setPreferredSize(new Dimension(playerWidth/3, playerWidth/3));
            moneyImg.setBackground(backGroundColor);
            moneyText.setForeground(Color.WHITE);
            java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, 80);
            moneyText.setFont(font);
            java.awt.Font smallFont = new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, 60);
            jailCardImg.setPreferredSize(new Dimension(playerWidth/2, playerWidth/4));
            jailCardImg.setBackground(backGroundColor);
            jailCardText.setForeground(Color.WHITE);
            jailCardText.setFont(smallFont);
            jailPanel.setPreferredSize(new Dimension(playerWidth, playerWidth/3));
            jailPanel.setBackground(backGroundColor);
            jailPanel.add(jailCardText);
            jailPanel.add(jailCardImg);
            uniqueCardImg.setPreferredSize(new Dimension(playerWidth/2, playerWidth/4));
            uniqueCardImg.setBackground(backGroundColor);
            uniqueCardText.setForeground(Color.WHITE);
            uniqueCardText.setFont(smallFont);
            uniquePanel.setPreferredSize(new Dimension(playerWidth, playerWidth/3));
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
            JPanel rollField = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
            rollField.setBackground(backGroundColor);
            JButton roll = new JButton("Slå terning");
            roll.setBackground(new Color(222, 203, 175));
            roll.setForeground(Color.BLACK);
            roll.setFont(new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, 30));
            roll.setVisible(false);
            rollField.add(roll);
            roll.addActionListener(e ->
            {
                btnPressed = true;
            }); 
            
            (i % 2 == 0 ? leftRollField : rightRollField).add(rollField, i > 1 ? BorderLayout.SOUTH : BorderLayout.NORTH);
            panel.add(newPanel, i > 1 ? BorderLayout.SOUTH : BorderLayout.NORTH);

            rollBtns.put(playerNames[i], roll);
            playerMoney.put(playerNames[i], moneyText);
            playerGetOutOfJailCards.put(playerNames[i], jailCardText);
            playerUniqueCards.put(playerNames[i], uniqueCardText);
        }


        int[] xOffsets = new int[]{0, scale/25, 0, scale/25};
        int[] yOffsets = new int[]{0, 0, scale/25, scale/25};
        
        backImage.setLayout(null);
        ChanceCardImage chanceCard = new ChanceCardImage(0);
        chanceCard.setLocation(scale/4,scale/3);
        chanceCard.setSize(new Dimension(scale/2,scale/4));
        chanceCard.setVisible(false);
        backImage.add(chanceCard);
        drawnCard = chanceCard;

        for (int i = 0; i < playerNames.length; i++) {
            PlayerPiece player = new PlayerPiece(scale, xOffsets[i], yOffsets[i]);
            player.setLocation(60, 60);
            player.setSize(new Dimension(scale/10, scale/10));
            player.setBackground(new Color(255, 255, 255, 0));
            player.setForeground(playerColors.get(playerNames[i]));
            players.put(playerNames[i], player);
            backImage.add(player);
        }

        int btnScale = scale/10;
        ImageIcon choiceImg = new ImageIcon("src\\\\pictures\\\\ChoiceArrow.png");
        Image choiceImgTemp = choiceImg.getImage();
        choiceImg = new ImageIcon(choiceImgTemp.getScaledInstance(btnScale, btnScale, Image.SCALE_DEFAULT));

        for (int i = 0; i < 24; i++) {
            ChoiceBtn btn = new ChoiceBtn(choiceImg, i);
            btn.setSize(new Dimension(btnScale, btnScale));
            btn.setBackground(Color.WHITE);
            btn.addActionListener(e ->
            {
                btnChoice = ((ChoiceBtn)e.getSource()).id;
                btnPressed = true;
            }); 
            fieldChoices.put(i, btn);
            btn.setVisible(false);

            switch (i/6) {
                    case 0:
                        btn.setLocation(200+(int)(scale/7.6)*(i-1), 40);
                        break;
                    case 1:
                        btn.setLocation(220+(int)(scale/7.6*5), 180+(int)(scale/7.6)*(i-7));
                        break;
                    case 2:
                        btn.setLocation(200+(int)(scale/7.6)*(17-i), 200+(int)(scale/7.6)*5);
                        break;
                    case 3:
                        btn.setLocation(50, 180+(int)(scale/7.6)*(23-i));
                        break;
                    default:
                        break;
                }
                
            backImage.add(btn);
        }


        for (int i = 0; i < 8; i++) {
            for (int j = 1; j <= 2; j++) {
                

                PlayerImage propertyTag = new PlayerImage("Cat");
                propertyTag.setSize(new Dimension(scale/18, scale/18));
                propertyTag.setBackground(new Color(255, 255, 255, 1));
                propertyTags.put(i*3+j, propertyTag);
                switch (i/2) {
                    case 0:
                        propertyTag.setLocation(220+(int)(scale/7.6)*(3*i+j-1), 140);
                        break;
                    case 1:
                        propertyTag.setLocation(150+(int)(scale/7.6*5), 220+(int)(scale/7.6)*(i*3+j-7));
                        break;
                    case 2:
                        propertyTag.setLocation(220+(int)(scale/7.6)*(17-i*3-j), 140+(int)(scale/7.6)*5);
                        break;
                    case 3:
                        propertyTag.setLocation(150, 220+(int)(scale/7.6)*(23-3*i-j));
                        break;
                    default:
                        break;
                }
                propertyTag.setVisible(false);
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
        int startOffset = 60;
        int fieldSize = 135;
        if (position <= 5) {
            xOffset = position*fieldSize+60;
            yOffset = startOffset;
        }
        else if (position > 5 && position <= 12) {
            xOffset = 6*fieldSize+startOffset;
            yOffset = (position-6)*fieldSize+startOffset;
        }
        else if (position > 12 && position <= 18) {
            xOffset = (18-position)*fieldSize+startOffset;
            yOffset = 6*fieldSize+startOffset;
        }
        else {
            xOffset = startOffset;
            yOffset = (24-position)*fieldSize+startOffset;
        }
        players.get(player).setLocation(xOffset, yOffset);
    }

    public static void updateFieldOwnership(int position, String player) {
        propertyTags.get(position).setNewPlayerImg(player);
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


}
