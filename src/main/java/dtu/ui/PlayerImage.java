package dtu.ui;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PlayerImage extends JPanel {
    String playerName;
    int xOffset;
    int yOffset;
    double scaleDivide;

    public PlayerImage(String playerName, int xOffset, int yOffset, double scaleDivide) {
        this.playerName = playerName;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.scaleDivide = scaleDivide;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(JFrameUI.playerImages.get(playerName), xOffset, yOffset, (int) (getWidth() / scaleDivide),
                (int) (getHeight() / scaleDivide), this);
    }
}
