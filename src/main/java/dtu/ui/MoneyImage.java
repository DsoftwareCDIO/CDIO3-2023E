package dtu.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MoneyImage extends JPanel {
    Image img;

    public MoneyImage(boolean white) {
        if (white) {
            img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/other/monopolybuckswhite.png"));
        } else {
            img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/other/monopolybucksblack.png"));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
