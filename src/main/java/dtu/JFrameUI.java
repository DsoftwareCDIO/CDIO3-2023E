package dtu;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
class bg extends JPanel{
    Image img;
    public bg() {
        img = Toolkit.getDefaultToolkit().createImage("src\\\\pictures\\\\Board.png");
    }
    public void paintComponent(Graphics g) {      
        super.paintComponent(g);  
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    } 
}
class pl extends JLabel{
    Image img;
    protected int scale;
    public pl() {
    }
    public void paintComponent(Graphics g) {      
        super.paintComponent(g);  
        g.drawOval(0, 0, getWidth(), getHeight());
    } 
}
public class JFrameUI {
    private static pl[] players;

    // Temp main method to test JFrame
    public static void main(String[] args){
        testDraw(new String[]{"Cat"});
        //drawBoard();
    }

    public static void testDraw(String[] playerNames) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame();
        // Set to full screen constantly
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        frame.setBackground(Color.BLACK);
        
        // Program ends when JFrame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background image as board
        JPanel back = new bg();
        back.setBackground(Color.BLACK);
        int scale = (int)Math.min(screenSize.getWidth(), screenSize.getHeight());
        back.setPreferredSize(new Dimension(scale, scale));
        frame.add(back);
        

        // Create exit button
        JButton button = new JButton("X");
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.setSize(50, 50);
        button.addActionListener(e -> {
            frame.dispose();
        });
        c.anchor = GridBagConstraints.NORTHEAST;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(button, c);
        

        // Put exit button i ntop right corner
        /* JPanel exitBtn = new JPanel();
        exitBtn.setBackground(Color.BLACK);
        exitBtn.add(button, FlowLayout.RIGHT);
        frame.add(exitBtn, FlowLayout.LEADING); */

        players = new pl[playerNames.length];
        for (int player = 0; player < playerNames.length; player++) {
            pl p = new pl();
            p.setForeground(Color.RED);
            p.setSize(100,100);               
            c.anchor = GridBagConstraints.EAST;
            frame.add(p, c);
        }
        // Show frame
        frame.pack();
        frame.setVisible(true);
    }

    public static JFrame drawBoard(String[] playerNames) {
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

    public static void movePlayer(int position, Player player) {

    }
}
