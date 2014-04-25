package nl.tdegroot.games.Pixelino.entity;

import nl.tdegroot.games.Pixelino.graphics.Screen;
import nl.tdegroot.games.Pixelino.graphics.Sprite;
import nl.tdegroot.games.Pixelino.physics.Collidable;

import java.util.List;

public class Blockerino extends Mob {

    public Blockerino(int x, int y, int width, int height) {
        super(x, y, width, height);
        sprite = new Sprite(width, height, 0x00FF3A);
    }

    public void tick(List<Collidable> entities) {

    }

    public void render(Screen screen) {
        screen.render(this);
    }
}
