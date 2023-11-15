package dtu;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class JFrameUI {
    // Temp main method to test JFrame
    public static void main(String[] args){
        drawBoard();
    }
    public static JFrame drawBoard(){
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
