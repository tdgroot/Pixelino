package nl.tdegroot.games.Pixelino.entity;

import nl.tdegroot.games.Pixelino.graphics.Screen;
import nl.tdegroot.games.Pixelino.input.Keyboard;
import nl.tdegroot.games.Pixelino.physics.Collidable;

import java.awt.event.KeyEvent;
import java.util.List;

public class Player extends Mob {

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void tick(List<Collidable> entities) {
        int xa = 0, ya = 0;

        if (Keyboard.keyPressed(KeyEvent.VK_A)) xa--;
        if (Keyboard.keyPressed(KeyEvent.VK_S)) ya++;
        if (Keyboard.keyPressed(KeyEvent.VK_W)) ya--;
        if (Keyboard.keyPressed(KeyEvent.VK_D)) xa++;

        if (xa != 0 || ya != 0) move(xa, ya, entities);
    }

    public void render(Screen screen) {
        screen.render(this);
    }

}
