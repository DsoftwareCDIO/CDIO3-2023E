package dtu.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.JPanel;

public class PropertyTag extends JPanel {
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
