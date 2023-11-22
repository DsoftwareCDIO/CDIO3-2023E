package dtu.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.JPanel;

class ChanceCardImage extends JPanel {
    HashMap<Integer, Image> playerImages;
    int cardId;

    public ChanceCardImage(int cardId) {
        this.cardId = cardId;
        playerImages = new HashMap<>();
        playerImages.put(0, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-MoveUptoFiveFields.png")));
        playerImages.put(1, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-MoveOneFieldOrDrawAnotherChance.png")));
        playerImages.put(2, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-ReceiveTwo.png")));
        playerImages.put(3, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-PayTwoToBank.png")));
        playerImages.put(4, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-EveryonePaysYouOne.png")));
        playerImages.put(5, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-OutOfJail.png")));
        playerImages.put(6, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-MoveToStart.png")));
        playerImages.put(7, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-MoveToStrandpromenaden.png")));
        playerImages.put(8, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-MoveToSkaterparkenGetFreeOrpay.png")));
        playerImages.put(9, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-MoveToOrangeGetFreeOrPay.png")));
        playerImages.put(10, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-MoveToLightblueGetFreeOrPay.png")));
        playerImages.put(11, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-MoveToRedGetFreeOrPay.png")));
        playerImages.put(12, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-MoveToLightblueOrRedGetFreeOrPay.png")));
        playerImages.put(13, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-MoveToBrownOrYellowGetFreeOrPay.png")));
        playerImages.put(14, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-MoveToOrangeOrGreenGetFreeOrPay.png")));
        playerImages.put(15, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-MoveToPinkOrDarkblueGetFreeOrPay.png")));
        playerImages.put(16, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-ShipUnique.png")));
        playerImages.put(17, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-CatUnique.png")));
        playerImages.put(18, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-DogUnique.png")));
        playerImages.put(19, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-CarUnique.png")));
    }

    public ChanceCardImage(String playerName) {
        playerImages = new HashMap<>();
        switch (playerName) {
            case "Ship":
                playerImages.put(16, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-ShipUnique.png")));
                cardId = 16;
                break;
            case "Car":
                playerImages.put(19, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-CarUnique.png")));
                cardId = 19;
                break;
            case "Cat":
                playerImages.put(17, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-CatUnique.png")));
                cardId = 17;
                break;
            case "Dog":
                playerImages.put(18, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chancecards/Chance-DogUnique.png")));
                cardId = 18;
                break;
            default:
                break;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(playerImages.get(cardId), 0, 0, getWidth(), getHeight(), this);
    }

    public void setNewCardImg(int cardId) {
        this.cardId = cardId;
        paintComponent(getGraphics());
        this.setVisible(true);
    }
}
