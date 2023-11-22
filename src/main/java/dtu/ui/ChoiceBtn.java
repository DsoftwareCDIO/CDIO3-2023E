package dtu.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChoiceBtn extends JButton {
    protected int id;

    public ChoiceBtn(ImageIcon img, int id) {
        super(img);
        this.id = id;
    }
}
