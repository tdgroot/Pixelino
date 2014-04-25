package nl.tdegroot.games.Pixelino.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Timon on 14-4-14.
 */
public class Mouse implements MouseListener, MouseMotionListener {

    private static int x, y;
    private static int button = -1;

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static int getButton() {
        return button;
    }

    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        button = e.getButton();
    }

    public void mouseReleased(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        button = -1;
    }

    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        button = e.getButton();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }
}
