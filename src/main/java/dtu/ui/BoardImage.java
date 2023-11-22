package dtu.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BoardImage extends JPanel {
    Image img;

    public BoardImage() {
        img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/other/Board.png"));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
