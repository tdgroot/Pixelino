package nl.tdegroot.games.Pixelino.entity;

import nl.tdegroot.games.Pixelino.physics.BoundingBox;
import nl.tdegroot.games.Pixelino.physics.Collidable;

import java.util.List;

public abstract class Mob extends Entity {

    protected double health;

    public Mob(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void move(int xa, int ya, List<Collidable> entities) {
        if (xa != 0 && ya != 0) {
            move(xa, 0, entities);
            move(0, ya, entities);
            return;
        }
        if (!collision(xa, ya, entities)) {
            x += xa;
            y += ya;
        }
        System.out.println("x: " + x + ", y: " + y);
    }

    protected boolean collision(int xa, int ya, List<Collidable> entities) {
        boundingBox.position.x = x + xa + width / 2;
        boundingBox.position.y = y + ya + height / 2;
        List<Collidable> collidables = entities;
        for (int i = 0; i < collidables.size(); i++) {
            Collidable collidable = collidables.get(i);
            if (collidable == this) continue;
            if (BoundingBox.collides(boundingBox, collidable.getBoundingBox())) return true;
        }
        return false;
    }

}
