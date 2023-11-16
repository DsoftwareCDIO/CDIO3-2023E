package dtu;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
class bg extends JPanel{
    Image img;
    public bg() {
        img = Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Board.png");
    }
    public void paintComponent(Graphics g) {      
        super.paintComponent(g);  
        int scale = Math.min(getWidth(), getHeight());
        g.drawImage(img, (getWidth()/2)-(scale/2), (getHeight()/2)-(scale/2), scale, scale, this);
    } 
}
public class JFrameUI {
    // Temp main method to test JFrame
    public static void main(String[] args){
        testDraw();
        //drawBoard();
    }

    public static void testDraw() {
        JFrame frame = new JFrame();
        // Set to full screen constantly
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        // Program ends when JFrame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background image as board
        JPanel p = new bg();
        p.setBackground(Color.BLACK);
        frame.add(p);

        // Create exit button
        JButton button = new JButton("X");
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.setSize(50, 50);
        button.addActionListener(e -> {
            frame.dispose();
        });

        // Put exit button i ntop right corner
        JPanel exitBtn = new JPanel();
        exitBtn.setBackground(Color.BLACK);
        exitBtn.add(button, BorderLayout.PAGE_START);
        frame.add(exitBtn, BorderLayout.LINE_END);

        // Show frame
        frame.pack();
        frame.setVisible(true);
    }

    public static JFrame drawBoard() {
        //Create objects
        JFrame container = new JFrame();
        JLabel boardLabel = new JLabel();
        ImageIcon boardImage = new ImageIcon("src\\pictures\\Board.png");
        ImageIcon containerIcon = new ImageIcon("src\\pictures\\Icon.png");

        //Set container behavior
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        container.setSize(screenSize.width, screenSize.height);
        container.setVisible(true);
        container.setResizable(true);
        container.setTitle("Monopoly Junior");
        container.setIconImage(containerIcon.getImage());
        boardLabel.setIcon(boardImage);
        boardLabel.setBounds(0, 0, container.getWidth(), container.getHeight());
        container.add(boardLabel);
        /*container.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e){
                
            }
        });*/
        return container;
    }
}
