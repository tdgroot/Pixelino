package nl.tdegroot.games.Pixelino;

import nl.tdegroot.games.Pixelino.input.Keyboard;
import nl.tdegroot.games.Pixelino.input.Mouse;

import javax.swing.*;

public class Pixelino {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PixelGame game = new PixelGame();
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Pixelino");

        game.start();
    }

}
