package dtu.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.JPanel;

public class RollPanel extends JPanel {
    HashMap<Integer, Image> playerImages;
    int dieResult;

    public RollPanel(LayoutManager lm) {
        super(lm);
        playerImages = new HashMap<>();
        playerImages.put(0, null);
        playerImages.put(1, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/dice/dieOneSide.png")));
        playerImages.put(2, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/dice/dieTwoSide.png")));
        playerImages.put(3, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/dice/dieThreeSide.png")));
        playerImages.put(4, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/dice/dieFourSide.png")));
        playerImages.put(5, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/dice/dieFiveSide.png")));
        playerImages.put(6, Toolkit.getDefaultToolkit().getImage(getClass().getResource("/dice/dieSixSide.png")));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(playerImages.get(dieResult), getHeight() / 4, getHeight() / 4, (int) (getHeight() * 0.7),
                (int) (getHeight() * 0.7), this);
    }

    public void showNewResult(int dieResult) {
        this.dieResult = dieResult;
        paintComponent(getGraphics());
    }
}
