package GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClearTextArea extends JTextField implements MouseListener {
    public ClearTextArea() {
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setText("");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // other MouseListener methods not shown
}
